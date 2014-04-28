package eu.cumulus.database;



import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The persistent class for the AbstractCollector database table.
 * 
 */
@Entity
@NamedQuery(name="AbstractCollector.findAll", query="SELECT a FROM AbstractCollector a")
public class AbstractCollector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int abstractCollectorID;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="AggregatorID")
	private Aggregator aggregatorBean;
	
	private String id;

	private String testCategory;

	private String testDescription;

	private String testGenerationModelLink;

	private String testType;




	//bi-directional many-to-one association to CertificationModel
	@ManyToOne
	@JoinColumn(name="CertificationModelID")
	private CertificationModel certificationModel;

	//bi-directional many-to-one association to Collector
	@OneToMany(mappedBy="abstractCollectorBean",cascade=CascadeType.PERSIST)
	private List<Collector> collectors;

	//bi-directional one-to-one association to TestAttribute
	@OneToMany(mappedBy="abstractCollector",cascade=CascadeType.PERSIST)
	private List<TestAttribute> testAttributes;

	//bi-directional many-to-one association to TestCase
	@OneToMany(mappedBy="abstractCollector",cascade=CascadeType.PERSIST)
	private List<TestCase> testCases;

	public AbstractCollector() {
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

	public CertificationModel getCertificationModel() {
		return this.certificationModel;
	}

	public void setCertificationModel(CertificationModel certificationModel) {
		this.certificationModel = certificationModel;
	}

	public List<Collector> getCollectors() {
		return this.collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}

	public Collector addCollector(Collector collector) {
		if(getCollectors()==null){
			setCollectors(new ArrayList<Collector>());
		}
		getCollectors().add(collector);
		collector.setAbstractCollectorBean(this);

		return collector;
	}

	public Collector removeCollector(Collector collector) {
		getCollectors().remove(collector);
		collector.setAbstractCollectorBean(null);

		return collector;
	}

	public List<TestAttribute> getTestAttributes() {
		return this.testAttributes;
	}

	public void setTestAttributes(List<TestAttribute> testAttribute) {
		this.testAttributes = testAttribute;
	}

	public List<TestCase> getTestCases() {
		return this.testCases;
	}

	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

	public TestCase addTestCas(TestCase testCas) {
		getTestCases().add(testCas);
		testCas.setAbstractCollector(this);

		return testCas;
	}

	public TestCase removeTestCas(TestCase testCas) {
		getTestCases().remove(testCas);
		testCas.setAbstractCollector(null);

		return testCas;
	}

	
	
	public Aggregator getAggregatorBean() {
		return aggregatorBean;
	}

	public void setAggregatorBean(Aggregator aggregatorBean) {
		this.aggregatorBean = aggregatorBean;
	}

	public eu.cumulus.certModelXML.AbstracCollectorType toXMLObject(){
		eu.cumulus.certModelXML.AbstracCollectorType absc= new eu.cumulus.certModelXML.AbstracCollectorType();
		absc.setId(id);
		absc.setTestCategory(testCategory);
		absc.setTestDescription(this.testDescription);
		absc.setTestGenerationModelLink(testGenerationModelLink);
		absc.setTestType(testType);
		
		eu.cumulus.certModelXML.AbstracCollectorType.TestAttributes tas=new eu.cumulus.certModelXML.AbstracCollectorType.TestAttributes();
		eu.cumulus.certModelXML.AbstracCollectorType.TestCases tc=new eu.cumulus.certModelXML.AbstracCollectorType.TestCases();
		
		Iterator<TestAttribute> it_ta=this.testAttributes.iterator();
		while(it_ta.hasNext()) tas.getTestAttribute().add(it_ta.next().toXMLObject());
		Iterator<TestCase> it_tc=this.testCases.iterator();
		while(it_tc.hasNext()) tc.getTestCase().add(it_tc.next().toXMLObject());
		absc.setTestAttributes(tas);
		absc.setTestCases(tc);
		if(this.aggregatorBean!=null) absc.setAggregator(this.aggregatorBean.toXMLObject());
		//absc.setCapability(new eu.cumulus.certModelXML.CapabilityType());
		
		return absc;
	}
	
	
}