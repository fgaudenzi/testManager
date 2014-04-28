package eu.cumulus.database;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the TestCase database table.
 * 
 */
@Entity
@NamedQuery(name = "TestCase.findAll", query = "SELECT t FROM TestCase t")
public class TestCase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testCaseID;

	private String description;

	private int id;

	// bi-directional many-to-one association to AbstractCollector
	@ManyToOne
	@JoinColumn(name = "AbstractCollectorID")
	private AbstractCollector abstractCollector;

	// bi-directional one-to-one association to TestInstance
	@OneToMany(mappedBy = "testCase")
	private List<TestInstance> testInstance;

	public TestCase() {
	}

	public int getTestCaseID() {
		return this.testCaseID;
	}

	public void setTestCaseID(int testCaseID) {
		this.testCaseID = testCaseID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AbstractCollector getAbstractCollector() {
		return this.abstractCollector;
	}

	public void setAbstractCollector(AbstractCollector abstractCollector) {
		this.abstractCollector = abstractCollector;
	}

	public List<TestInstance> getTestInstance() {
		return this.testInstance;
	}

	public void setTestInstance(List<TestInstance> testInstance) {
		this.testInstance = testInstance;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.TestCaseType toXMLObject() {
		eu.cumulus.certModelXML.TestCaseType tct = new eu.cumulus.certModelXML.TestCaseType();
		tct.setDescription(this.description);
		tct.setID(BigInteger.valueOf(id));
		Iterator<TestInstance> it_ti = this.testInstance.iterator();
		while (it_ti.hasNext())
			tct.getTestInstance().add(it_ti.next().toXMLObject());
		return tct;
	}
}