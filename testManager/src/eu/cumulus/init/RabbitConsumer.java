package eu.cumulus.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.log4j.Logger;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.QueueingConsumer;

public class RabbitConsumer implements Runnable {
	static final String EXCHANGE_NAME="collector_agents";
	private  Connection conn ;
	private  Channel channel;
	private Logger log;
	private ArrayList<String> collectors,agents;
	public RabbitConsumer() throws Exception{
		 log=Logger.getLogger(RabbitConsumer.class);
		char[] keyPassphrase = "MySecretPassword".toCharArray();
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
	      factory.setPassword("pass1234");
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
	
	@Override
	public void run() {
		
		try{
			

	     
	      channel.exchangeDeclare(EXCHANGE_NAME, "direct");
	      String queueName = channel.queueDeclare().getQueue();
	      String severity = "key-test";
	      channel.queueBind(queueName, EXCHANGE_NAME, severity);
	      QueueingConsumer consumer = new QueueingConsumer(channel);
	      channel.basicConsume(queueName, true, consumer);
	      while (true) {
	            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	            String message = new String(delivery.getBody());
	            String routingKey = delivery.getEnvelope().getRoutingKey();
	            log.info(" [x] Received '" + routingKey + "':'" + message + "'");
	            String[] messages=message.split("#");
	            if(agents.contains(messages[0])) log.info("Agent Accepted");
	            else log.info("Agent refused");
	      }

	     // channel.close();
	     // conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
