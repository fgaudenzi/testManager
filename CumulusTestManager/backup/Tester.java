package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Tester database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Tester.findAll", query="SELECT t FROM Tester t"),
@NamedQuery(name="Tester.findPerNameAndRole",query="SELECT t FROM Tester t where t.name= :name and t.role= :role")})
public class Tester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String role;

	//bi-directional many-to-one association to CertificationModel
	@OneToMany(mappedBy="testerBean")
	private List<CertificationModel> certificationModels;

	public Tester() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CertificationModel> getCertificationModels() {
		return this.certificationModels;
	}

	public void setCertificationModels(List<CertificationModel> certificationModels) {
		this.certificationModels = certificationModels;
	}

	public CertificationModel addCertificationModel(CertificationModel certificationModel) {
		getCertificationModels().add(certificationModel);
		certificationModel.setTesterBean(this);

		return certificationModel;
	}

	public CertificationModel removeCertificationModel(CertificationModel certificationModel) {
		getCertificationModels().remove(certificationModel);
		certificationModel.setTesterBean(null);

		return certificationModel;
	}

	public eu.cumulus.certModelXML.TesterType toXMLObject(){
		return new eu.cumulus.certModelXML.TesterType();
	}
}