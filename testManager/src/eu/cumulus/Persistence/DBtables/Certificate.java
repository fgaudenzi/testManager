package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.cumulus.certificate.certificate.Artifacts;
import org.cumulus.certificate.certificate.CertificateType;
import org.cumulus.certificate.certificate.SignatureType;

import java.util.Date;
import java.util.GregorianCalendar;


/**
 * The persistent class for the CERTIFICATE database table.
 * 
 */
@Entity
@Table(name="CERTIFICATE")
@NamedQueries({
	@NamedQuery(name="Certificate.findAll", query="SELECT c FROM Certificate c"),
	@NamedQuery(name="Certificate.findPerCM", query="SELECT c FROM Certificate c where c.certificationmodel= :cm")})
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String certType;

	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date instantiationDay;

	@Column(length=45)
	private String status;

	//bi-directional many-to-one association to Certificationmodel
	@ManyToOne
	@JoinColumn(name="TBCM_ID")
	private Certificationmodel certificationmodel;

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

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
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

	public Certificationmodel getCertificationmodel() {
		return this.certificationmodel;
	}

	public void setCertificationmodel(Certificationmodel certificationmodel) {
		this.certificationmodel = certificationmodel;
	}
	public CertificateType toXML(){
		CertificateType cc=new CertificateType();
		cc.setCertificateId(String.valueOf(this.id));
		cc.setCertificateStatus(this.status);
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(this.instantiationDay);
		XMLGregorianCalendar date2;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			cc.setCertificationDate(date2);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(expirationDate==null){
			c.setTime(new Date());
		}else
		c.setTime(expirationDate);
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			cc.setExpirationDate(date2);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cc.setCertifiedSecurityProperty(this.certificationmodel.getPropertyBean().getClass_());
		//cc.setCertificateStatus(this.certificationmodel.getLifecycle().getIntialState());
		SignatureType s=new SignatureType();
		s.setName(this.certificationmodel.getSignature().getName());
		s.setRole(this.certificationmodel.getSignature().getRole());
		cc.setSignature(s);
		cc.setArtifacts(new Artifacts());
		return cc;
	}

}