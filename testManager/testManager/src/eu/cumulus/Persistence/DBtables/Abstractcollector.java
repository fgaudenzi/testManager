package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ABSTRACTCOLLECTOR database table.
 * 
 */
@Entity
@Table(name="ABSTRACTCOLLECTOR")
@NamedQuery(name="Abstractcollector.findAll", query="SELECT a FROM Abstractcollector a")
public class Abstractcollector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int abstractCollectorID;

	@Column(nullable=false, length=10)
	private String id;

	@Column(nullable=false, length=45)
	private String testCategory;

	@Column(length=512)
	private String testDescription;

	@Column(nullable=false, length=256)
	private String testGenerationModelLink;

	@Column(nullable=false, length=45)
	private String testType;

	//bi-directional many-to-one association to Abstestcase
	@OneToMany(mappedBy="abstractcollector", cascade={CascadeType.ALL})
	private List<Abstestcase> abstestcases;

	//bi-directional many-to-one association to Certificationmodel
	@ManyToOne
	@JoinColumn(name="CertificationModelID")
	private Certificationmodel certificationmodel;

	//bi-directional many-to-one association to Collector
	@OneToMany(mappedBy="abstractcollector")
	private List<Collector> collectors;

	//bi-directional many-to-one association to Testattribute
	@OneToMany(mappedBy="abstractcollector")
	private List<Testattribute> testattributes;

	public Abstractcollector() {
	}

	public int getAbstractCollectorID() {
		return this.abstractCollectorID;
	}

	public void setAbstractCollectorID(int abstractCollectorID) {
		this.abstractCollectorID = abstractCollectorID;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestCategory() {
		return this.testCategory;
	}

	public void setTestCategory(String testCategory) {
		this.testCategory = testCategory;
	}

	public String getTestDescription() {
		return this.testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getTestGenerationModelLink() {
		return this.testGenerationModelLink;
	}

	public void setTestGenerationModelLink(String testGenerationModelLink) {
		this.testGenerationModelLink = testGenerationModelLink;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public List<Abstestcase> getAbstestcases() {
		return this.abstestcases;
	}

	public void setAbstestcases(List<Abstestcase> abstestcases) {
		this.abstestcases = abstestcases;
	}

	public Abstestcase addAbstestcas(Abstestcase abstestcas) {
		getAbstestcases().add(abstestcas);
		abstestcas.setAbstractcollector(this);

		return abstestcas;
	}

	public Abstestcase removeAbstestcas(Abstestcase abstestcas) {
		getAbstestcases().remove(abstestcas);
		abstestcas.setAbstractcollector(null);

		return abstestcas;
	}

	public Certificationmodel getCertificationmodel() {
		return this.certificationmodel;
	}

	public void setCertificationmodel(Certificationmodel certificationmodel) {
		this.certificationmodel = certificationmodel;
	}

	public List<Collector> getCollectors() {
		if(this.collectors==null){
			this.collectors = new ArrayList<Collector>();
		}
		return this.collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}

	public Collector addCollector(Collector collector) {
		getCollectors().add(collector);
		collector.setAbstractcollector(this);

		return collector;
	}

	public Collector removeCollector(Collector collector) {
		getCollectors().remove(collector);
		collector.setAbstractcollector(null);

		return collector;
	}

	public List<Testattribute> getTestattributes() {
		return this.testattributes;
	}

	public void setTestattributes(List<Testattribute> testattributes) {
		this.testattributes = testattributes;
	}

	public Testattribute addTestattribute(Testattribute testattribute) {
		getTestattributes().add(testattribute);
		testattribute.setAbstractcollector(this);

		return testattribute;
	}

	public Testattribute removeTestattribute(Testattribute testattribute) {
		getTestattributes().remove(testattribute);
		testattribute.setAbstractcollector(null);

		return testattribute;
	}

}