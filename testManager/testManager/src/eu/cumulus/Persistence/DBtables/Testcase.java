package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TESTCASE database table.
 * 
 */
@Entity
@Table(name="TESTCASE")
@NamedQuery(name="Testcase.findAll", query="SELECT t FROM Testcase t")
public class Testcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int testCaseID;

	private int abstractCollectorID;

	@Column(length=512)
	private String description;

	private int id;

	//bi-directional many-to-one association to Abstestcase
	@OneToMany(mappedBy="testcase")
	private List<Abstestcase> abstestcases;

	//bi-directional many-to-one association to Colltestcase
	@OneToMany(mappedBy="testcase")
	private List<Colltestcase> colltestcases;

	//bi-directional many-to-one association to Testinstance
	@OneToMany(mappedBy="testcase")
	private List<Testinstance> testinstances;

	public Testcase() {
	}

	public int getTestCaseID() {
		return this.testCaseID;
	}

	public void setTestCaseID(int testCaseID) {
		this.testCaseID = testCaseID;
	}

	public int getAbstractCollectorID() {
		return this.abstractCollectorID;
	}

	public void setAbstractCollectorID(int abstractCollectorID) {
		this.abstractCollectorID = abstractCollectorID;
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

	public List<Abstestcase> getAbstestcases() {
		return this.abstestcases;
	}

	public void setAbstestcases(List<Abstestcase> abstestcases) {
		this.abstestcases = abstestcases;
	}

	public Abstestcase addAbstestcas(Abstestcase abstestcas) {
		getAbstestcases().add(abstestcas);
		abstestcas.setTestcase(this);

		return abstestcas;
	}

	public Abstestcase removeAbstestcas(Abstestcase abstestcas) {
		getAbstestcases().remove(abstestcas);
		abstestcas.setTestcase(null);

		return abstestcas;
	}

	public List<Colltestcase> getColltestcases() {
		return this.colltestcases;
	}

	public void setColltestcases(List<Colltestcase> colltestcases) {
		this.colltestcases = colltestcases;
	}

	public Colltestcase addColltestcas(Colltestcase colltestcas) {
		getColltestcases().add(colltestcas);
		colltestcas.setTestcase(this);

		return colltestcas;
	}

	public Colltestcase removeColltestcas(Colltestcase colltestcas) {
		getColltestcases().remove(colltestcas);
		colltestcas.setTestcase(null);

		return colltestcas;
	}

	public List<Testinstance> getTestinstances() {
		return this.testinstances;
	}

	public void setTestinstances(List<Testinstance> testinstances) {
		this.testinstances = testinstances;
	}

	public Testinstance addTestinstance(Testinstance testinstance) {
		getTestinstances().add(testinstance);
		testinstance.setTestcase(this);

		return testinstance;
	}

	public Testinstance removeTestinstance(Testinstance testinstance) {
		getTestinstances().remove(testinstance);
		testinstance.setTestcase(null);

		return testinstance;
	}

}