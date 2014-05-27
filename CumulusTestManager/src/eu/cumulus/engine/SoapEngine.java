package eu.cumulus.engine;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.xml.bind.JAXBElement;

import eu.cumulus.certModelXML.TestBasedCertificationModelType;
import eu.cumulus.database.Certificate;
import eu.cumulus.database.CertificationModel;
import eu.cumulus.database.Property;
import eu.cumulus.database.Toc;

import eu.cumulus.soapResponse.GetCertificate_TestingResponse;
import eu.cumulus.utilities.ConverterDB_XML;

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
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		eu.cumulus.database.CertificationModel cmR = null;
		cmR = manager.find(eu.cumulus.database.CertificationModel.class, cmID);
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
	public static boolean createCM(String CM) {

		//XML contains the Certification Model as a String
		String XML = CM;

		
		//TODO context is the package containing the objectfactory
		String context = "eu.cumulus.certModelXML";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(
				XML, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		System.out.println(obj.isNil());
		TestBasedCertificationModelType tbcm = (TestBasedCertificationModelType) obj
				.getValue();
		eu.cumulus.database.CertificationModel cmR = null;
		
		
		//Convert the XML objects to JPA classes
		cmR = ConverterDB_XML.fromXML(tbcm);
		if(cmR==null){
			return false;
		}
		//System.out.println(cmR);
		
	    //TODO init of entity manager factory	
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		// createEntityManagerFactory(“AxisTest”);
		System.out.println("CM con ID:" + cmR.getId());
		EntityManager manager = factory.createEntityManager();
		
		eu.cumulus.database.CertificationModel checker=manager.find(eu.cumulus.database.CertificationModel.class, cmR.getId());
		
		//TODO this method could work or update CM with few changes
		
		//if cmR already exists then return false
		if(checker!=null){
			manager.close();
			return false;
	    //otherwise add to database		
		}else{
		
		
		manager.getTransaction().begin();
		// manager.flush();
		manager.merge(cmR);

		manager.getTransaction().commit();
		//
		manager.close();
		return true;
		}
	}

	/**
	 * @param p
	 * @param t
	 * @return
	 */
	public static ArrayList<String> findCMbyPropertyandTOC(String p, String t) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("CertificationModel.findPerTocAndProperty")
				.setParameter("toc_identifier", t)
				.setParameter("p_identifier", p);
		List<eu.cumulus.database.CertificationModel> ll = query.getResultList();
		Iterator<eu.cumulus.database.CertificationModel> it = ll.iterator();
		eu.cumulus.database.CertificationModel cmR = null;
		ArrayList<String> result = new ArrayList<String>();
		while (it.hasNext()) {
			cmR = it.next();
			eu.cumulus.certModelXML.TestBasedCertificationModelType tbcm = cmR
					.toXMLObject();
			eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
					"eu.cumulus.certModelXML");
			result.add(jaxbm.getMarshalledString(tbcm));
		}
		manager.close();
		return result;
	}

	/**
	 * @return
	 */
	public static String getPropertiesAndTocs() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("CertificationModel.getPropertiesAndTocs");
		List<eu.cumulus.database.CertificationModel> ll = query.getResultList();
		System.out.println(ll.size());
		Iterator<eu.cumulus.database.CertificationModel> it = ll.iterator();
		eu.cumulus.database.CertificationModel cmR = null;
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
	 * @param cmId
	 * @return
	 */
	public static int submitCertificate(String cmId) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		CertificationModel cm = manager.find(CertificationModel.class, cmId);

		if (cm == null) {
			manager.close();
			return -1;
		} else {

			Certificate cc = new Certificate();
			cc.setCertificationModel(cm);
			cc.setCertType("CertificationTYPE");
			cc.setInstantiationDay(new Date());
			cc.setStatus(cm.getLifeCycleBean().getIntialState());
			manager.getTransaction().begin();
			manager.persist(cc);
			//manager.merge(cc);
			manager.getTransaction().commit();
			// Random randomGenerator = new Random();
			// create certificate!

			manager.close();
			return cc.getId();

		}
	}

	/**
	 * @param id
	 * @return
	 */
	public static String getCertificate(int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Certificate cc = manager.find(Certificate.class, id);
		if (cc == null) {
			return "";
		} else {
			manager.close();
			eu.cumulus.certModelXML.certificate.TestCertificateType tct = cc
					.toXMLObject();
			eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
					"eu.cumulus.certModelXML.certificate");
			return jaxbm.getMarshalledString(tct);
		}
	}

	/**
	 * @return
	 */
	public static String getSummaryCertificates() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Certificate.findAll");
		List<eu.cumulus.database.Certificate> ll = query.getResultList();
		eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType cst = new eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType();
		if (ll != null) {
			Iterator<eu.cumulus.database.Certificate> it_cc = ll.iterator();

			while (it_cc.hasNext())
				cst.getCertificateSummary().add(
						it_cc.next().toXMLSummurizeObject());

		}
		eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
				"eu.cumulus.certModelXML.certificationSummury");
		return jaxbm.getMarshalledString(cst);
	}

	public static eu.cumulus.soapResponse.GetCertificates_TestingResponse[] getCertificatesAndCM() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Certificate.findAll");
		
		ArrayList<eu.cumulus.soapResponse.GetCertificates_TestingResponse> arrayL=new ArrayList<eu.cumulus.soapResponse.GetCertificates_TestingResponse>();
		
		List<eu.cumulus.database.Certificate> ll = query.getResultList();
		
			Iterator<eu.cumulus.database.Certificate> it_cc = ll.iterator();
			eu.cumulus.utilities.JaxbMarshal jaxbm = new eu.cumulus.utilities.JaxbMarshal(
						"eu.cumulus.certModelXML.certificate");
			eu.cumulus.utilities.JaxbMarshal jaxbm1 = new eu.cumulus.utilities.JaxbMarshal(
						"eu.cumulus.certModelXML");
			while (it_cc.hasNext()){
				eu.cumulus.soapResponse.GetCertificates_TestingResponse element=new eu.cumulus.soapResponse.GetCertificates_TestingResponse();
				eu.cumulus.database.Certificate cert=it_cc.next();
				
				element.setCertificate(jaxbm.getMarshalledString(cert.toXMLSummurizeObject()));
				eu.cumulus.database.CertificationModel cm=cert.getCertificationModel();
				element.setCM(jaxbm1.getMarshalledString(cm.toXMLObject()));
				arrayL.add(element);
			}
			
	    eu.cumulus.soapResponse.GetCertificates_TestingResponse[] array=new eu.cumulus.soapResponse.GetCertificates_TestingResponse[arrayL.size()];
		return arrayL.toArray(array);
	}

}
