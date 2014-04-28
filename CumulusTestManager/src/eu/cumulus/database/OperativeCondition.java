package eu.cumulus.database;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the OperativeCondition database table.
 * 
 */
@Entity
@NamedQuery(name = "OperativeCondition.findAll", query = "SELECT o FROM OperativeCondition o")
public class OperativeCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operativeConditionID;

	@Temporal(TemporalType.DATE)
	private Date tocDate;

	private String tocRelease;

	private String tocVendor;

	// bi-directional many-to-one association to Toc
	@ManyToOne
	@JoinColumn(name = "TocID")
	private Toc toc;

	public OperativeCondition() {
	}

	public int getOperativeConditionID() {
		return this.operativeConditionID;
	}

	public void setOperativeConditionID(int operativeConditionID) {
		this.operativeConditionID = operativeConditionID;
	}

	public Date getTocDate() {
		return this.tocDate;
	}

	public void setTocDate(Date tocDate) {
		this.tocDate = tocDate;
	}

	public String getTocRelease() {
		return this.tocRelease;
	}

	public void setTocRelease(String tocRelease) {
		this.tocRelease = tocRelease;
	}

	public String getTocVendor() {
		return this.tocVendor;
	}

	public void setTocVendor(String tocVendor) {
		this.tocVendor = tocVendor;
	}

	public Toc getToc() {
		return this.toc;
	}

	public void setToc(Toc toc) {
		this.toc = toc;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.OperativeConditionsType toXMLObject() {
		return new eu.cumulus.certModelXML.OperativeConditionsType();
	}

}