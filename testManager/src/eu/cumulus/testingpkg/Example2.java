package eu.cumulus.testingpkg;

import java.io.*;
import java.security.*;
import javax.net.ssl.*;

import com.rabbitmq.client.*;


public class Example2
{
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

      channel.queueDeclare("rabbitmq-java-test", false, true, true, null);
      channel.basicPublish("", "rabbitmq-java-test", null, "Hello, World".getBytes());


      GetResponse chResponse = channel.basicGet("rabbitmq-java-test", false);
      
      if(chResponse == null) {
          System.out.println("No message retrieved");
      } else {
          byte[] body = chResponse.getBody();
          System.out.println("Recieved: " + new String(body));
      }


      channel.close();
      conn.close();
  }
}