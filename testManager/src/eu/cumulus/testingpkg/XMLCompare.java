package eu.cumulus.testingpkg;



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
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import junit.framework.Assert;

import org.cumulus.certificate.model.test.GeneralCollectorType;
import org.cumulus.certificate.model.test.TestCaseType;
import org.cumulus.certificate.model.test.TestCertificationModel;
import org.cumulus.certificate.model.test.TestInstanceType;

import eu.cumulus.Persistence.DBtables.Certificationmodel;

public class XMLCompare {
	
	
	
	private enum differences{
		    TC, Collector, Probe, TI 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String XMLnew="";
		String XMLold="";
		String filePathOld = "/Users/iridium/Documents/workspace/testManager/testManager/XMLRepository/CertificationModel/createdCM-Malaga.xml";
		String filePathNew = "/Users/iridium/Documents/workspace/testManager/testManager/XMLRepository/CertificationModel/createdCM-Malaga-updated.xml";
		try {
			XMLnew = getStringFromInputStream(new FileInputStream(filePathNew));
			XMLold = getStringFromInputStream(new FileInputStream(filePathOld));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(
				XMLnew, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		TestCertificationModel tbcmNEW = (TestCertificationModel) obj
				.getValue();
	
		unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(
				XMLold, context);
		obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		TestCertificationModel tbcmOLD = (TestCertificationModel) obj
				.getValue();
		
	
		List<GeneralCollectorType> clNew = tbcmNEW.getCollectors().getCollector();
		List<GeneralCollectorType> clOld = tbcmOLD.getCollectors().getCollector();
		HashMap<GeneralCollectorType, ArrayList<TestCaseType>> toRun = getCollectorsDifference(clNew,clOld);
		for (Entry<GeneralCollectorType, ArrayList<TestCaseType>> e :toRun.entrySet()) {
			GeneralCollectorType key    = e.getKey();
			ArrayList<TestCaseType> value  = e.getValue();
			
			System.out.println("COLLECTOR: "+ key.getId());
			if(value==null){
				System.out.println("re-run all testcases");
			}else{
			for(TestCaseType tc : value){
				System.out.println("             TC ---"+tc.getID()+"--- must be executed");
			}
			}
		}

		
		
		

}


private static HashMap<GeneralCollectorType, ArrayList<TestCaseType>> getCollectorsDifference(
			List<GeneralCollectorType> clNew, List<GeneralCollectorType> clOld) {
		    Iterator<GeneralCollectorType> it_new = clNew.iterator();
		    Iterator<GeneralCollectorType> it_old = clOld.iterator();
		    ArrayList<GeneralCollectorType> colN = new ArrayList<GeneralCollectorType>();
		    ArrayList<GeneralCollectorType> colO = new ArrayList<GeneralCollectorType>();
		    HashMap<GeneralCollectorType, ArrayList<TestCaseType>> toRun=new HashMap<GeneralCollectorType, ArrayList<TestCaseType>>();
		   
		    while(it_new.hasNext()){
		    	colN.add(it_new.next());
		    }
		    while(it_old.hasNext()){
		    	colO.add(it_old.next());
		    }
		    List<TestCaseType> app = colN.get(0).getAbstractCollectorRef().getTestCase();
	    	System.out.println("numero test case:"+app.size());
		    
		    int l=colN.size();
		    for(int i=0;i<l;i++){
		    	System.out.println("analizzo collector:"+colN.get(i).getId());
		    	int lo=colO.size();
		    	int z;
		    	for(z=0;z<lo;z++){
		    		GeneralCollectorType root = colO.get(z);
		    		if(colN.get(i).getId().compareTo(root.getId())==0){
		    			System.out.println("trovato Collector");
		    			ArrayList<TestCaseType> result = compareTestCases(root.getAbstractCollectorRef().getTestCase(),colN.get(i).getAbstractCollectorRef().getTestCase());
		    			toRun.put(colN.get(i), result);
		    			colO.remove(z);
		    			break;
		    		}
		    	}
		    	if(z==lo){
		    		toRun.put(colN.get(i), null);
		    	}
		    }
		    return toRun;
	}





private static ArrayList<TestCaseType> compareTestCases(List<TestCaseType> tcOld,
		List<TestCaseType> tcNew) {
		Iterator<TestCaseType> it_new = tcNew.iterator();
		Iterator<TestCaseType> it_old = tcOld.iterator();
    ArrayList<TestCaseType> tcN = new ArrayList<TestCaseType>();
    ArrayList<TestCaseType> tcO = new ArrayList<TestCaseType>();
    ArrayList<TestCaseType> toRun=new ArrayList<TestCaseType>();
    
    while(it_new.hasNext()){
    	tcN.add(it_new.next());
    }
    while(it_old.hasNext()){
    	tcO.add(it_old.next());
    }
    int l=tcN.size();
    //System.out.println("ANALIZZO N "+l+" testcase");
    int z;
    for(int i=0;i<l;i++){
    	System.out.println("analizzo testCase:"+tcN.get(i));
    	int lo=tcO.size();
    	for(z=0;z<lo;z++){
    		if(tcN.get(i).getID().compareTo(tcO.get(z).getID())==0){
    			System.out.println("Trovato TC");
    			TestCaseType root = tcO.get(z);
    			
    			boolean diff=compareTestInstances(root.getTestInstance(),tcN.get(i).getTestInstance());
    			System.out.println("TEST CASE DA ESEGUIRE:"+diff);
    			if(diff){
    			toRun.add(tcN.get(i));
    			}
    			tcO.remove(z);
    			break;
    		}
    	}
    	if(z==lo){
    		//new TestCase;
    		toRun.add(tcN.get(i));
    	}
    }
    return toRun;
}


private static boolean compareTestInstances(List<TestInstanceType> tiOld,
		List<TestInstanceType> tiNew) {
	// TODO Auto-generated method stub
	Iterator<TestInstanceType> it_new = tiNew.iterator();
	Iterator<TestInstanceType> it_old = tiOld.iterator();
ArrayList<TestInstanceType> tiN = new ArrayList<TestInstanceType>();
ArrayList<TestInstanceType> tiO = new ArrayList<TestInstanceType>();

while(it_new.hasNext()){
	tiN.add(it_new.next());
}
while(it_old.hasNext()){
	tiO.add(it_old.next());
}

int l=tiN.size();
for(int i=0;i<l;i++){
	System.out.println("analizzo test instance:"+tiN.get(i).getOperation());
	int lo=tiO.size();
	int z;
	for(z=0;z<lo;z++){
		System.out.println("TN:"+tiN.get(i).getOperation()+ " VS "+tiO.get(z).getOperation());
		if(tiN.get(i).getOperation().compareTo(tiO.get(z).getOperation())==0){
			System.out.println("Trovato TI");
			TestInstanceType root = tiO.get(z);
			
			if(root.getInput().compareTo(tiN.get(i).getInput())!=0){
				System.out.println("INPUT DIFFERENTE");
				return true;
				//tiO.remove(z);
			}
			break;
			
			//compareTestInstances(root.getTestInstance(),tcN.get(i).getTestInstance());
		}
	}
	if(z==lo){
		System.out.println("TI non trovato");
		return true;
		
	}
}
if(tiO.size()>0){
	//alcuni tescCase vecchi sono stati eliminati
}
return false;
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

