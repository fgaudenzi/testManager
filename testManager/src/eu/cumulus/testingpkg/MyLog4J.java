package eu.cumulus.testingpkg;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLog4J {
	  public static void main(String[] args) {
	    //carico il file di configurazione
	    PropertyConfigurator.configure("/Users/iridium/Documents/workspace/testManager/LOG4J/log4j.properties");
	    
	    //ottengo instanza del log
	    Logger log = Logger.getLogger(MyLog4J.class);
	    
	    log.debug("Test Livello DEBUG");
	    log.info("Test Livello INFO");
	    log.warn("Test Livello WARNING");
	    log.error("Test Livello ERROR");
	    log.fatal("Test Livello FATAL");  
	  }
	}
