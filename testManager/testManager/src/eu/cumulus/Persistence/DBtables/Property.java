package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PROPERTY database table.
 * 
 */
@Entity
@Table(name="PROPERTY")
@NamedQueries({
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p"),
@NamedQuery(name="Property.findPerClass", query="SELECT p FROM Property p where p.class_ = :clazz")})
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int testedSecurityID;

	@Column(name="class", nullable=false, length=256)
	private String class_;

	@Column(length=10)
	private String id;

	@Column(length=45)
	private String level;

	@Column(length=512)
	private String securityPropertyDefinition;

	@Column(length=256)
	private String shortName;

	@Column(length=256)
	private String vocabulary;

	//bi-directional many-to-one association to Certificationmodel
	@OneToMany(mappedBy="propertyBean")
	private List<Certificationmodel> certificationmodels;

	public Property() {
	}

	public int getTestedSecurityID() {
		return this.testedSecurityID;
	}

	public void setTestedSecurityID(int testedSecurityID) {
		this.testedSecurityID = testedSecurityID;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSecurityPropertyDefinition() {
		return this.securityPropertyDefinition;
	}

	public void setSecurityPropertyDefinition(String securityPropertyDefinition) {
		this.securityPropertyDefinition = securityPropertyDefinition;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	public List<Certificationmodel> getCertificationmodels() {
		return this.certificationmodels;
	}

	public void setCertificationmodels(List<Certificationmodel> certificationmodels) {
		this.certificationmodels = certificationmodels;
	}

	public Certificationmodel addCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().add(certificationmodel);
		certificationmodel.setPropertyBean(this);

		return certificationmodel;
	}

	public Certificationmodel removeCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().remove(certificationmodel);
		certificationmodel.setPropertyBean(null);

		return certificationmodel;
	}

}