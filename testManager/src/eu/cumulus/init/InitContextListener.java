package eu.cumulus.init;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import eu.cumulus.testingpkg.MyLog4J;

public class InitContextListener implements ServletContextListener{
	
	/*public static void main(String[] args) {
		RabbitConsumer r=new RabbitConsumer();
		r.run();
	}*/
	
	private  ExecutorService executor;
	private  RabbitConsumer rbmqL;
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			System.out.println("ServletContextListener destroyed");
		}
	 
	        //Run this before web application is started
		@Override
		public void contextInitialized(ServletContextEvent arg0) {
			  //carico il file di configurazione
		    PropertyConfigurator.configure("/Users/iridium/Documents/workspace/testManager/LOG4J/log4j.properties");
		    
		    //ottengo instanza del log
		    Logger log = Logger.getLogger(InitContextListener.class);
		    log.error("INTI CONTEXTUALIZATION CHALLENGE");
			
			
			System.out.println("ServletContextListener TestManager started");
			ServletContext context = arg0.getServletContext();
	        int nr_executors = 1;
	        ThreadFactory daemonFactory = new DaemonThreadFactory();
	        try {
	            nr_executors = Integer.parseInt(context.getInitParameter("nr-executors"));
	        } catch (NumberFormatException ignore ) {}

	        if(nr_executors <= 1) {
	        executor = Executors.newSingleThreadExecutor(daemonFactory);
	        } else {
	        executor = Executors.newFixedThreadPool(nr_executors,daemonFactory);
	       }
	        try{
	        rbmqL=new RabbitConsumer();
	        }catch(Exception e){
	        	log.fatal("RABBITMQ ERRORS, restart rabbitMQ then restart the service");
	        	System.exit(-1);
	        }
	        executor.submit(rbmqL);
	        context.setAttribute("Rabbit_Thread", 
	        		rbmqL);
	        //executor.execute(command);
	          
		}
		
}


/*vice executor = (ExecutorService )getServletContext().getAttribute("MY_EXECUTOR");
...
executor.submit(myJob);*/
