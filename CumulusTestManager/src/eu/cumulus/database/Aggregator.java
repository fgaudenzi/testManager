package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the Aggregator database table.
 * 
 */
@Entity
@NamedQuery(name = "Aggregator.findAll", query = "SELECT a FROM Aggregator a")
public class Aggregator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private String modelLink;

	// bi-directional many-to-one association to AbstractCollector
	@OneToMany(mappedBy = "aggregator")
	private List<AbstractCollector> abstractCollectors;

	public Aggregator() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelLink() {
		return this.modelLink;
	}

	public void setModelLink(String modelLink) {
		this.modelLink = modelLink;
	}

	public List<AbstractCollector> getAbstractCollectors() {
		return this.abstractCollectors;
	}

	public void setAbstractCollectors(List<AbstractCollector> abstractCollectors) {
		this.abstractCollectors = abstractCollectors;
	}

	public AbstractCollector addAbstractCollector(
			AbstractCollector abstractCollector) {
		getAbstractCollectors().add(abstractCollector);
		abstractCollector.setAggregator(this);

		return abstractCollector;
	}

	public AbstractCollector removeAbstractCollector(
			AbstractCollector abstractCollector) {
		getAbstractCollectors().remove(abstractCollector);
		abstractCollector.setAggregator(null);

		return abstractCollector;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.AggregatorType toXMLObject() {
		eu.cumulus.certModelXML.AggregatorType ag = new eu.cumulus.certModelXML.AggregatorType();

		return ag;
	}

}