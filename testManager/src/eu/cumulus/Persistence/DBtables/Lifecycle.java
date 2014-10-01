package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LIFECYCLE database table.
 * 
 */
@Entity
@NamedQuery(name="Lifecycle.findAll", query="SELECT l FROM Lifecycle l")
public class Lifecycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String intialState;
	
	private String stateid;

	public String getStateid() {
		return stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public Lifecycle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntialState() {
		return this.intialState;
	}

	public void setIntialState(String intialState) {
		this.intialState = intialState;
	}

}