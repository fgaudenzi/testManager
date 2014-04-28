package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import eu.cumulus.certModelXML.certificate.TestCertificateType;

import java.util.Date;

/**
 * The persistent class for the Certificate database table.
 * 
 */
@Entity
@NamedQuery(name = "Certificate.findAll", query = "SELECT c FROM Certificate c")
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String certType;

	private String expirationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date instantiationDay;

	private String status;

	// bi-directional many-to-one association to CertificationModel
	@ManyToOne
	@JoinColumn(name = "TBCM_ID")
	private CertificationModel certificationModel;

	public Certificate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCertType() {
		return this.certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getInstantiationDay() {
		return this.instantiationDay;
	}

	public void setInstantiationDay(Date instantiationDay) {
		this.instantiationDay = instantiationDay;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CertificationModel getCertificationModel() {
		return this.certificationModel;
	}

	public void setCertificationModel(CertificationModel certificationModel) {
		this.certificationModel = certificationModel;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.certificate.TestCertificateType toXMLObject() {
		eu.cumulus.certModelXML.certificate.TestCertificateType tct = new eu.cumulus.certModelXML.certificate.TestCertificateType();
		tct.setCertificateId(id);
		tct.setCertificationModelId(this.certificationModel.getId());
		eu.cumulus.certModelXML.certificate.TestCertificateType.SProperty sp = new eu.cumulus.certModelXML.certificate.TestCertificateType.SProperty();
		sp.setClazz(this.certificationModel.getPropertyBean().getClass_());
		tct.setSProperty(sp);
		eu.cumulus.certModelXML.certificate.TestCertificateType.Toc toc = new eu.cumulus.certModelXML.certificate.TestCertificateType.Toc();
		toc.setId(this.certificationModel.getTocBean().getId());
		tct.setToc(toc);
		return tct;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary toXMLSummurizeObject() {
		eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary cs = new eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary();
		cs.setCertificateSerialNo(id);

		cs.setSecurityProperty(this.certificationModel.getPropertyBean()
				.getClass_());
		cs.setTocName(this.certificationModel.getTocBean().getId());
		return cs;
	}

}