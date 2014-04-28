package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the Property database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
		@NamedQuery(name = "Property.findPerClass", query = "SELECT p FROM Property p where p.class_ = :clazz") })
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testedSecurityID;

	@Column(name = "class")
	private String class_;

	private String id;

	private String securityPropertyDefinition;

	private String shortName;

	private String vocabulary;

	// bi-directional many-to-one association to CertificationModel
	@OneToMany(mappedBy = "propertyBean")
	private List<CertificationModel> certificationModels;

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

	public List<CertificationModel> getCertificationModels() {
		return this.certificationModels;
	}

	public void setCertificationModels(
			List<CertificationModel> certificationModels) {
		this.certificationModels = certificationModels;
	}

	public CertificationModel addCertificationModel(
			CertificationModel certificationModel) {
		getCertificationModels().add(certificationModel);
		certificationModel.setPropertyBean(this);

		return certificationModel;
	}

	public CertificationModel removeCertificationModel(
			CertificationModel certificationModel) {
		getCertificationModels().remove(certificationModel);
		certificationModel.setPropertyBean(null);

		return certificationModel;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.SecurityPropertyType toXMLObject() {
		eu.cumulus.certModelXML.SecurityPropertyType p = new eu.cumulus.certModelXML.SecurityPropertyType();
		p.setSecurityPropertyDefinition(securityPropertyDefinition);
		p.setSecurityPropertyId(id);
		p.setShortName(shortName);
		p.setVocabulary(vocabulary);
		eu.cumulus.certModelXML.PropertyType pt = new eu.cumulus.certModelXML.PropertyType();
		pt.setClazz(class_);
		p.setSProperty(pt);
		return p;
	}
}