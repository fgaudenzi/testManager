package eu.cumulus.engine;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

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
import eu.cumulus.agentMessageXML.InputType.Item;

public class AgentMessageParser {


	public static void main(String[] args) {

		String filePath = "/Users/iridium/Documents/workspace/testManager/testManager/XMLRepository/CertificationModel/createdCM-Malaga.xml"; 
		//"/Users/iridium/Documents/workspace/testManager/XMLRepository/CertificationModel/instance1.xml";
		//Users/filippogaudenzi/Documents/workspace/CumulusTestManager/XML_Repository/testerCM.xml";
		String XML = "";
		try {
			XML = getStringFromInputStream(new FileInputStream(filePath));

		}catch(Exception e){
			e.printStackTrace();
		}
		String [] result=fromCMtoAgentMessage(XML);
		for(String r:result){
			System.out.println(r);
			String a = eu.cumulus.utilities.Celemetry.wrapMessage(r);
			System.out.println(a);
		}
	}


	/*
	 <collector id="1" cmid="1" probe_driver="EmptyProbeDelay">
        <TestCases>
            <TestCase>
                <ID>1</ID>
                <Description>TestCase1</Description>
                <TestInstance Operation="ciccio">
                    <Preconditions/>
                    <HiddenCommunications/>
                    <Input>
                        <Item key="Input1" value="Value1" />
                        <Item key="Input2" value="Value2" />
                    </Input>
                    <ExpectedOutput/>
                    <PostConditions/>
                </TestInstance>  
                <TestInstance Operation="3">
                    <Preconditions/>
                    <HiddenCommunications/>
                    <Input>
                        <Item key="Input5" value="Value5" />
                        <Item key="Input6" value="Value6" />
                    </Input>
                    <ExpectedOutput/>
                    <PostConditions/>
                </TestInstance>
                <TestInstance Operation="2">
                    <Preconditions/>
                    <HiddenCommunications/>
                    <Input>
                        <Item key="Input8" value="Value8" />
                        <Item key="Input5" value="Value9" />
                    </Input>
                    <ExpectedOutput/>
                    <PostConditions/>
                </TestInstance>
            </TestCase>
        </TestCases>
        </collector>

	 */




	public static String[] fromCMtoAgentMessage(String XML) {
		//inizialize Logger
		Logger log = Logger.getLogger(AgentMessageParser.class);
		//context for unmarshall cm 
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(XML, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();

		TestCertificationModel tbcm = (TestCertificationModel) obj
				.getValue();

		//delete CM
		//Cm cm=new Cm();
		ArrayList<eu.cumulus.agentMessageXML.Collector> cm=new ArrayList<eu.cumulus.agentMessageXML.Collector>();
		String CM_ID=tbcm.getCertificationModelID();
		//cm.setId(tbcm.getCertificationModelID());
		//colls contains collector [n] - get collector
		List<GeneralCollectorType> colls = tbcm.getCollectors().getCollector();
		Iterator<GeneralCollectorType> it_colls = colls.iterator();
		//bas contains abastraccollector [n] - get abstrac collector
		List<AbstracCollectorType> abs = tbcm.getCollectors().getAbstractCollector();
		//tots contains tot [n]
		List<ToT> tots = tbcm.getToC().getToTs().getToT();

		//itarting on collector
		while(it_colls.hasNext()){
			Collector c=new Collector();
			GeneralCollectorType gc=it_colls.next();
			String collector_id=gc.getId();
			c.setId(collector_id);
			c.setCmid(CM_ID);
			Iterator<ToT> it_tots=tots.iterator();
			//binding tot to collector - FINDIG TOT
			while(it_tots.hasNext()){
				ToT tot = it_tots.next();
				//System.out.println(tot.getCollectorRefID());
				if(collector_id.equalsIgnoreCase(tot.getCollectorRefID())){
					InterfaceToT script = tot.getInterface().get(0);
					c.setProbeDriver(script.getCall());
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
				eu.cumulus.agentMessageXML.Collector.TestCases tc;
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




			cm.add(c);

		}
		String[] result=new String[cm.size()];
		int i=0;
		for(Collector co : cm){
			eu.cumulus.utilities.JaxbMarshal jax = new eu.cumulus.utilities.JaxbMarshal(
					"eu.cumulus.agentMessageXML");
			result[i] = jax.getMarshalledString(co);
			i++;
			log.info("Sent to Agent \n"+result);
		}
		return result;
	}



	private static Collector.TestCases convertTestCases(TestCases tcs) {
		// TODO Auto-generated method stub
		Collector.TestCases result=new Collector.TestCases();
		List<TestCaseType> tc = tcs.getTestCase();
		return convertTestCases(tc);
	}

	
	private static Collector.TestCases convertTestCases(List<TestCaseType> tcs) {
		// TODO Auto-generated method stub
		Collector.TestCases result=new Collector.TestCases();
		Iterator<TestCaseType> it_tc = tcs.iterator();
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
				String[] keyvalue=(ti.getInput()).split(" ");
				InputType i=new InputType();
				List<eu.cumulus.agentMessageXML.InputType.Item> items=i.getItem();
				//eu.cumulus.agentMessageXML.InputType.Item[] items=new eu.cumulus.agentMessageXML.InputType.Item[keyvalue.length];

				for(String elem:keyvalue){
					String[] kv=elem.split("=");
					eu.cumulus.agentMessageXML.InputType.Item item=new Item();
					item=new eu.cumulus.agentMessageXML.InputType.Item();
					item.setKey(kv[0]);
					item.setValue(kv[1]);
					items.add(item);

				}

				timessage.setInput(i);
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


	public static String[] fromCMtoAgentMessage(String xml,
			HashMap<GeneralCollectorType, ArrayList<TestCaseType>> toRun) {
		//inizialize Logger
		Logger log = Logger.getLogger(AgentMessageParser.class);
		//context for unmarshall cm 
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(xml, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();

		TestCertificationModel tbcm = (TestCertificationModel) obj
				.getValue();

		//delete CM
		//Cm cm=new Cm();
		ArrayList<eu.cumulus.agentMessageXML.Collector> cm=new ArrayList<eu.cumulus.agentMessageXML.Collector>();
		String CM_ID=tbcm.getCertificationModelID();
		//cm.setId(tbcm.getCertificationModelID());
		//colls contains collector [n] - get collector
		List<GeneralCollectorType> colls = tbcm.getCollectors().getCollector();
		Iterator<GeneralCollectorType> it_colls = colls.iterator();
		//bas contains abastraccollector [n] - get abstrac collector
		List<AbstracCollectorType> abs = tbcm.getCollectors().getAbstractCollector();
		//tots contains tot [n]
		List<ToT> tots = tbcm.getToC().getToTs().getToT();

		//itarting on collector
		while(it_colls.hasNext()){
			Collector c=new Collector();
			GeneralCollectorType gc=it_colls.next();
			String collector_id=gc.getId();
			boolean toexec=false;
			for(Entry<GeneralCollectorType, ArrayList<TestCaseType>> elem:toRun.entrySet()){
				log.info("COMPARISON TORUN:"+elem.getKey().getId()+" Collectro in XML:"+collector_id);
				if((elem.getValue()==null)||((elem.getValue().size()!=0)&&(elem.getKey().getId().compareToIgnoreCase(collector_id)==0))){
					toexec=true;
					break;
				}
			}
			log.info("RESULT:"+toexec);
			if(toexec){
				c.setId(collector_id);
				c.setCmid(CM_ID);
				Iterator<ToT> it_tots=tots.iterator();
				//binding tot to collector - FINDIG TOT
				while(it_tots.hasNext()){
					ToT tot = it_tots.next();
					//System.out.println(tot.getCollectorRefID());
					if(collector_id.equalsIgnoreCase(tot.getCollectorRefID())){
						InterfaceToT script = tot.getInterface().get(0);
						c.setProbeDriver(script.getCall());
						break;
					}
					//we should parse testcase!!!
				}



				//find abstract collector and get testcases
				
				AbstractCollectorRef absr = gc.getAbstractCollectorRef();
				List<TestCaseType> tcs = absr.getTestCase();
				eu.cumulus.agentMessageXML.Collector.TestCases tc = convertTestCases(tcs);		
				c.setTestCases(tc);
						
					
				
				//TODO: no testcase in collector	
				//get testcase from collector
				//merge




				cm.add(c);
			}
		}
		String[] result=new String[cm.size()];
		int i=0;
		for(Collector co : cm){
			eu.cumulus.utilities.JaxbMarshal jax = new eu.cumulus.utilities.JaxbMarshal(
					"eu.cumulus.agentMessageXML");
			result[i] = jax.getMarshalledString(co);
			i++;
			log.info("Message to sent:"+result);
		}
		return result;

	}
}
