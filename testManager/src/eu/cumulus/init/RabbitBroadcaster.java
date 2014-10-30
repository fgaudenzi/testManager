package eu.cumulus.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.log4j.Logger;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import eu.cumulus.utilities.TestManagerHelperMethods;

public class RabbitBroadcaster {



	private Channel channel;
	private Connection connection;
    private static final String EXCHANGE_NAME = "broadcast_to_agent";
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
	      factory.useSslProtocol(c);
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

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
    }
    
    public void sendMessage(String message) throws Exception{
   
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        //log.info("Sent " + message );

      
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