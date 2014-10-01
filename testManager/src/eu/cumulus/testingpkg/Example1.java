package eu.cumulus.testingpkg;

import java.io.*;
import java.security.*;


import com.rabbitmq.client.*;

public class Example1
{
    public static void main(String[] args) throws Exception
    {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5671);

        factory.useSslProtocol();
        // Tells the library to setup the default Key and Trust managers for you
        // which do not do any form of remote server trust verification

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        //non-durable, exclusive, auto-delete queue
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



/*
{ssl_options,
 [
 {cacertfile,           "/User/iridium/Jobs/testca/cacert.pem"},
 {certfile,             "User/iridium/Jobs/server/cert.pem"},
 {keyfile,              "User/iridium/Jobs/server/key.pem"},
 {verify,               verify_peer},
 {fail_if_no_peer_cert, false}
 ]
 }*/