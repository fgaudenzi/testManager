package eu.cumulus.database;



import java.io.Serializable;

import javax.persistence.*;

import java.util.Iterator;
import java.util.List;


/**
 * The persistent class for the CertificationModel database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="CertificationModel.findAll", query="SELECT c FROM CertificationModel c"),
	@NamedQuery(name="CertificationModel.findPerID", query="SELECT cm FROM CertificationModel cm where cm.id= :cm_id "),
	@NamedQuery(name="CertificationModel.findPerTocAndProperty", query="Select cm from CertificationModel cm Join cm.tocBean t Join cm.propertyBean p where  t.id =:toc_identifier and p.class_=:p_identifier"),
	@NamedQuery(name="CertificationModel.getPropertiesAndTocs",query="Select x from CertificationModel x order by x.propertyBean ")})
public class CertificationModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	//bi-directional many-to-one association to AbstractCollector
	@OneToMany(mappedBy="certificationModel",cascade=CascadeType.PERSIST)
	private List<AbstractCollector> abstractCollectors;



	//bi-directional many-to-one association to LifeCycle
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="LifeCycle")
	private LifeCycle lifeCycleBean;

	//bi-directional many-to-one association to Property
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Property")
	private Property propertyBean;

	//bi-directional many-to-one association to Toc
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="TOC")
	private Toc tocBean;

	//bi-directional many-to-one association to Tester
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Tester")
	private Tester testerBean;

	//bi-directional many-to-one association to Collector
	@OneToMany(mappedBy="certificationModel")
	private List<Collector> collectors;

	public CertificationModel() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<AbstractCollector> getAbstractCollectors() {
		return this.abstractCollectors;
	}

	public void setAbstractCollectors(List<AbstractCollector> abstractCollectors) {
		this.abstractCollectors = abstractCollectors;
	}

	public AbstractCollector addAbstractCollector(AbstractCollector abstractCollector) {
		getAbstractCollectors().add(abstractCollector);
		abstractCollector.setCertificationModel(this);

		return abstractCollector;
	}

	public AbstractCollector removeAbstractCollector(AbstractCollector abstractCollector) {
		getAbstractCollectors().remove(abstractCollector);
		abstractCollector.setCertificationModel(null);

		return abstractCollector;
	}

	

	public LifeCycle getLifeCycleBean() {
		return this.lifeCycleBean;
	}

	public void setLifeCycleBean(LifeCycle lifeCycleBean) {
		this.lifeCycleBean = lifeCycleBean;
	}

	public Property getPropertyBean() {
		return this.propertyBean;
	}

	public void setPropertyBean(Property propertyBean) {
		this.propertyBean = propertyBean;
	}

	public Toc getTocBean() {
		return this.tocBean;
	}

	public void setTocBean(Toc tocBean) {
		this.tocBean = tocBean;
	}

	public Tester getTesterBean() {
		return this.testerBean;
	}

	public void setTesterBean(Tester testerBean) {
		this.testerBean = testerBean;
	}

	public List<Collector> getCollectors() {
		return this.collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}

	public Collector addCollector(Collector collector) {
		getCollectors().add(collector);
		collector.setCertificationModel(this);

		return collector;
	}

	public Collector removeCollector(Collector collector) {
		getCollectors().remove(collector);
		collector.setCertificationModel(null);

		return collector;
	}
	public eu.cumulus.certModelXML.TestBasedCertificationModelType toXMLObject(){
		eu.cumulus.certModelXML.TestBasedCertificationModelType cmt=new eu.cumulus.certModelXML.TestBasedCertificationModelType();
		//set ID
		eu.cumulus.certModelXML.CertificationModelType idCm=new eu.cumulus.certModelXML.CertificationModelType();
		idCm.setCmId(id);
		cmt.setCertificationModelId(idCm);
		
		//set Collectors (change the abstractCollector)
		eu.cumulus.certModelXML.CollectorType collectorTs=new eu.cumulus.certModelXML.CollectorType();
		Iterator<Collector> it=this.collectors.iterator();
		while(it.hasNext()){
			collectorTs.getCollector().add(it.next().toXMLObject());
		}
		Iterator<AbstractCollector> itab=this.abstractCollectors.iterator();
		while(itab.hasNext()){
			collectorTs.getAbstractCollector().add(itab.next().toXMLObject());
		}
		cmt.setCollectors(collectorTs);
		
		
		//setLifeCycle
		cmt.setLifeCycle(this.lifeCycleBean.toXMLObject());
		
		//set TOC
		cmt.setToc(this.tocBean.toXMLObject());
		
		//set Property
		cmt.setTestedSecurityProperty(this.propertyBean.toXMLObject());
		
		//set Tester
		cmt.setTester(this.testerBean.toXMLObject());
		
		
		//set Context
		cmt.setContext(null);
		 
		return cmt;
	}
	
	public String toString(){
		return "\n\n\n\n\n\n\n\n\n"+this.id+" TOC:"+this.tocBean.getId()+"-" + tocBean.getTocid()+"\nProperty:"+propertyBean.getClass_() +"/n ACollector n"+this.abstractCollectors.size() +"\n Collector n";//+this.collectors.size();
	}
	

}