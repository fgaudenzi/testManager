package eu.cumulus.ServiceInterface;

import java.util.ArrayList;

import eu.cumulus.init.RabbitConsumer;


public class TestManagerInterfaceImplementation implements TestManagerInterface{
	public boolean deleteCm_Testing(String deleteCm_Testing) {
		boolean response;
		response=eu.cumulus.engine.SoapEngine
				.deleteCM(deleteCm_Testing);
		return response;
	}
	public  CertModelCreationResponse addCm_Testing(String addCm_TestingParam){
		
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
		String response="";
		response=eu.cumulus.engine.SoapEngine.getPropertiesAndTocs();
		return response;
	}
	@Override
	public String requestCertificate_Testing(String param) {
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
		result=eu.cumulus.engine.SoapEngine.getCertificate(param);
        return result;
	}

}