package eu.cumulus.ServiceInterface;

public class CertModelCreationResponse {
	private Boolean status =false;
    private String message =null;
           
    public Boolean getStatus() {
                    return status;
            }
    public void setStatus(Boolean status) {
                    this.status = status;
            }

    public String getMessage () {
                    return message;
            }
    public void setMessage (String message) {
                    this.message = message;
            }
}
