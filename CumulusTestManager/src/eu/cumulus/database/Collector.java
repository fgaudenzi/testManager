package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The persistent class for the Collector database table.
 * 
 */
@Entity
@NamedQuery(name = "Collector.findAll", query = "SELECT c FROM Collector c")
public class Collector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collectorID;

	private String descriptor;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationTime;

	private String id;

	private boolean isStatic;

	private boolean toDeploy;

	// bi-directional many-to-one association to AbstractCollector
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AbstractCollector")
	private AbstractCollector abstractCollectorBean;

	// bi-directional many-to-one association to CertificationModel
	@ManyToOne
	@JoinColumn(name = "CertModel")
	private CertificationModel certificationModel;

	public Collector() {
	}

	public int getCollectorID() {
		return this.collectorID;
	}

	public void setCollectorID(int collectorID) {
		this.collectorID = collectorID;
	}

	public String getDescriptor() {
		return this.descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Date getExpirationTime() {
		return this.expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
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

	public AbstractCollector getAbstractCollectorBean() {
		return this.abstractCollectorBean;
	}

	public void setAbstractCollectorBean(AbstractCollector abstractCollectorBean) {
		this.abstractCollectorBean = abstractCollectorBean;
	}

	public CertificationModel getCertificationModel() {
		return this.certificationModel;
	}

	public void setCertificationModel(CertificationModel certificationModel) {
		this.certificationModel = certificationModel;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.GeneralCollectorType toXMLObject() {
		eu.cumulus.certModelXML.GeneralCollectorType cXML = new eu.cumulus.certModelXML.GeneralCollectorType();
		cXML.setAbstractCollector(this.abstractCollectorBean.getId());
		cXML.setDescriptor(descriptor);

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(this.expirationTime);
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cXML.setExpirationTime(date2);
		cXML.setId(id);
		cXML.setIsStatic(this.isStatic);
		cXML.setToDeploy(this.toDeploy);
		return cXML;
	}

}