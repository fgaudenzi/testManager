package eu.cumulus.testingpkg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;

import org.cumulus.certificate.model.AtomicStateType;
import org.cumulus.certificate.model.ConditionType;
import org.cumulus.certificate.model.LogicalExpressionType;
import org.cumulus.certificate.model.StateTransitionModelType;
import org.cumulus.certificate.model.StateType;
import org.cumulus.certificate.model.StatesType;
import org.cumulus.certificate.model.TransitionsType;
import org.cumulus.certificate.model.test.*;
import org.xml.sax.InputSource;

import eu.cumulus.utilities.*;
import eu.cumulus.Persistence.DBtables.*;
import eu.cumulus.engine.LyfeCycleTransitionsSaxParser;
import eu.cumulus.init.*;


public class Tester {

	public static void main(String[] args) {
		
		try {
			TestManagerHelperMethods tm=new TestManagerHelperMethods("/Users/iridium/Jobs/pythonAgents/testmanager.properties");
		    //eu.cumulus.init.RabbitBroadcaster rb=new eu.cumulus.init.RabbitBroadcaster("","", "", "", 0);
			
			String filePath="/Users/iridium/Documents/workspace/testManager/XMLRepository/CertificationModel/createdCM.xml";
			//String xml_message="<cm id=\"cm24\"><collector id=\"coll1\"><tot>ehealth.py</tot><TestCases><TestCase><ID>1</ID><Description>TestCase1</Description><TestInstance Operation=\"1\"><Preconditions></Preconditions><HiddenCommunications></HiddenCommunications><Input>admin=admin password=admin1</Input><ExpectedOutput>true</ExpectedOutput><PostConditions></PostConditions></TestInstance><TestInstance Operation=\"2\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=pass1234</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"3\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=xxx</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"4\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=1234pass</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"5\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=password</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"6\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=usertest</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"7\"><Preconditions>admin-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>username=usertest password=testpwd</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance><TestInstance Operation=\"8\"><Preconditions>user-id</Preconditions><HiddenCommunications></HiddenCommunications><Input>lockout=true</Input> <ExpectedOutput>login</ExpectedOutput><PostConditions>true</PostConditions></TestInstance></TestCase></TestCases></collector></cm>";
			
			String XML="";
			try {
				XML = getStringFromInputStream(new FileInputStream(filePath));
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			String context = "org.cumulus.certificate.model.test";
			eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(XML, context);
			JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
			
			TestCertificationModel tbcm = (TestCertificationModel) obj
					.getValue();
			
			
			
			
			StateTransitionModelType lc = tbcm.getLifeCycle();
			List<StatesType> states_xml = lc.getStates();
			Iterator<StatesType> it_states = states_xml.iterator();
			ArrayList<String> states=new ArrayList<String>();
			while(it_states.hasNext()){
				Iterator<StateType> it_app = it_states.next().getState().iterator();
				while(it_app.hasNext()){
				AtomicStateType app=it_app.next().getAtomicState();
				String state=app.getStateId();
				states.add(state);
				System.out.println(state);
				}
			}
			System.exit(0);;
			
			 SAXParserFactory  spf = SAXParserFactory.newInstance();
				spf.setValidating(false);
				//spf.setNamespaceAware(false);
				SAXParser saxParser = spf.newSAXParser();
				saxParser.parse( new InputSource(new StringReader(XML)),new LyfeCycleTransitionsSaxParser());
							
		//	new InputSource(new StringReader(xml))
			
//			String xml_message=AgentMessageParser.fromCMtoAgentMessage(XML);
//			
//				
//			rb.sendMessage(xml_message);
//	
//			
//				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		/*
		String cmID="tante belle cose prima <CertificationModelID>cumulus:cm:id:test:00015</CertificationModelID> tante belle cose prima";
		cmID=cmID.replaceAll("<CertificationModelID>cumulus:cm:id:test:[0-9]*</CertificationModelID>", "<CertificationModelID>"+"sonoilpiubello"+"</CertificationModelID>");
		System.out.println(cmID);
		if(!cmID.matches("cumulus:cm:id:test:+[0-9]*"))
			{
			System.out.println( "error: id pattern template wrong");
			}
		
		
		Random rand=new Random();
		 int randomNum = rand.nextInt((99999 - 0) + 1) + 0;
		    String id=String.valueOf(randomNum);
		    String ida=id;
		    for(int i=5;i>id.length();i--)
		    	id="0"+ida;
		
		System.out.println("cumulus:cm:id:test:"+id);
		
		String filePath = "/Users/iridium/provaGRAPH.graphml";
		//Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/testerCM.xml";
String XML = "";
try {
	XML = Tester.getStringFromInputStream(new FileInputStream(filePath));

	// TODO Auto-generated catch block
	

String context = "eu.cumulus.graphTeste";
eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(XML, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
}catch(Exception e){
	e.printStackTrace();
}
		
		
		
		
		
		
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
		/*
		try {
			RabbitConsumer rc=new RabbitConsumer();
			rc.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
