package eu.cumulus.testingpkg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestManagerInterface {

	private static Log logger = LogFactory.getLog(TestManagerInterface.class);

	public String getPropertyAndTOCsTesting() {
		String myXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <PropertiesAndTocs>  <Property category=\"str1234\"> <TargetOfCertification ID=\"str1234\" /> </Property> </PropertiesAndTocs>";

		return myXML;
	}

	public ArrayList<String> getCertificationModelsTesting(String Category,
			String TOC_ID) {
		logger.info("getCertificationModelsTesting service is invoked");
		ArrayList<String> myArrayList = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C://TestingCM.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Creating buffered reader from  CM_Instance_Example.xml is failed "
					+ e.toString());
		}
		String myCM = null;
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				// filippo
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			myCM = sb.toString();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Reading CM_Instance_Example is failed "
					+ e.toString());
		}

		myArrayList.add(myCM);

		return myArrayList;
	}

	public int requestCertificate_Testing(String CertificationModel) {

		int certID = 1111;
		return certID;

	}

	public Boolean addCm_Testing(String CM) {

		return false;
	}

	public Boolean deleteCm_Testing(String CM_ID) {

		return false;
	}

}
