package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the ABSTESTCASE database table.
 * 
 */
@Entity
@NamedQuery(name="Abstestcase.findAll", query="SELECT a FROM Abstestcase a")
public class Abstestcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAbsTestCase;

	//bi-directional many-to-one association to Abstractcollector
	@ManyToOne
	@JoinColumn(name="AbstractCollectorID")
	private Abstractcollector abstractcollector;

	//bi-directional many-to-one association to Testcase
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="TestCaseID")
	private Testcase testcase;

	public Abstestcase() {
	}

	public int getIdAbsTestCase() {
		return this.idAbsTestCase;
	}

	public void setIdAbsTestCase(int idAbsTestCase) {
		this.idAbsTestCase = idAbsTestCase;
	}

	public Abstractcollector getAbstractcollector() {
		return this.abstractcollector;
	}

	public void setAbstractcollector(Abstractcollector abstractcollector) {
		this.abstractcollector = abstractcollector;
	}

	public Testcase getTestcase() {
		return this.testcase;
	}

	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

}