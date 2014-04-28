package eu.cumulus.database;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TOT database table.
 * 
 */
@Entity
@NamedQuery(name="Tot.findAll", query="SELECT t FROM Tot t")
public class Tot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String target;

	//bi-directional many-to-one association to Toc
	@ManyToOne
	@JoinColumn(name="TOC")
	private Toc tocBean;

	public Tot() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Toc getTocBean() {
		return this.tocBean;
	}

	public void setTocBean(Toc tocBean) {
		this.tocBean = tocBean;
	}

	public eu.cumulus.certModelXML.TargetOfTestsType toXMLObject(){
		return new eu.cumulus.certModelXML.TargetOfTestsType();
	}
}