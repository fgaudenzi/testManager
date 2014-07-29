package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AGGREGATOR database table.
 * 
 */
@Entity
@Table(name="AGGREGATOR")
@NamedQuery(name="Aggregator.findAll", query="SELECT a FROM Aggregator a")
public class Aggregator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idAggrator;

	@Column(length=4)
	private String operation;

	@Column(name="Transient", length=15)
	private String transient_;

	//bi-directional many-to-one association to Collector
	@ManyToOne
	@JoinColumn(name="CollectorID")
	private Collector collector;

	//bi-directional many-to-one association to Testmetric
	@OneToMany(mappedBy="aggregator")
	private List<Testmetric> testmetrics;

	public Aggregator() {
	}

	public int getIdAggrator() {
		return this.idAggrator;
	}

	public void setIdAggrator(int idAggrator) {
		this.idAggrator = idAggrator;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getTransient_() {
		return this.transient_;
	}

	public void setTransient_(String transient_) {
		this.transient_ = transient_;
	}

	public Collector getCollector() {
		return this.collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	public List<Testmetric> getTestmetrics() {
		return this.testmetrics;
	}

	public void setTestmetrics(List<Testmetric> testmetrics) {
		this.testmetrics = testmetrics;
	}

	public Testmetric addTestmetric(Testmetric testmetric) {
		getTestmetrics().add(testmetric);
		testmetric.setAggregator(this);

		return testmetric;
	}

	public Testmetric removeTestmetric(Testmetric testmetric) {
		getTestmetrics().remove(testmetric);
		testmetric.setAggregator(null);

		return testmetric;
	}

}