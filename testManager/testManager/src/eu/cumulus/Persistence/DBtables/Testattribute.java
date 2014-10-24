package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TESTATTRIBUTE database table.
 * 
 */
@Entity
@Table(name="TESTATTRIBUTE")
@NamedQuery(name="Testattribute.findAll", query="SELECT t FROM Testattribute t")
public class Testattribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int testAttributeID;

	@Column(nullable=false, length=5)
	private String id;

	@Column(length=30)
	private String name;

	@Column(length=256)
	private String value;

	//bi-directional many-to-one association to Abstractcollector
	@ManyToOne
	@JoinColumn(name="AbstractCollector_ID")
	private Abstractcollector abstractcollector;

	public Testattribute() {
	}

	public int getTestAttributeID() {
		return this.testAttributeID;
	}

	public void setTestAttributeID(int testAttributeID) {
		this.testAttributeID = testAttributeID;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Abstractcollector getAbstractcollector() {
		return this.abstractcollector;
	}

	public void setAbstractcollector(Abstractcollector abstractcollector) {
		this.abstractcollector = abstractcollector;
	}

}