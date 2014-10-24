package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TOC database table.
 * 
 */
@Entity
@Table(name="TOC")
@NamedQueries({
@NamedQuery(name="Toc.findAll", query="SELECT t FROM Toc t"),
@NamedQuery(name="Toc.findPerTocId",query="SELECT t FROM Toc t where t.id= :tocid")})
public class Toc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int tocid;

	@Column(length=45)
	private String concrete;

	@Column(length=512)
	private String description;

	private boolean iaaS;

	@Column(nullable=false, length=10)
	private String id;

	private boolean paaS;

	private boolean saaS;

	@Column(length=128)
	private String uri;

	//bi-directional many-to-one association to Certificationmodel
	@OneToMany(mappedBy="tocBean", cascade={CascadeType.ALL})
	private List<Certificationmodel> certificationmodels;

	public Toc() {
	}

	public int getTocid() {
		return this.tocid;
	}

	public void setTocid(int tocid) {
		this.tocid = tocid;
	}

	public String getConcrete() {
		return this.concrete;
	}

	public void setConcrete(String concrete) {
		this.concrete = concrete;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIaaS() {
		return this.iaaS;
	}

	public void setIaaS(boolean iaaS) {
		this.iaaS = iaaS;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getPaaS() {
		return this.paaS;
	}

	public void setPaaS(boolean paaS) {
		this.paaS = paaS;
	}

	public boolean getSaaS() {
		return this.saaS;
	}

	public void setSaaS(boolean saaS) {
		this.saaS = saaS;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Certificationmodel> getCertificationmodels() {
		return this.certificationmodels;
	}

	public void setCertificationmodels(List<Certificationmodel> certificationmodels) {
		this.certificationmodels = certificationmodels;
	}

	public Certificationmodel addCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().add(certificationmodel);
		certificationmodel.setTocBean(this);

		return certificationmodel;
	}

	public Certificationmodel removeCertificationmodel(Certificationmodel certificationmodel) {
		getCertificationmodels().remove(certificationmodel);
		certificationmodel.setTocBean(null);

		return certificationmodel;
	}

}