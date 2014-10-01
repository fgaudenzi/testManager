package eu.cumulus.Persistence.DBtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRANSITION database table.
 * 
 */
@Entity
@Table(name="TRANSITION")
@NamedQuery(name="Transition.findAll", query="SELECT t FROM Transition t")
public class Transition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idtransition;

	@Column(length=256)
	private String formula;

	@Column(length=45)
	private String from;

	@Column(length=45)
	private String to;

	//bi-directional many-to-one association to Lifecycle
	@ManyToOne
	@JoinColumn(name="lifecycleID")
	private Lifecycle lifecycle;

	public Transition() {
	}

	public int getIdtransition() {
		return this.idtransition;
	}

	public void setIdtransition(int idtransition) {
		this.idtransition = idtransition;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Lifecycle getLifecycle() {
		return this.lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}