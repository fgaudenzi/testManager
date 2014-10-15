package eu.cumulus.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;


/**
 * Provides several useful helper functions to rest of the application
 * 
 * @author piyushma
 */

public class TestManagerHelperMethods {


    private static String testManagerProperties;
    private static Logger logger;
    private static String agents_list="",rabbitHost="", rabbittrust_pwd="", rabbitcert_pwd="",rabbitPort="",rabbitVirtualHost="",rabbitCert="",rabbitTrustStore="",rabbitUsr="",rabbitPwd="";
    
    
    private static String[] allowedKeys = {"rest", "dbsync", "hostsync", "caservice"};
    
    private static final String IPADDRESS_PATTERN = 
    		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    private static HashMap<String, Object> services;
     
    
    
    

   /**
     * initializes the VEPHelperMethods object
     * 
     * @param vepProp   the full path of the VEP properties file
     */
    public TestManagerHelperMethods(String vepProp)
    {
    	System.out.println("Properties at:"+vepProp);
        testManagerProperties= vepProp;
        //logger = Logger.getLogger("VEP.HelperMethods");
        services = new HashMap<String, Object>();
        rabbitHost = TestManagerHelperMethods.getPropertyF("rabbit.defaultHost", logger);
        rabbitPort = TestManagerHelperMethods.getPropertyF("rabbit.port", logger);
        rabbitCert=TestManagerHelperMethods.getPropertyF("rabbit.certificate", logger);
        rabbitPwd=TestManagerHelperMethods.getPropertyF("rabbit.password", logger);
       rabbitUsr=TestManagerHelperMethods.getPropertyF("rabbit.username", logger);
       rabbitTrustStore=TestManagerHelperMethods.getPropertyF("rabbit.truststore", logger);
       rabbitVirtualHost=TestManagerHelperMethods.getPropertyF("rabbit.virtualHost", logger);
       rabbitcert_pwd=TestManagerHelperMethods.getPropertyF("rabbit.certificate-pwd", logger);
       rabbittrust_pwd=TestManagerHelperMethods.getPropertyF("rabbit.truststore-pwd", logger);
       agents_list=TestManagerHelperMethods.getPropertyF("agents.list", logger);
    }
    
    public static String getProperty(String key,Logger Log){
    	String result=null;
    	if(key.equalsIgnoreCase("rabbit.defaultHost"))
    		result=rabbitHost;
    	else
    		if(key.equalsIgnoreCase("rabbit.defaultPort"))
        		result=rabbitPort;
        	else
        		if(key.equalsIgnoreCase("rabbit.username"))
            		result=rabbitUsr;
            	else
            		if(key.equalsIgnoreCase("rabbit.password"))
                		result=rabbitPwd;
                	else
                		if(key.equalsIgnoreCase("rabbit.truststore"))
                    		result=rabbitTrustStore;
                    	else
                    		if(key.equalsIgnoreCase("rabbit.virtualHost"))
                        		result=rabbitVirtualHost;
                        	else
                        		if(key.equalsIgnoreCase("rabbit.certificate"))
                            		result=rabbitCert;
                        		else
                        			if(key.equalsIgnoreCase("rabbit.certificate-pwd"))
                                		result=rabbitcert_pwd;
                            		else
                            			if(key.equalsIgnoreCase("rabbit.truststore-pwd"))
                                    		result=rabbittrust_pwd;
                            			else
    										if(key.equalsIgnoreCase("agents.list"))
    											result=agents_list;
        String logResult="found";
    	
    	if(result==null) logResult="not found";
    	
    	if(Log!=null)
    	Log.debug("Requested from properties file key:"+key+" -> "+logResult );	
    	return result;
    }
    
    /**
     * Retrieves the VEP properties file path
     * 
     * @return      properties file path
     */
    public static String getPropertyFile()
    {
        return testManagerProperties;
    }
    
    public static HashMap<String, Object> getServicesMap()
    {
    	return services;
    }
    
    public static boolean addService(String key, Object obj)
    {
    	if(belongsTo(allowedKeys, key))
    	{
    		services.put(key, obj);
    		return true;
    	}
    	return false;
    }
    
    public static Object getService(String key)
    {
    	return services.get(key);
    }

    
    /**
     * adds a new key:value property into the VEP properties file
     * 
     * @param key       the name of the key
     * @param val       the value of the key
     * @param logger    the logger reference from the calling environment
     * @param fileName  the full path of the VEP properties file
     * @return 
     */
    public static boolean addProperty(String key, String val, Logger logger)
    {
        Properties props = new Properties();
        try
        {
            logger.trace("Loading system properties into memory.");
            FileInputStream fis = new FileInputStream(testManagerProperties);
            FileOutputStream fos = null;
            props.load(fis);
            logger.trace("System properties successfully loaded.");
            props.setProperty(key, val);
            logger.trace("Adding/modifying system property [key=" + key + ", value=" + val + "]");
            fis.close();
            props.store((fos = new FileOutputStream(testManagerProperties)), "Author: Piyush Harsh");
            fos.close();
            logger.trace("Stored system properties back to file successfully.");
        }
        catch(Exception ex)
        {
            logger.warn("Unable to write back system properties file.");
            if(logger.isDebugEnabled())
                ex.printStackTrace(System.err);
            else
                logger.warn(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Retrieves the key value from the VEP properties file
     * 
     * @param key       the key name to be retrieved
     * @param logger    the logger reference from the calling environment
     * @param fileName  the full VEP properties file path
     * @return          the value for the requested key
     */
    private static String getPropertyF(String key, Logger logger)
    {
        String result = null;
        Properties props = new Properties();
        try
        {
            if(logger!=null && logger.isTraceEnabled())
                logger.trace("Trying to read system properties file.");
            FileInputStream fis = new FileInputStream(testManagerProperties);
            props.load(fis);
            result = props.getProperty(key);
            fis.close();
            if(logger!=null && logger.isTraceEnabled())
                logger.trace("Closing system properties file. [key=" + key + ", value=" + result + "].");
            else
            {
                if(logger == null)
                    System.out.println("LOGGER NOT YET INITIALIZED: Closing system properties file. [key=" + key + ", value=" + result + "].");
            }
        }
        catch(Exception ex)
        {
            result = null;
            if(logger!=null && logger.isDebugEnabled())
            {
            	logger.error("Error accessing system properties file.");
                ex.printStackTrace(System.err);
            }
            else if(logger != null)
                logger.error(ex.getMessage());
            else
                ex.printStackTrace(System.err);
        }
        return result;
    }
    
    /**
     * It formats a long sentence to wrap into a desired width
     * 
     * @param text      The text to be wrapped
     * @param len       the character width size to wrap into
     * @param wordWrap  true for enabling word-wrap
     * @return          array of String containing the wrapped text
     */
    public static String[] wrapText(String text, int len, boolean wordWrap)
    {
      // return empty array for null text
      if(text == null)
        return new String[] {};

      // return text if len is zero or less
      if(len <= 0)
        return new String[] {text};

      // return text if less than length
      if(text.length() <= len)
        return new String[] {text};

      char [] chars = text.toCharArray();
      ArrayList<String> lines = new ArrayList<String>();
      StringBuilder line = new StringBuilder();
      StringBuffer word = new StringBuffer();

      for(int i = 0; i < chars.length; i++)
      {
        word.append(chars[i]);

        if(wordWrap && chars[i] == ' ')
        {
          if((line.length() + word.length()) > len)
          {
            lines.add(line.toString());
            line.delete(0, line.length());
          }
          line.append(word);
          word.delete(0, word.length());
        }
        else if(!wordWrap)
        {
            if(word.length() == len)
            {
                lines.add(word.toString());
                word.delete(0, word.length());
            }
        }
      }

      // handle any extra chars in current word
      if (word.length() > 0)
      {
        if((line.length() + word.length()) > len)
        {
          lines.add(line.toString());
          line.delete(0, line.length());
        }
        line.append(word);
      }
      // handle extra line
      if (line.length() > 0)
      {
        lines.add(line.toString());
      }

      String[] ret = new String[lines.size()];
      for(int i =0; i<lines.size(); i++)
      {
          ret[i] = (String)lines.get(i);
      }
      return ret;
    }
    
    
    /*
    public static boolean testDBconsistency()
    {
    	boolean value = true;
        if(value==true)
            return value;
    	try
        {
            logger.trace("Running VEP database sanity checks (primitive checks) now.");
            if(DBHandler.dbHandle != null)
            {
                DatabaseMetaData dbm = DBHandler.dbHandle.getMetaData();
                String[] types = {"TABLE"};
                ResultSet rs = dbm.getTables(null,null,"%",types);
                int count=0;
                while (rs.next())
                {
                    count++;
                    String tableName = rs.getString("TABLE_NAME");
                    value = (value && belongsTo(tables, tableName));
                }
                logger.trace("VEP database has " + count + " tables.");
//                if(count < tables.length)
                if(!value)
                { 
                    logger.error("VEP database file failed sanity checks, some tables should not exist. It may mean that you miss some tables or, depending on the version of the DB you are using, have supplementary tables.");
//                    value = false;
                }
                else
                {
                    logger.trace("VEP database sanity checks (primitive checks) were completed successfully.");
                }
            }
            else
            {
                logger.warn("VEP database handler object is not valid. Terminating database sanity checks. Check system properties and try again.");
                value = false;
            }
        }
        catch(Exception ex)
        {
            logger.error("Exception caught during database sanity checks.");
            if(logger.isDebugEnabled())
                ex.printStackTrace(System.err);
            else
                logger.warn(ex.getMessage());
            value = false;
        }
    	return value;
//    	return true;
    }
    */
    
  
    
    public static boolean belongsTo(String[] list, String element)
    {
    	for(int i=0; i<list.length; i++)
    	{
    		if(list[i].equalsIgnoreCase(element)) return true;
    	}
    	return false;
    }
    
    public static boolean isIpAddress(String ip)
    {
    	Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
    	Matcher matcher = pattern.matcher(ip);
    	return matcher.matches();
    }
   
}
