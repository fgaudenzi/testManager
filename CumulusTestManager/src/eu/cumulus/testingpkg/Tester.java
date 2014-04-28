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

import org.eclipse.persistence.queries.DatabaseQuery;

import eu.cumulus.certModelXML.TestBasedCertificationModelType;
import eu.cumulus.database.CertificationModel;
import eu.cumulus.database.Property;
import eu.cumulus.database.Toc;
import eu.cumulus.utilities.ConverterDB_XML;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// addCM();
		// deleteCM("TEST000001");
		// findPerTandP("ID001","http://cumulus-project.eu/security-properties#IAM:identity-assurance:user-authentication-and-identity-assurance-levelTest");
		// createCC("TEST000006");
		// getCertificate(1);
		getCeertificates();
	}

	private static void getCeertificates() {
		System.out.println(eu.cumulus.engine.SoapEngine
				.getSummaryCertificates());

	}

	private static void getCertificate(int i) {
		System.out.println(eu.cumulus.engine.SoapEngine.getCertificate(i));

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
		String filePath = "/Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/TestBasedCertificationModelv2-ATOS-user-authentication-and-identity-assurance-level.xml";
		String XML = "";
		try {
			XML = Tester
					.getStringFromInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eu.cumulus.engine.SoapEngine.createCM(XML);
	}

	public static void deleteCM(String id) {
		eu.cumulus.engine.SoapEngine.deleteCM(id);
	}

	public static void getPropertyandTocs() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager
				.createNamedQuery("CertificationModel.getPropertiesAndTocs");
		List<eu.cumulus.database.CertificationModel> ll = query.getResultList();
		Iterator<eu.cumulus.database.CertificationModel> it = ll.iterator();
		eu.cumulus.database.CertificationModel cmR = null;
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
		System.out.println("\n\n\n\n\n\n "
				+ eu.cumulus.utilities.ConverterDB_XML
						.getProperyAndTocs(result));
	}

}
