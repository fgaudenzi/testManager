package eu.cumulus.ServiceInterface;


/**
 * @author iridium
 *
 */
public interface TestManagerInterface {

	/**
	 * @param deleteCm_Testing
	 * @return
	 */
	public boolean deleteCm_Testing(
			String deleteCm_Testing);
	
	/**
	 * @param addCm_Testing
	 * @return
	 */
	public boolean addCm_Testing(
			String addCm_Testing);

	/**
	 * @return
	 */
	public String[] getCertificationModelsTesting(String category,String tocID);

	/**
	 * @return
	 */
	public String getPropertyAndTOCsTesting();

	/**
	 * @param requestCertificate_Testing
	 * @return
	 */
	public String requestCertificate_Testing(
			String param);
	
	/**
	 * @return
	 */
	public String getCertificatesSummary_Testing();
            
    /**
     * @return
     */
    public GetCertificate_TestingResponse[] getCertificates_Testing();
                    
    /**
     * @param getCertificates_Testing
     * @return
     */
    public String getCertificate_Testing(
    		String param);
            
    
}