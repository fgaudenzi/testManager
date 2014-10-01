package eu.cumulus.testingpkg;

import java.net.URL;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
 
public class JavaHttpsExample
{
	
	
	
  

public static void main(String[] args)
  throws Exception
  {
	  TrustManager[] trustAllCerts = new TrustManager[]{
			    new X509TrustManager() {
			        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			            return null;
			        }
			        public void checkClientTrusted(
			            java.security.cert.X509Certificate[] certs, String authType) {
			        }
			        public void checkServerTrusted(
			            java.security.cert.X509Certificate[] certs, String authType) {
			        }
			    }
			};
	  
	// Install the all-trusting trust manager
	 try {
	      SSLContext sc = SSLContext.getInstance("SSL");
	      sc.init(null, trustAllCerts, new java.security.SecureRandom());
	      
	      HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	      String httpsURL = "https://172.25.40.6";
	      URL myurl = new URL(httpsURL);
	      HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
	      
	      InputStream ins = con.getInputStream();
	      InputStreamReader isr = new InputStreamReader(ins);
	      BufferedReader in = new BufferedReader(isr);
	      String inputLine;
	   
	      while ((inputLine = in.readLine()) != null)
	      {
	        System.out.println(inputLine);
	      }
	   
	      in.close(); 
	 
	 
	 } catch (Exception e) {
	  }

	  
	  
   
  }
}