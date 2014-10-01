package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TESTMETRIC database table.
 * 
 */
@Entity
@Table(name="TESTMETRIC")
@NamedQuery(name="Testmetric.findAll", query="SELECT t FROM Testmetric t")
public class Testmetric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTestMetrics;

	@Column(length=45)
	private String expected;

	@Column(length=45)
	private String name;

	@Column(length=4)
	private String operation;

	@Column(length=45)
	private String tested;

	//bi-directional many-to-one association to Aggregator
	@ManyToOne
	@JoinColumn(name="AggregatorID")
	private Aggregator aggregator;

	public Testmetric() {
	}

	public int getIdTestMetrics() {
		return this.idTestMetrics;
	}

	public void setIdTestMetrics(int idTestMetrics) {
		this.idTestMetrics = idTestMetrics;
	}

	public String getExpected() {
		return this.expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTested() {
		return this.tested;
	}

	public void setTested(String tested) {
		this.tested = tested;
	}

	public Aggregator getAggregator() {
		return this.aggregator;
	}

	public void setAggregator(Aggregator aggregator) {
		this.aggregator = aggregator;
	}

}