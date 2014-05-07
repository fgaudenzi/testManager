package eu.cumulus.database;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the LifeCycle database table.
 * 
 */
@Entity
@NamedQuery(name = "LifeCycle.findAll", query = "SELECT l FROM LifeCycle l")
public class LifeCycle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String intialState;

	// bi-directional many-to-one association to CertificationModel
	@OneToMany(mappedBy = "lifeCycleBean")
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

	public void setCertificationModels(
			List<CertificationModel> certificationModels) {
		this.certificationModels = certificationModels;
	}

	public CertificationModel addCertificationModel(
			CertificationModel certificationModel) {
		getCertificationModels().add(certificationModel);
		certificationModel.setLifeCycleBean(this);

		return certificationModel;
	}

	public CertificationModel removeCertificationModel(
			CertificationModel certificationModel) {
		getCertificationModels().remove(certificationModel);
		certificationModel.setLifeCycleBean(null);

		return certificationModel;
	}

	/**
	 * @return
	 */
	public eu.cumulus.certModelXML.LifeCycleType toXMLObject() {
		eu.cumulus.certModelXML.LifeCycleType lc = new eu.cumulus.certModelXML.LifeCycleType();
		lc.setInitialState(intialState);
		eu.cumulus.certModelXML.LifeCycleStates lcst=new eu.cumulus.certModelXML.LifeCycleStates();
		lcst.setNumberOfStates(BigInteger.valueOf(5));
		//single life state x5
		eu.cumulus.certModelXML.SingleLifeState sls=new eu.cumulus.certModelXML.SingleLifeState();
		sls.setLifeCycleId("ID2");
		sls.setLifeCycleState("ISSUED");
		eu.cumulus.certModelXML.SingleLifeState.LifeCycleTransitions lctss=new eu.cumulus.certModelXML.SingleLifeState.LifeCycleTransitions();
		
		eu.cumulus.certModelXML.LifeCycleTransitionType lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("ISSUED");
		lctt.setToState("EXPIRED");
		eu.cumulus.certModelXML.LifeCycleConditionType lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsQuestionable(true);
		
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
	
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("ISSUED");
		lctt.setToState("SOSPENDED");
		 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsQuestionable(true);
		
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
		
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("SUSPENDED");
		lctt.setToState("ISSUED");
		 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsValid(true);
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
		
		sls.setLifeCycleTransitions(lctss);
		lcst.getSingleState().add(sls);
		//end single state #1
		
		//Start single state #2
		sls=new eu.cumulus.certModelXML.SingleLifeState();
		sls.setLifeCycleId("ID3");
		sls.setLifeCycleState("SUSPENDED");
		lctss=new eu.cumulus.certModelXML.SingleLifeState.LifeCycleTransitions();
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("SUSPENDED");
		lctt.setToState("EXPIRED");
		 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setValidityPeriodExpired(true);
		
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
	
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("SUSPENDED");
		lctt.setToState("ISSUED");
		 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsValid(true);
		
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
		
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("SUSPENDED");
		lctt.setToState("REVOKED");
		 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsNotValid(true);
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
		
		lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
		lctt.setFromState("ISSUED");
		lctt.setToState("SUSPENDED");
		lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
		lcct.setEvidenceIsQuestionable(true);
		
		lctt.setConditionForLifeCycleTransition(lcct);
		lctss.getLifeCycleTransition().add(lctt);
		
		
		
		
		sls.setLifeCycleTransitions(lctss);
		lcst.getSingleState().add(sls);
		//end single state #2
		
		
		//Start single state #3
				sls=new eu.cumulus.certModelXML.SingleLifeState();
				sls.setLifeCycleId("ID4");
				sls.setLifeCycleState("EXPIRED");
				lctss=new eu.cumulus.certModelXML.SingleLifeState.LifeCycleTransitions();
				
				lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
				lctt.setFromState("ISSUED");
				lctt.setToState("EXPIRED");
				 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
				lcct.setValidityPeriodExpired(true);
				
				lctt.setConditionForLifeCycleTransition(lcct);
				lctss.getLifeCycleTransition().add(lctt);
				
			
				
				lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
				lctt.setFromState("SUSPENDED");
				lctt.setToState("EXPIRED");
				 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
				lcct.setValidityPeriodExpired(true);
				lctt.setConditionForLifeCycleTransition(lcct);
				lctss.getLifeCycleTransition().add(lctt);
				
				
				
				
				sls.setLifeCycleTransitions(lctss);
				lcst.getSingleState().add(sls);
				//end single state #3
		
		
				//Start single state #4
				sls=new eu.cumulus.certModelXML.SingleLifeState();
				sls.setLifeCycleId("ID5");
				sls.setLifeCycleState("REVOKED");
				lctss=new eu.cumulus.certModelXML.SingleLifeState.LifeCycleTransitions();
				
				lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
				lctt.setFromState("SUSPENDED");
				lctt.setToState("REVOKED");
				 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
				lcct.setEvidenceIsNotValid(true);
				
				lctt.setConditionForLifeCycleTransition(lcct);
				lctss.getLifeCycleTransition().add(lctt);
				
			
				
				
				
				
				
				lctt=new eu.cumulus.certModelXML.LifeCycleTransitionType();
				lctt.setFromState("ISSUED");
				lctt.setToState("REVOKED");
				 lcct=new eu.cumulus.certModelXML.LifeCycleConditionType();
				lcct.setEvidenceIsNotValid(true);
				lctt.setConditionForLifeCycleTransition(lcct);
				lctss.getLifeCycleTransition().add(lctt);
				
				
				
				
				
				
				sls.setLifeCycleTransitions(lctss);
				lcst.getSingleState().add(sls);
				//end single state #4
		        
				
				lc.setLifeCycleStates(lcst);
		
		
		
		//lc.setLifeCycleStates();
		return lc;
	}

}