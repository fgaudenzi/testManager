package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the COLLTESTCASE database table.
 * 
 */
@Entity
@NamedQuery(name="Colltestcase.findAll", query="SELECT c FROM Colltestcase c")
public class Colltestcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCollTestCase;

	//bi-directional many-to-one association to Abstractcollector
		@ManyToOne
		@JoinColumn(name="CollectorID")
		private Collector collector;

	//bi-directional many-to-one association to Testcase
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="TestCaseID")
	private Testcase testcase;
	
	
	
	public Colltestcase() {
	}

	public int getIdCollTestCase() {
		return this.idCollTestCase;
	}

	public void setIdCollTestCase(int idCollTestCase) {
		this.idCollTestCase = idCollTestCase;
	}



	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	public Testcase getTestcase() {
		return testcase;
	}

	public void setTestcase(Testcase testcase) {
		this.testcase = testcase;
	}

	

}