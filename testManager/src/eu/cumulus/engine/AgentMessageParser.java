package eu.cumulus.engine;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.cumulus.certificate.model.InterfaceToT;
import org.cumulus.certificate.model.TargetOfTestsType;
import org.cumulus.certificate.model.TargetOfTestsType.ToT;
import org.cumulus.certificate.model.test.*;
import org.cumulus.certificate.model.test.AbstracCollectorType.TestCases;
import org.cumulus.certificate.model.test.GeneralCollectorType.AbstractCollectorRef;
import org.cumulus.certificate.model.test.TestCaseType;
import org.cumulus.certificate.model.test.TestInstanceType;

import eu.cumulus.ServiceInterface.TestManagerInterfaceImplementation;
import eu.cumulus.agentMessageXML.*;

public class AgentMessageParser {

	
	public static void main(String[] args) {
		
		String filePath = "/Users/iridium/Documents/workspace/testManager/XMLRepository/CertificationModel/instance1.xml";
		//Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/testerCM.xml";
		String XML = "";
		try {
			XML = getStringFromInputStream(new FileInputStream(filePath));
		
		}catch(Exception e){
			e.printStackTrace();
		}
		fromCMtoAgentMessage(XML);
		
	}
	
	
	
	public static String fromCMtoAgentMessage(String XML) {
		//inizialize Logger
		Logger log = Logger.getLogger(AgentMessageParser.class);
		//context for unmarshall cm 
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(XML, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		
		TestCertificationModel tbcm = (TestCertificationModel) obj
				.getValue();
		Cm cm=new Cm();
		cm.setId(tbcm.getCertificationModelID());
		//colls contains collector [n] - get collector
		List<GeneralCollectorType> colls = tbcm.getCollectors().getCollector();
		Iterator<GeneralCollectorType> it_colls = colls.iterator();
		//bas contains abastraccollector [n] - get abstrac collector
		List<AbstracCollectorType> abs = tbcm.getCollectors().getAbstractCollector();
		//tots contains tot [n]
		List<ToT> tots = tbcm.getToC().getToTs().getToT();
		
		//itarting on collector
		while(it_colls.hasNext()){
			Cm.Collector c=new Cm.Collector();
			GeneralCollectorType gc=it_colls.next();
			String collector_id=gc.getId();
			c.setId(collector_id);
			Iterator<ToT> it_tots=tots.iterator();
			//binding tot to collector - FINDIG TOT
			while(it_tots.hasNext()){
				ToT tot = it_tots.next();
				//System.out.println(tot.getCollectorRefID());
				if(collector_id.equalsIgnoreCase(tot.getCollectorRefID())){
					InterfaceToT script = tot.getInterface().get(0);
					c.setTot(script.getCall());
					break;
				}
			//we should parse testcase!!!
			}
			
			
			
			//find abstract collector and get testcases
			String abs_id = gc.getAbstractCollectorRef().getId();
			Iterator<AbstracCollectorType> it_abs = abs.iterator();
			//System.out.println("FINDIG TESTCASES");
			while (it_abs.hasNext()){
				AbstracCollectorType ab = it_abs.next();
				eu.cumulus.agentMessageXML.Cm.Collector.TestCases tc;
				//System.out.println(ab.getId()+"=="+abs_id);
				if(ab.getId().equalsIgnoreCase(abs_id)){
					TestCases tcs = ab.getTestCases();
					tc = convertTestCases(tcs);		
					c.setTestCases(tc);
					break;
				}
			}
			//TODO: no testcase in collector	
			//get testcase from collector
			//merge
			
			
			
			
			cm.getCollector().add(c);
			
		}
		
		eu.cumulus.utilities.JaxbMarshal jax = new eu.cumulus.utilities.JaxbMarshal(
				"eu.cumulus.agentMessageXML");
		String result = jax.getMarshalledString(cm);
		log.info("Sent to Agent \n"+result);
		return result;
	}



	private static Cm.Collector.TestCases convertTestCases(TestCases tcs) {
		// TODO Auto-generated method stub
		Cm.Collector.TestCases result=new Cm.Collector.TestCases();
		Iterator<TestCaseType> it_tc = tcs.getTestCase().iterator();
		while(it_tc.hasNext()){
			eu.cumulus.agentMessageXML.TestCaseType t=new eu.cumulus.agentMessageXML.TestCaseType();
			TestCaseType tc = it_tc.next();
			t.setID(tc.getID());
			Iterator<TestInstanceType> it_tis = tc.getTestInstance().iterator();
			while(it_tis.hasNext()){
				TestInstanceType ti = it_tis.next();
				eu.cumulus.agentMessageXML.TestInstanceType timessage = new eu.cumulus.agentMessageXML.TestInstanceType();
				timessage.setExpectedOutput(ti.getExpectedOutput());
				timessage.setHiddenCommunications(ti.getHiddenCommunications());
				timessage.setInput(ti.getInput());
				timessage.setPostConditions(ti.getPostConditions());
				timessage.setPreconditions(ti.getPreconditions());
				timessage.setOperation(ti.getOperation());
				t.getTestInstance().add(timessage);
			}
			result.getTestCase().add(t);
		}
		return result;
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
}
