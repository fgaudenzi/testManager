package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import org.cumulus.certificate.model.test.TestCertificationModel;

import java.util.List;


/**
 * The persistent class for the CERTIFICATIONMODEL database table.
 * 
 */
@Entity
@Table(name="CERTIFICATIONMODEL")
@NamedQueries({
	@NamedQuery(name="Certificationmodel.findAll", query="SELECT c FROM Certificationmodel c"),
	@NamedQuery(name="Certificationmodel.findPerID", query="SELECT cm FROM Certificationmodel cm where cm.id= :cm_id "),
	@NamedQuery(name="Certificationmodel.findPerTocAndProperty", query="Select cm from Certificationmodel cm Join cm.tocBean t Join cm.propertyBean p where  t.id =:toc_identifier and p.class_=:p_identifier"),
	@NamedQuery(name="Certificationmodel.getPropertiesAndTocs",query="Select x from Certificationmodel x order by x.propertyBean ")})
public class Certificationmodel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=45)
	private String id;

	@Column(nullable=false, length=45)
	private String templateID;

	@Lob
	@Column(nullable=false)
	private String xml;

	//bi-directional many-to-one association to Abstractcollector
	@OneToMany(mappedBy="certificationmodel")
	private List<Abstractcollector> abstractcollectors;

	//bi-directional many-to-one association to Lifecycle
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="LifeCycle", nullable=false)
	private Lifecycle lifecycle;

	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="Property", nullable=false)
	private Property propertyBean;

	//bi-directional many-to-one association to Signature
	@ManyToOne
	@JoinColumn(name="Tester", nullable=false)
	private Signature signature;

	//bi-directional many-to-one association to Toc
	@ManyToOne
	@JoinColumn(name="TOC", nullable=false)
	private Toc tocBean;

	//bi-directional many-to-one association to Collector
	@OneToMany(mappedBy="certificationmodel")
	private List<Collector> collectors;

	//bi-directional many-to-one association to Certificate
	@OneToMany(mappedBy="certificationmodel")
	private List<Certificate> certificates;

	public Certificationmodel() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateID() {
		return this.templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public String getXml() {
		return this.xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public List<Abstractcollector> getAbstractcollectors() {
		return this.abstractcollectors;
	}

	public void setAbstractcollectors(List<Abstractcollector> abstractcollectors) {
		this.abstractcollectors = abstractcollectors;
	}

	public Abstractcollector addAbstractcollector(Abstractcollector abstractcollector) {
		getAbstractcollectors().add(abstractcollector);
		abstractcollector.setCertificationmodel(this);

		return abstractcollector;
	}

	public Abstractcollector removeAbstractcollector(Abstractcollector abstractcollector) {
		getAbstractcollectors().remove(abstractcollector);
		abstractcollector.setCertificationmodel(null);

		return abstractcollector;
	}

	public Lifecycle getLifecycle() {
		return this.lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	public Property getPropertyBean() {
		return this.propertyBean;
	}

	public void setPropertyBean(Property propertyBean) {
		this.propertyBean = propertyBean;
	}

	public Signature getSignature() {
		return this.signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	public Toc getTocBean() {
		return this.tocBean;
	}

	public void setTocBean(Toc tocBean) {
		this.tocBean = tocBean;
	}

	public List<Collector> getCollectors() {
		return this.collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}

	public Collector addCollector(Collector collector) {
		getCollectors().add(collector);
		collector.setCertificationmodel(this);

		return collector;
	}

	public Collector removeCollector(Collector collector) {
		getCollectors().remove(collector);
		collector.setCertificationmodel(null);

		return collector;
	}

	public List<Certificate> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Certificate addCertificate(Certificate certificate) {
		getCertificates().add(certificate);
		certificate.setCertificationmodel(this);

		return certificate;
	}

	public Certificate removeCertificate(Certificate certificate) {
		getCertificates().remove(certificate);
		certificate.setCertificationmodel(null);

		return certificate;
	}

	

}