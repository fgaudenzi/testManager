package eu.cumulus.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.log4j.Logger;
import org.cumulus.certificate.model.test.GeneralCollectorType;
import org.cumulus.certificate.model.test.TestCaseType;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.QueueingConsumer;

import cumulus.components.auditing.client.xmpp.CumulusEventSerialized;
import cumulus.xmpp.sender.Sender;
import eu.cumulus.utilities.TestManagerHelperMethods;
import eu.cumulus.engine.CertificationEvaluator;

public class RabbitConsumer implements Runnable {
	static final String EXCHANGE_NAME="collector_agents";
	private  Connection conn ;
	private  Channel channel;
	private Logger log;
	private ArrayList<String> collectors,agents;
	private HashMap <String,CertificationEvaluator> checkers;
	public RabbitConsumer() throws Exception{
		 log=Logger.getLogger(RabbitConsumer.class);
	/*	char[] keyPassphrase = "MySecretPassword".toCharArray();
	      KeyStore ks = KeyStore.getInstance("PKCS12");
	      ks.load(new FileInputStream("/Users/iridium/Jobs/client/keycert.p12"), keyPassphrase);

	      KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	      String passphrase="pass1234";
		kmf.init(ks, keyPassphrase);

	      char[] trustPassphrase = "pass1234".toCharArray();
	      KeyStore tks = KeyStore.getInstance("JKS");
	      tks.load(new FileInputStream("/Users/iridium/Servers/rabbitmq_server-3.3.4/rabbitstore"), trustPassphrase);

	      TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	      tmf.init(tks);

	      SSLContext c = SSLContext.getInstance("SSLv3");
	      c.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
	      

	      ConnectionFactory factory = new ConnectionFactory();
	      factory.setHost("localhost");
	      factory.setVirtualHost("testManager");
	      factory.setPort(5671);
	      factory.useSslProtocol(c);
	      factory.setUsername("agent");
	      factory.setPassword("pass1234");*/
		  checkers=new HashMap<String,CertificationEvaluator>();
		  char[] keyPassphrase = TestManagerHelperMethods.getProperty("rabbit.certificate-pwd", log).toCharArray();
	      KeyStore ks = KeyStore.getInstance("PKCS12");
	      ks.load(new FileInputStream(TestManagerHelperMethods.getProperty("rabbit.certificate", log)),keyPassphrase);
	      // ks.load(new FileInputStream("/Users/iridium/Jobs/client/keycert.p12"), keyPassphrase);

	      KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	      
	      String passphrase="pass1234";//TODO:???
	      kmf.init(ks, keyPassphrase);
	      char[] trustPassphrase = TestManagerHelperMethods.getProperty("rabbit.truststore-pwd", log).toCharArray();
	      KeyStore tks = KeyStore.getInstance("JKS");
	      tks.load(new FileInputStream(TestManagerHelperMethods.getProperty("rabbit.truststore", log)), trustPassphrase);

	      TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	      tmf.init(tks);

	      SSLContext c = SSLContext.getInstance("SSLv3");
	      c.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
   	
   	
   	ConnectionFactory factory = new ConnectionFactory();
   	factory.setHost(TestManagerHelperMethods.getProperty("rabbit.defaultHost", log));
	      factory.setVirtualHost(TestManagerHelperMethods.getProperty("rabbit.virtualHost", log));
	      factory.setPort(Integer.parseInt(TestManagerHelperMethods.getProperty("rabbit.defaultPort", log)));
	      //factory.useSslProtocol(c);
	      factory.setUsername(TestManagerHelperMethods.getProperty("rabbit.username", log));
	      factory.setPassword(TestManagerHelperMethods.getProperty("rabbit.password", log));
		 
		 
		 
		 
	      collectors=new ArrayList<String>();
	      agents=new ArrayList<String>();
	     conn = factory.newConnection();
	     channel = conn.createChannel();
	}
	
	public void addCollector(String collector) {
		  collectors.add(collector);
	}
	public void addAgent(String agent) {
		agents.add(agent);
	}
	public void addCertification(String cm,String xml, String status){
		checkers.put(cm, new CertificationEvaluator(xml,status));
		
	}
	public void updateCertification(String cm,String xml, HashMap<GeneralCollectorType, ArrayList<TestCaseType>> toRun,String status){
		CertificationEvaluator ce=checkers.get(cm);
		ce.resetStatus(toRun);
		
	}
	
	@Override
	public void run() {
		
		try{
			
			  try {
		        	
		            channel.exchangeDeclare(EXCHANGE_NAME, "direct",true) ;
		        } catch (IOException ioe) {
		            log.error("Unable to declare exchange for MQ channel.", ioe) ;
		        }
	     
			  try {
				  
		            channel.queueDeclare(EXCHANGE_NAME,true,false,false,null);
		        } catch (IOException ioe) {
		            log.error("Unable to declare queue for MQ channel.", ioe) ;
		        }
	      //channel.exchangeDeclare(EXCHANGE_NAME, "direct");
	      //String queueName = channel.queueDeclare().getQueue();
			  String queueName=EXCHANGE_NAME;
	      System.out.println(queueName);
	      String severity = "key-test";
	      channel.queueBind(queueName, EXCHANGE_NAME, severity);
	      QueueingConsumer consumer = new QueueingConsumer(channel);
	      channel.basicConsume(queueName, true, consumer);
	      while (true) {
	          log.info("listening on"+queueName);  
	    	  QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	            String message = new String(delivery.getBody());
	            String routingKey = delivery.getEnvelope().getRoutingKey();
	            //System.out.println("MESSAGE:"+message);
	            log.info("Received '" + routingKey + "':'" + message + "'");
	            String[] messages=message.split("#");
	            for(String a:agents){
	            	log.info("agent:"+a);
	            }
	            log.info(messages[0]);
	            if(agents.contains(messages[0])){
	            	log.info("Agent Accepted");
	            	//find cm and update collector
	            	if(messages[2].contains("monitor")){
	            		System.out.println("result from activities requested from monitor");
	            		Sender send = new Sender();
	    				Date date = new Date();
	    				CumulusEventSerialized event = new CumulusEventSerialized(
	    						"??",
	    						"ready to send back messages to monitor",
	    						"hyberid certification", date, 0, "", "", "", "", "",
	    						0, "", "", "", "");

	    				send.sendAuditEvent(event, "/Users/iridium/Documents/workspace/testManager/testManager/AUDIT_PROPERTIES/openfire.properties");
	            	
	            	}
	            	else
	            	//agent1#cumulus:cm:id:test:58917#cfile#True
	            	checkers.get(messages[1]).updateCollector(messages[2], messages[3]);;
	            }
	            else log.info("Agent refused");
	      }

	     // channel.close();
	     // conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
