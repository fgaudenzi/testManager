package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the TOC database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Toc.findAll", query = "SELECT t FROM Toc t"),
		@NamedQuery(name = "Toc.findPerTocId", query = "SELECT t FROM Toc t where t.id= :tocid") })
public class Toc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tocid;

	private String concrete;

	private String description;

	private boolean iaaS;

	private String id;

	private boolean paaS;

	private boolean saaS;

	private String uri;

	// bi-directional many-to-one association to CertificationModel
	@OneToMany(mappedBy = "tocBean")
	private List<CertificationModel> certificationModels;

	// bi-directional many-to-one association to OperativeCondition
	@OneToMany(mappedBy = "toc", cascade = CascadeType.PERSIST)
	private List<OperativeCondition> operativeConditions;

	// bi-directional many-to-one association to Tot
	@OneToMany(mappedBy = "tocBean", cascade = CascadeType.PERSIST)
	private List<Tot> tots;

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
		certificationModel.setTocBean(this);

		return certificationModel;
	}

	public CertificationModel removeCertificationModel(
			CertificationModel certificationModel) {
		getCertificationModels().remove(certificationModel);
		certificationModel.setTocBean(null);

		return certificationModel;
	}

	public List<OperativeCondition> getOperativeConditions() {
		return this.operativeConditions;
	}

	public void setOperativeConditions(
			List<OperativeCondition> operativeConditions) {
		this.operativeConditions = operativeConditions;
	}

	public OperativeCondition addOperativeCondition(
			OperativeCondition operativeCondition) {
		getOperativeConditions().add(operativeCondition);
		operativeCondition.setToc(this);

		return operativeCondition;
	}

	public OperativeCondition removeOperativeCondition(
			OperativeCondition operativeCondition) {
		getOperativeConditions().remove(operativeCondition);
		operativeCondition.setToc(null);

		return operativeCondition;
	}

	public List<Tot> getTots() {
		return this.tots;
	}

	public void setTots(List<Tot> tots) {
		this.tots = tots;
	}

	public Tot addTot(Tot tot) {
		getTots().add(tot);
		tot.setTocBean(this);

		return tot;
	}

	public Tot removeTot(Tot tot) {
		getTots().remove(tot);
		tot.setTocBean(null);

		return tot;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.TocType toXMLObject() {
		eu.cumulus.certModelXML.TocType toc = new eu.cumulus.certModelXML.TocType();
		toc.setConcreteToc(concrete);
		toc.setId(id);
		toc.setTocDescription(description);
		toc.setTocURI(uri);

		// make smart function
		toc.getCloudLayer().add("SaaS");
		return toc;
	}

}