package eu.cumulus.engine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.cumulus.certificate.cert.CertificateType;
import org.cumulus.certificate.model.test.*;

import eu.cumulus.Persistence.DBtables.*;
import eu.cumulus.ServiceInterface.GetCertificate_TestingResponse;
import eu.cumulus.init.RabbitBroadcaster;
import eu.cumulus.init.RabbitConsumer;
import eu.cumulus.testingpkg.MyLog4J;
//import eu.cumulus.soapResponse.GetCertificate_TestingResponse;
import eu.cumulus.utilities.ConverterDB_XML;
import eu.cumulus.utilities.ServletContextGetter;


/**
 * @author filippogaudenzi
 * 
 */
public class SoapEngine {

	/**
	 * @param cmID
	 * @return
	 */
	public static boolean deleteCM(String cmID) {
		boolean result = true;
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Certificationmodel cmR = null;
		cmR = manager.find(Certificationmodel.class, cmID);
		System.out.println("\n \n " + cmR);
		if (cmR == null) {
			return false;
		}
		try {
			manager.getTransaction().begin();
			manager.remove(cmR);
			manager.getTransaction().commit();

		} catch (PersistenceException re) {
			result = false;
		} finally {
			manager.close();
			return result;
		}
	}

	/**
	 * @param CM
	 * @return
	 */
	public static String createCM(String CM) {

		//XML contains the Certification Model as a String
		String XML = CM;

		
		//TODO context is the package containing the objectfactory
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(
				XML, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		System.out.println(obj.isNil());
		TestCertificationModel tbcm = (TestCertificationModel) obj
				.getValue();
		Certificationmodel cmR = null;
		
		
		//Convert the XML objects to JPA classes
		try{
		cmR = ConverterDB_XML.fromXML(tbcm,CM);
		if(cmR==null){
			return "error: malformed xml o malformed reference";
		}
		}catch(Exception e){
			e.printStackTrace();
			return "error:"+e.getLocalizedMessage();
		}
		//System.out.println(cmR);
		
	    //TODO init of entity manager factory	
		String cmID=cmR.getId();
		if(!cmID.matches("cumulus:cm:id:test:+[0-9]*"))
			{
			return "error: id pattern template wrong";
			}
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		// createEntityManagerFactory(�AxisTest�);
		System.out.println("CM con ID:" + cmR.getId());
		EntityManager manager = factory.createEntityManager();
		
		Certificationmodel checker=manager.find(Certificationmodel.class, cmR.getId());
		
		//TODO this method could work or update CM with few changes
		
		//if cmR already exists then return false
		while(checker!=null){
			 Random rand = new Random();

			    // nextInt is normally exclusive of the top value,
			    // so add 1 to make it inclusive
			    int randomNum = rand.nextInt((99999 - 0) + 1) + 0;
			    String id=String.valueOf(randomNum);
			    String ida=id;
			    for(int i=5;i>id.length();i--)
			    	id="0"+ida;
			
			cmR.setId("cumulus:cm:id:test:"+id);
			cmR.modifyXML_ID();
			checker=manager.find(Certificationmodel.class, cmR.getId());
			//return false;
	    //otherwise add to database		
		}
		
		
		manager.getTransaction().begin();
		// manager.flush();
		manager.merge(cmR);

		manager.getTransaction().commit();
		//
		manager.close();
		return cmR.getId();
		
	}

	/**
	 * @param p
	 * @param t
	 * @return
	 */
	public static ArrayList<String> findCMbyPropertyandTOC(String p, String t) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("Certificationmodel.findPerTocAndProperty")
				.setParameter("toc_identifier", t)
				.setParameter("p_identifier", p);
		List<Certificationmodel> ll = query.getResultList();
		Iterator<Certificationmodel> it = ll.iterator();
		Certificationmodel cmR = null;
		ArrayList<String> result = new ArrayList<String>();
		while (it.hasNext()) {
			cmR = it.next();
			result.add(cmR.getXml());
		}
		manager.close();
		return result;
	}

	/**
	 * @return
	 */
	public static String getPropertiesAndTocs() {
		eu.cumulus.utilities.ServletContextGetter scg=new eu.cumulus.utilities.ServletContextGetter ();
		ServletContext sc= scg.getServletContext();
		//RabbitConsumer ame = (RabbitConsumer)sc.getAttribute("Rabbit_Thread");
		//ame.addAgent("Agent1");
		
		
		// Logger log = Logger.getLogger(SoapEngine.class);
		 //log.info("PropertyAndTOCs Request");
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("Certificationmodel.getPropertiesAndTocs");
		List<Certificationmodel> ll = query.getResultList();
		System.out.println(ll.size());
		Iterator<Certificationmodel> it = ll.iterator();
		Certificationmodel cmR = null;
		//HashMap<Property, ArrayList<Toc>> result = new HashMap<Property, ArrayList<Toc>>();
		HashMap<Property, HashSet<Toc>> result = new HashMap<Property, HashSet<Toc>>();
		while (it.hasNext()) {
			cmR = it.next();
			if (!result.containsKey(cmR.getPropertyBean())) {
				result.put(cmR.getPropertyBean(), new HashSet<Toc>());
			}

			System.out.println(cmR.getId());
			System.out.println("TOC DB" + cmR.getTocBean().getId());

			result.get(cmR.getPropertyBean()).add(cmR.getTocBean());
			// result.put(cmR.getPropertyBean(),)
			// result.add(tbcm.toString());
		}
		manager.close();
		return eu.cumulus.utilities.ConverterDB_XML.getProperyAndTocs(result);
	}

	/**
	 * @param cmId Certification Model ID, a Certification process will start based on the related CM
	 * @return
	 */
	public static String submitCertificate(String cmId) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Certificationmodel cm = manager.find(Certificationmodel.class, cmId);
		
		if (cm == null) {
			manager.close();
			
			return "-1";
		} else {
			Query query = manager
					.createNamedQuery("Certificate.findPerCM").setParameter("cm", cm);
			
			List<Certificate> ll = query.getResultList();
			Iterator<Certificate> it_c=ll.iterator();
			if(it_c.hasNext()){
				return String.valueOf(it_c.next().getId());
			}else{
			
			Certificate cc = new Certificate();
			cc.setCertificationmodel(cm);
			cc.setCertType("TEST");
			cc.setInstantiationDay(new Date());
			cc.setStatus(cm.getLifecycle().getStateid());
			
			cc.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
			//SEND MESSAGE
			ServletContextGetter a=new ServletContextGetter();
			ServletContext servletC = a.getServletContext();
			RabbitBroadcaster rb=(RabbitBroadcaster)servletC.getAttribute("Rabbit_Sender");
			
			RabbitConsumer rc=(RabbitConsumer)servletC.getAttribute("Rabbit_Consumer");
			rc.addCertification(cm.getId(), cm.getXml(),cc.getStatus());
			String mess=AgentMessageParser.fromCMtoAgentMessage(cm.getXml());
			try {
				rb.sendMessage(mess);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			manager.getTransaction().begin();
			manager.persist(cc);
			//manager.merge(cc);
			manager.getTransaction().commit();
			// Random randomGenerator = new Random();
			// create certificate!

			manager.close();
			//return Integer.toString(cc.getId());
			return cc.getTimestamp();
			}

		}
	}

	/**
	 * @param param
	 * @return
	 */
	public static String getCertificate(String param) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Certificate cc;
		//Certificate cc = manager.find(Certificate.class, Integer.parseInt(param));
		//modification for review
		Query query = manager
				.createNamedQuery("Certificate.findPerTM").setParameter("tm", param);
		
		List<Certificate> ll = query.getResultList();
		Iterator<Certificate> it_c=ll.iterator();
		if(it_c.hasNext())
			cc=it_c.next();
		else
			cc=null;
		
		if (cc == null) {
			return "";
		} else {
			manager.close();
			
			CertificateType xml = cc.toXML();
			eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
					"org.cumulus.certificate.cert");
			return jaxbm.getMarshalledString(xml);
			}
			
		
	}

	/**
	 * @return
	 */
	public static String getSummaryCertificates() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Certificate.findAll");
		List<Certificate> ll = query.getResultList();
		eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType cst = new eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType();
		if (ll != null) {
			Iterator<Certificate> it_cc = ll.iterator();

			while (it_cc.hasNext())
				cst.getCertificateSummary().add(eu.cumulus.utilities.ConverterDB_XML.toXMLSummurizeObject(it_cc.next()));

		}
		eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
				"eu.cumulus.certModelXML.certificationSummury");
		return jaxbm.getMarshalledString(cst);
	}

	public static GetCertificate_TestingResponse[] getCertificatesAndCM() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Certificate.findAll");
		
		ArrayList<GetCertificate_TestingResponse> arrayL=new ArrayList<GetCertificate_TestingResponse>();
		
		List<Certificate> ll = query.getResultList();
		
			Iterator<Certificate> it_cc = ll.iterator();
			eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
						"org.cumulus.certificate.certificate");
			
			while (it_cc.hasNext()){
				GetCertificate_TestingResponse element=new GetCertificate_TestingResponse();
				Certificate cert=it_cc.next();
				
				element.setCertificate(jaxbm.getMarshalledString(cert.toXML()));
				Certificationmodel cm=cert.getCertificationmodel();
				element.setCM(cm.getXml());
				arrayL.add(element);
			}
			
	    GetCertificate_TestingResponse[] array=new GetCertificate_TestingResponse[arrayL.size()];
		return arrayL.toArray(array);
	}

}
