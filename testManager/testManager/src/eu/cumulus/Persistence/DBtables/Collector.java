package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the COLLECTOR database table.
 * 
 */
@Entity
@Table(name="COLLECTOR")
@NamedQuery(name="Collector.findAll", query="SELECT c FROM Collector c")
public class Collector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int collectorID;

	@Column(length=45)
	private String agent;

	@Column(length=512)
	private String descriptor;

	@Column(nullable=false, length=10)
	private String id;

	@Column(nullable=false)
	private boolean isStatic;

	@Column(nullable=false)
	private boolean toDeploy;

	//bi-directional many-to-one association to Aggregator
	@OneToMany(mappedBy="collector")
	private List<Aggregator> aggregators;

	//bi-directional many-to-one association to Abstractcollector
	@ManyToOne
	@JoinColumn(name="AbstractCollector", nullable=false)
	private Abstractcollector abstractcollector;

	//bi-directional many-to-one association to Certificationmodel
	@ManyToOne
	@JoinColumn(name="CertModel", nullable=false)
	private Certificationmodel certificationmodel;

	//bi-directional many-to-one association to Colltestcase
	@OneToMany(mappedBy="collector", cascade={CascadeType.ALL})
	private List<Colltestcase> colltestcases;

	public Collector() {
		this.toDeploy=true;
	}

	public int getCollectorID() {
		return this.collectorID;
	}

	public void setCollectorID(int collectorID) {
		this.collectorID = collectorID;
	}

	public String getAgent() {
		return this.agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsStatic() {
		return this.isStatic;
	}

	public void setIsStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean getToDeploy() {
		return this.toDeploy;
	}

	public void setToDeploy(boolean toDeploy) {
		this.toDeploy = toDeploy;
	}

	public List<Aggregator> getAggregators() {
		return this.aggregators;
	}

	public void setAggregators(List<Aggregator> aggregators) {
		this.aggregators = aggregators;
	}

	public Aggregator addAggregator(Aggregator aggregator) {
		getAggregators().add(aggregator);
		aggregator.setCollector(this);

		return aggregator;
	}

	public Aggregator removeAggregator(Aggregator aggregator) {
		getAggregators().remove(aggregator);
		aggregator.setCollector(null);

		return aggregator;
	}

	public Abstractcollector getAbstractcollector() {
		return this.abstractcollector;
	}

	public void setAbstractcollector(Abstractcollector abstractcollector) {
		this.abstractcollector = abstractcollector;
	}

	public Certificationmodel getCertificationmodel() {
		return this.certificationmodel;
	}

	public void setCertificationmodel(Certificationmodel certificationmodel) {
		this.certificationmodel = certificationmodel;
	}

	public List<Colltestcase> getColltestcases() {
		return this.colltestcases;
	}

	public void setColltestcases(List<Colltestcase> colltestcases) {
		this.colltestcases = colltestcases;
	}

	public Colltestcase addColltestcas(Colltestcase colltestcas) {
		getColltestcases().add(colltestcas);
		colltestcas.setCollector(this);

		return colltestcas;
	}

	public Colltestcase removeColltestcas(Colltestcase colltestcas) {
		getColltestcases().remove(colltestcas);
		//colltestcas.setCollector(null);

		return colltestcas;
	}

}