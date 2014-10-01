package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SIGNATURE database table.
 * 
 */
@Entity
@Table(name="SIGNATURE")
@NamedQueries({
@NamedQuery(name="Tester.findAll", query="SELECT t FROM Signature t"),
@NamedQuery(name="Tester.findPerNameAndRole",query="SELECT t FROM Signature t where t.name= :name and t.role= :role")})
public class Signature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String name;

	@Column(length=45)
	private String role;

	//bi-directional many-to-one association to Certificationmodel
	@OneToMany(mappedBy="signature")
	private List<Certificationmodel> certificationmodels;

	public Signature() {
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

	public List<Certificationmodel> getCertificationmodels() {
		return this.certificationmodels;
	}

	public void setCertificationmodels(List<Certificationmodel> certificationmodels) {
		this.certificationmodels = certificationmodels;
	}

	public Certificationmodel addCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().add(certificationmodel);
		certificationmodel.setSignature(this);

		return certificationmodel;
	}

	public Certificationmodel removeCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().remove(certificationmodel);
		certificationmodel.setSignature(null);

		return certificationmodel;
	}

}