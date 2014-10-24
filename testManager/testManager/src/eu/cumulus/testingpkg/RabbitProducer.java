package eu.cumulus.testingpkg;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitProducer {
	 public static void main(String[] args) throws Exception
	    {
		 
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
    factory.setPort(5671);
    factory.useSslProtocol(c);
	   
    Connection conn = factory.newConnection();
    Channel channel = conn.createChannel();
   
    channel.exchangeDeclare("direct_agents", "direct");

    String severity = "key-test";
    String message = "Agent1#prova demone rabbit";

    channel.basicPublish("direct_agents", severity, null, message.getBytes());
    System.out.println(" [x] Sent '" + severity + "':'" + message + "'");

    channel.close();
    conn.close();
    
    
    
    
	    }
	 
}
