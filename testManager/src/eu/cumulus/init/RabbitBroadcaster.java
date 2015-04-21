package eu.cumulus.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.log4j.Logger;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.AMQP;

import eu.cumulus.utilities.TestManagerHelperMethods;

public class RabbitBroadcaster {



	private Channel channel;
	private Connection connection;
   // private static final String EXCHANGE_NAME = "broadcast_to_agent";
	private static final String EXCHANGE_NAME = "celery";
	private Logger log;
    
    public RabbitBroadcaster(String host,String virtualhost,String Username,String pwd,int port) throws Exception{
    	//log=Logger.getLogger(RabbitConsumer.class);
    	 log=Logger.getLogger( RabbitBroadcaster.class);
    	//MySecretPassword
		
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
	      // unsecure connection
	      // factory.useSslProtocol(c);
	      factory.setUsername(TestManagerHelperMethods.getProperty("rabbit.username", log));
	      factory.setPassword(TestManagerHelperMethods.getProperty("rabbit.password", log));
    	
    	
    		/*factory.setHost("localhost");
	      factory.setVirtualHost("testManager");
	      factory.setPort(5671);
	      factory.useSslProtocol(c);
	      factory.setUsername("agent");
	      factory.setPassword("pass1234");*/
        this.connection = factory.newConnection();
        this.channel = connection.createChannel();
        
        
        
        
        try {
            channel.queueDeclare("celery",true,false,false,null);
        } catch (IOException ioe) {
            log.error("Unable to declare queue for MQ channel.", ioe) ;
        }

        try {
        	
            channel.exchangeDeclare("celery", "direct",true) ;
        } catch (IOException ioe) {
            log.error("Unable to declare exchange for MQ channel.", ioe) ;
        }

        try {
            channel.queueBind("celery", "celery", "celery") ;
        } catch (IOException ioe) {
            log.error("Unable to bind queue for channel.", ioe) ;
        }
        
        
        
        
       // channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
       // channel.exchangeDeclare(EXCHANGE_NAME, "direct");
    }
    
    public void sendMessage(String message) throws Exception{
    	//BasicProperties props =  
    	BasicProperties props;
    	props= new BasicProperties.Builder().contentType("application/json").build();
        channel.basicPublish(EXCHANGE_NAME, "celery", props, message.getBytes());
        log.info("Sent to Agent: " + message );

      
    }
    public void close(){
    	try {
			this.channel.close();
			this.connection.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //...
}