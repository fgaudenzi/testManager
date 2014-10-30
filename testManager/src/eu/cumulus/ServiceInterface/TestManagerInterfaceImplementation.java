package eu.cumulus.ServiceInterface;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import eu.cumulus.init.InitContextListener;
import eu.cumulus.init.RabbitConsumer;


public class TestManagerInterfaceImplementation implements TestManagerInterface{
	public CertModelCreationResponse deleteCm_Testing(String deleteCm_Testing) {
		boolean response;
		CertModelCreationResponse result=new CertModelCreationResponse();
		response=eu.cumulus.engine.SoapEngine
				.deleteCM(deleteCm_Testing);
		if(response){
			result.setMessage("Deleted succesful");
		}else{
			result.setMessage("Delete error, CM may not exist or there was an error, contact cumulus administrator");
		}
		result.setStatus(response);
		return result;
	}
	public  CertModelCreationResponse addCm_Testing(String addCm_TestingParam){
			Logger log = Logger.getLogger(TestManagerInterfaceImplementation.class);
			log.info("addCm_Testing called");
			CertModelCreationResponse result=new CertModelCreationResponse();
			String response;
			response=eu.cumulus.engine.SoapEngine
					.createCM(addCm_TestingParam);
			String checker[]=response.split(":");
			if((checker!=null)&&(checker.length>0)){
				result.setMessage(response);
				if(checker[0].compareTo("error")==0){
					result.setStatus(false);
				}else{
					result.setStatus(true);
				}
			}else{
				result.setMessage("error: internal server error - contact administrator");
				result.setStatus(false);
			}
			log.info("addCm_Testing call response:"+ result.getMessage());
			return result;
	}
	@Override
	public String[] getCertificationModelsTesting(String category,String tocID) {
		
		ArrayList<String> arr = eu.cumulus.engine.SoapEngine
				.findCMbyPropertyandTOC(category,
						tocID);
		String str[] = new String[arr.size()];
		arr.toArray(str);
		//response.set_return(str);
		return str;
	}
	@Override
	public String getPropertyAndTOCsTesting() {
		Logger log = Logger.getLogger(TestManagerInterfaceImplementation.class);
		log.info("getPropertyAndTOC called");
		String response="";
		response=eu.cumulus.engine.SoapEngine.getPropertiesAndTocs();
		return response;
	}
	@Override
	public String requestCertificate_Testing(String param) {
		Logger log = Logger.getLogger(TestManagerInterfaceImplementation.class);
		log.info("requestCerticate_Testing called with param:"+param);
		String response ="";
		response=eu.cumulus.engine.SoapEngine.submitCertificate(param);
		return response;
	}
	@Override
	public String getCertificatesSummary_Testing() {
		 String  result="";
         result=eu.cumulus.engine.SoapEngine.getSummaryCertificates();
         return result;
	}
	@Override
	public GetCertificate_TestingResponse[] getCertificates_Testing() {
		GetCertificate_TestingResponse[] array=eu.cumulus.engine.SoapEngine.getCertificatesAndCM();
		return array;
	}
	@Override
	public String getCertificate_Testing(String param) {
		String result;
		Logger log = Logger.getLogger(TestManagerInterfaceImplementation.class);
		log.info("getCertificate_Testing called with param:"+param);
		result=eu.cumulus.engine.SoapEngine.getCertificate(param);
        return result;
	}
	@Override
	public void recertify(String param) {
		eu.cumulus.engine.SoapEngine.recertifiy(param);
		
	}

}
