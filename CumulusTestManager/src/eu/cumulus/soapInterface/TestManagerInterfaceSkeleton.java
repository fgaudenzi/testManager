/**
 * TestManagerInterfaceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package eu.cumulus.soapInterface;

import java.util.ArrayList;

import eu.cumulus.soapResponse.GetCertificate_Testing;
import eu.cumulus.soapResponse.GetCertificate_TestingResponse;
import eu.cumulus.soapResponse.GetCertificates_Testing;
import eu.cumulus.soapResponse.GetCertificates_TestingResponse;

/**
 * TestManagerInterfaceSkeleton java skeleton for the axisService
 */
public class TestManagerInterfaceSkeleton implements
TestManagerInterfaceSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param deleteCmParameter
	 * @return deleteCm_TestingResponse1
	 */

	public eu.cumulus.soapResponse.DeleteCm_TestingResponse deleteCm_Testing(
			eu.cumulus.soapResponse.DeleteCm_Testing deleteCmParameter) {

		eu.cumulus.soapResponse.DeleteCm_TestingResponse response = new eu.cumulus.soapResponse.DeleteCm_TestingResponse();
		response.set_return(eu.cumulus.engine.SoapEngine
				.deleteCM(deleteCmParameter.getCM_ID()));
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param addCm_TestingParam
	 * @return response
	 */

	public eu.cumulus.soapResponse.AddCm_TestingResponse addCm_Testing(
			eu.cumulus.soapResponse.AddCm_Testing addCm_TestingParam) {

		eu.cumulus.soapResponse.AddCm_TestingResponse response = new eu.cumulus.soapResponse.AddCm_TestingResponse();
		response.set_return(eu.cumulus.engine.SoapEngine
				.createCM(addCm_TestingParam.getCM()));
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getCertificationModelsTesting4
	 * @return getCertificationModelsTestingResponse5
	 */

	public eu.cumulus.soapResponse.GetCertificationModelsTestingResponse getCertificationModelsTesting(
			eu.cumulus.soapResponse.GetCertificationModelsTesting CMbyPandT) {
		eu.cumulus.soapResponse.GetCertificationModelsTestingResponse response = new eu.cumulus.soapResponse.GetCertificationModelsTestingResponse();
		ArrayList<String> arr = eu.cumulus.engine.SoapEngine
				.findCMbyPropertyandTOC(CMbyPandT.getCategory(),
						CMbyPandT.getTOC_ID());
		String str[] = new String[arr.size()];
		arr.toArray(str);
		response.set_return(str);
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getPropertyAndTOCsTesting6
	 * @return getPropertyAndTOCsTestingResponse7
	 */

	public eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse getPropertyAndTOCsTesting(
			eu.cumulus.soapResponse.GetPropertyAndTOCsTesting PropertyAndTOCs) {
		eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse response = new eu.cumulus.soapResponse.GetPropertyAndTOCsTestingResponse();
		response.set_return(eu.cumulus.engine.SoapEngine.getPropertiesAndTocs());
		return response;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param requestCertificate_Testing8
	 * @return requestCertificate_TestingResponse9
	 */

	public eu.cumulus.soapResponse.RequestCertificate_TestingResponse requestCertificate_Testing(
			eu.cumulus.soapResponse.RequestCertificate_Testing param) {
		// TODO : fill this with the necessary business logic
		eu.cumulus.soapResponse.RequestCertificate_TestingResponse response = new eu.cumulus.soapResponse.RequestCertificate_TestingResponse();
		response.set_return(eu.cumulus.engine.SoapEngine
				.submitCertificate(param.getCertificationModel()));
		return response;
	}
	
    /**
     * Auto generated method signature
     * 
                                 * @param getCertificatesSummary_Testing6 
         * @return getCertificatesSummary_TestingResponse7 
     */
    
             public eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse getCertificatesSummary_Testing
              (
              eu.cumulus.soapResponse.GetCertificatesSummary_Testing getCertificatesSummary_Testing6
              )
        {   
            	 eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse  result=new eu.cumulus.soapResponse.GetCertificatesSummary_TestingResponse();
            result.set_return(eu.cumulus.engine.SoapEngine.getSummaryCertificates());
            return result;
        }
             
             /**
              * Auto generated method signature
              * 
                                          * @param getCertificates_Testing0 
                  * @return getCertificates_TestingResponse1 
              */
             
                      public eu.cumulus.soapResponse.GetCertificate_TestingResponse getCertificate_Testing
                       (
                       eu.cumulus.soapResponse.GetCertificate_Testing param
                       )
                 {
                     //TODO : fill this with the necessary business logic
                    eu.cumulus.soapResponse.GetCertificate_TestingResponse result=new eu.cumulus.soapResponse.GetCertificate_TestingResponse();
                    result.set_return(eu.cumulus.engine.SoapEngine.getCertificate(param.getCertID()));
                    return result;
             }

			@Override
			public GetCertificates_TestingResponse[] getCertificates_Testing(
					) {
				// TODO Auto-generated method stub
				GetCertificates_TestingResponse[] array=eu.cumulus.engine.SoapEngine.getCertificatesAndCM();
				return array;
			}

	

}
