package eu.cumulus.testingpkg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBElement;

import org.cumulus.certificate.model.test.*;

import eu.cumulus.utilities.ConverterDB_XML;
import eu.cumulus.Persistence.DBtables.*;
import eu.cumulus.init.*;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//eu.cumulus.utilities.ConverterDB_XML.fromXML(tbcm, XML)
		//deleteCM("CM003");
		//findPerTandP("Toc001","AIS:confidentiality:data-access-level");
		// createCC("TEST000006");
		// getCertificate(1);
		//getCeertificates();
		//getPropertiesAndToc();
		//checkXML_CM();
		//eu.cumulus.ServiceInterface.TestManagerInterfaceImplementation app=new eu.cumulus.ServiceInterface.TestManagerInterfaceImplementation();
		//System.out.println(app.requestCertificate_Testing("CM003"));
		try {
			RabbitConsumer rc=new RabbitConsumer();
			rc.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void checkXML_CM() {
		String filePath = "/Users/iridium/Documents/workspace/testManager/XMLRepository/CertificationModel/instance1.xml";
				//Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/testerCM.xml";
		String XML = "";
		try {
			XML = Tester.getStringFromInputStream(new FileInputStream(filePath));
		
			// TODO Auto-generated catch block
			
		
		/*String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(XML, context);
				JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		TestCertificationModel test=(TestCertificationModel) obj.getValue();
		System.out.println(test.getCertificationModelID());
		Certificationmodel cm=eu.cumulus.utilities.ConverterDB_XML.fromXML(test, XML);
		System.out.println(cm.getId());*/
		
		System.out.println(eu.cumulus.engine.SoapEngine.createCM(XML));
		
		} catch (Exception e) {
		System.out.println("ERRORE");
		e.printStackTrace();
		}
	}

	private static void getPropertiesAndToc() {
		System.out.println("RESULT PROPERTIES AND TOC: "+eu.cumulus.engine.SoapEngine.getPropertiesAndTocs());
	}

	private static void getCeertificates() {
		System.out.println(eu.cumulus.engine.SoapEngine
				.getSummaryCertificates());
	}

	private static void getCertificate(int i) {
		//System.out.println(eu.cumulus.engine.SoapEngine.getCertificate(i));
	}

	private static void createCC(String string) {
		System.out.println(eu.cumulus.engine.SoapEngine
				.submitCertificate(string));
	}

	private static void findPerTandP(String t, String p) {
		ArrayList<String> ar = eu.cumulus.engine.SoapEngine
				.findCMbyPropertyandTOC(p, t);
		for (String cm : ar) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n" + cm);
		}
	}

	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	public static void addCM() {
		String filePath = "/Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/cmv3.xml";
		String XML = "";
		try {
			XML = Tester
					.getStringFromInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RESULT CREATION: "+eu.cumulus.engine.SoapEngine.createCM(XML));
	}

	public static void deleteCM(String id) {
		System.out.println("RESULT DELETE CM: "+eu.cumulus.engine.SoapEngine.deleteCM(id));
	}

/*	public static void getPropertyandTocs() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("CertificationModel.getPropertiesAndTocs");
		List<eu.cumulus.database2.CertificationModel> ll = query.getResultList();
		Iterator<eu.cumulus.database2.CertificationModel> it = ll.iterator();
		eu.cumulus.database2.CertificationModel cmR = null;
		HashMap<Property, ArrayList<Toc>> result = new HashMap<Property, ArrayList<Toc>>();
		while (it.hasNext()) {
			cmR = it.next();
			if (!result.containsKey(cmR.getPropertyBean())) {
				result.put(cmR.getPropertyBean(), new ArrayList<Toc>());
			}
			result.get(cmR.getPropertyBean()).add(cmR.getTocBean());
			// result.put(cmR.getPropertyBean(),)
			// result.add(tbcm.toString());
		}
		manager.close();
//		System.out.println("\n\n\n\n\n\n "
//				+ eu.cumulus.utilities.ConverterDB_XML
//						.getProperyAndTocs(result));
	}*/

}
