package eu.cumulus.database;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the LifeCycle database table.
 * 
 */
@Entity
@NamedQuery(name="LifeCycle.findAll", query="SELECT l FROM LifeCycle l")
public class LifeCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String intialState;

	//bi-directional many-to-one association to CertificationModel
	@OneToMany(mappedBy="lifeCycleBean")
	private List<CertificationModel> certificationModels;

	public LifeCycle() {
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

	public List<CertificationModel> getCertificationModels() {
		return this.certificationModels;
	}

	public void setCertificationModels(List<CertificationModel> certificationModels) {
		this.certificationModels = certificationModels;
	}

	public CertificationModel addCertificationModel(CertificationModel certificationModel) {
		getCertificationModels().add(certificationModel);
		certificationModel.setLifeCycleBean(this);

		return certificationModel;
	}

	public CertificationModel removeCertificationModel(CertificationModel certificationModel) {
		getCertificationModels().remove(certificationModel);
		certificationModel.setLifeCycleBean(null);

		return certificationModel;
	}

	
	public eu.cumulus.certModelXML.LifeCycleType toXMLObject(){
		eu.cumulus.certModelXML.LifeCycleType lc= new eu.cumulus.certModelXML.LifeCycleType();
		lc.setInitialState(intialState);
		lc.setLifeCycleStates(null);
		return lc;
	}

}