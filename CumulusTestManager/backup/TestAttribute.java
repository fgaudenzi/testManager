package eu.cumulus.database;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;


/**
 * The persistent class for the TestAttribute database table.
 * 
 */
@Entity
@NamedQuery(name="TestAttribute.findAll", query="SELECT t FROM TestAttribute t")
public class TestAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testAttributeID;


	private String id;

	private String name;

	private String value;

	//bi-directional one-to-one association to AbstractCollector
	@OneToOne
	@JoinColumn(name="AbstractCollector_ID",insertable=false, updatable=false)
	private AbstractCollector abstractCollector;

	public TestAttribute() {
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
		System.out.println(value);
		if(value==null){
			this.value="NULL";
		}
		this.value = value;
	}

	public AbstractCollector getAbstractCollector() {
		return this.abstractCollector;
	}

	public void setAbstractCollector(AbstractCollector abstractCollector) {
		this.abstractCollector = abstractCollector;
	}
	public eu.cumulus.certModelXML.TestAttributeType toXMLObject() {
		eu.cumulus.certModelXML.TestAttributeType tat=new eu.cumulus.certModelXML.TestAttributeType();
		tat.setID(BigInteger.valueOf(Integer.getInteger(this.id)));
		tat.setName(name);
		tat.setValue(value);
		return tat;
	}

}