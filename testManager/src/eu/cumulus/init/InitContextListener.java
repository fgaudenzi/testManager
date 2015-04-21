package eu.cumulus.init;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import eu.cumulus.Persistence.DBtables.Certificate;
import eu.cumulus.Persistence.DBtables.Certificationmodel;
import eu.cumulus.engine.AgentMessageParser;
import eu.cumulus.testingpkg.MyLog4J;
import eu.cumulus.utilities.TestManagerHelperMethods;

public class InitContextListener implements ServletContextListener{
	
	/*public static void main(String[] args) {
		RabbitConsumer r=new RabbitConsumer();
		r.run();
	}*/
	
	private  ExecutorService executor;
	public  RabbitConsumer rbmqL;
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			System.out.println("ServletContextListener destroyed");
		}
	 
	        //Run this before web application is started
		@Override
		public void contextInitialized(ServletContextEvent arg0) {
			  //carico il file di configurazione
			
			String defaultPath = System.getProperty("user.home") + System.getProperty("file.separator") + 
	    			".testManager" + System.getProperty("file.separator");
		    //PropertyConfigurator.configure(defaultPath+"log4j.properties");
		    //PropertyConfigurator.configure("/Users/iridium/Documents/workspace/testManager/LOG4J/log4j.properties");
			PropertyConfigurator.configure("/etc/testManager/LOG4J/log4j.properties");
		    //ottengo instanza del log
		    Logger log = Logger.getLogger(InitContextListener.class);
		    log.info("INIT CONTEXTUALIZATION CHALLENGE");
			//TestManagerHelperMethods tmhm=new TestManagerHelperMethods(defaultPath+"testManger.properties");
			///Users/iridium/Jobs/pythonAgents/testmanager.properties
		   
		    //TestManagerHelperMethods tmhm=new TestManagerHelperMethods("/Users/iridium/Jobs/pythonAgents/testmanager.properties");
		    TestManagerHelperMethods tmhm=new TestManagerHelperMethods("/etc/testManager/testManager.config");
			
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
	        	 log.info("ServletContextListener TestManager started -before consumer create");
	        	 rbmqL=new RabbitConsumer();
	        	 String agents=TestManagerHelperMethods.getProperty("agents.list", log);
	        	 String[] agentsList=agents.split(",");
	        	 for(String agent: agentsList){
	        		 rbmqL.addAgent(agent);
	        		 
	        	 }
	        	
	        }catch(Exception e){
	        	e.printStackTrace();
	        	log.fatal("RABBITMQ ERRORS, restart rabbitMQ then restart the service \n"+e.getMessage());
	        	System.exit(-1);
	        }
	        log.info("ServletContextListener TestManager started -before consumer start");
	        executor.submit(rbmqL);
	        context.setAttribute("Rabbit_Consumer", 
	        		rbmqL);
	        //TO DO, set rabbit broadcaster
	        RabbitBroadcaster rb=null;
			try {
				rb = new RabbitBroadcaster("","", "", "", 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        context.setAttribute("Rabbit_Sender", 
	        		rb);
	        EntityManagerFactory factory = Persistence
     				.createEntityManagerFactory("testManager");
     		EntityManager manager = factory.createEntityManager();
     		Query query = manager.createNamedQuery("Certificate.findAll");
    		List<Certificate> all_certificates = query.getResultList();
    		Iterator<Certificate> it_cc=all_certificates.iterator();
    	//TODO
    		 while(it_cc.hasNext()){
	    	    	Certificate cc=it_cc.next();
	    	    	Certificationmodel cm=cc.getCertificationmodel();
	    			rbmqL.addCertification(cm.getId(), cm.getXml(),cc.getStatus());
	    			String[] mess=AgentMessageParser.fromCMtoAgentMessage(cm.getXml());
	    			for (String m : mess) {
	    				String message=eu.cumulus.utilities.Celemetry.wrapMessage(m);
	    				try {
	    					rb.sendMessage(message);
	    				} catch (Exception e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			}
    		 }
	        
	        log.info("ServletContextListener TestManager started-end");
	        //executor.execute(command);
	          
		}
		
}


/*vice executor = (ExecutorService )getServletContext().getAttribute("MY_EXECUTOR");
...
executor.submit(myJob);*/
