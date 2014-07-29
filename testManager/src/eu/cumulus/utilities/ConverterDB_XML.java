package eu.cumulus.utilities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.cumulus.certificate.model.test.*;
import org.cumulus.certificate.model.test.TestMetricsType.TestMetric;

import eu.cumulus.Persistence.DBtables.*;

import org.cumulus.certificate.model.*;
/**
 * @author filippogaudenzi
 * 
 */
public class ConverterDB_XML {

	// TestBasedCertificationModel
	/**
	 * @param tbcm
	 * @return
	 * @throws Exception 
	 */
	static public Certificationmodel fromXML(
			TestCertificationModel tbcm,String XML) throws Exception {
		// CertificationModelID
		Certificationmodel cm = new Certificationmodel();
		cm.setId(tbcm.getCertificationModelID());
		

		// Collectors
		List<AbstracCollectorType> abst = tbcm.getCollectors()
				.getAbstractCollector();
		List<GeneralCollectorType> gct = tbcm.getCollectors().getCollector();

		
		
		
		// generateAbstractCollector
		Iterator<AbstracCollectorType> it_ab = abst.iterator();
		List<Abstractcollector> absDB = new ArrayList<Abstractcollector>();
		while (it_ab.hasNext()) {
			Abstractcollector a = ConverterDB_XML.fromXML(it_ab.next());
			a.setCertificationmodel(cm);
			absDB.add(a);
		}
		cm.setAbstractcollectors(absDB);

		// generateGeneralCollector
		Iterator<GeneralCollectorType> it_gc = gct.iterator();
		List<Collector> gcDB = new ArrayList<Collector>();
		while (it_gc.hasNext()) {
			Collector c = ConverterDB_XML.fromXML(it_gc.next(), absDB);
			c.setCertificationmodel(cm);
			gcDB.add(c);
		}
		cm.setCollectors(gcDB);
		
		// lifeCycle
		StateTransitionModelType lft=tbcm.getLifeCycle();
		//LifeCycleType lft = tbcm.getLifeCycle();
		cm.setLifecycle(ConverterDB_XML.fromXML(lft));

		// SecurityProperty
		SecurityPropertyType sp = tbcm.getSecurityProperty();
		cm.setPropertyBean(ConverterDB_XML.fromXML(sp));
		if(cm.getPropertyBean()==null){
			return null;
		}
		// Signature
		SignatureType ss = tbcm.getSignature();
		cm.setSignature(ConverterDB_XML.fromXML(ss));
		// TOC
		TocType toct = tbcm.getToC();
		Toc t = ConverterDB_XML.fromXML(toct);
		cm.setTocBean(t);
		//TODO: check for template and for compliantalgorithm 
		cm.setTemplateID(tbcm.getCertificationModelTemplateID());
		cm.setXml(XML);
		return cm;
	}

	// Abstract Collector
	/**
	 * @param next
	 * @return
	 */
	public static Abstractcollector fromXML(AbstracCollectorType next) {
		Abstractcollector ab = new Abstractcollector();
		ab.setId(next.getId());
		ab.setTestCategory(next.getTestCategory());
		ab.setTestDescription(next.getTestDescription());
		ab.setTestGenerationModelLink(next.getTestGenerationModelLink());// TestGenerationModelLink
		ab.setTestType(next.getTestType());
		Iterator<TestAttributeType> it_ta = next
				.getTestAttributes().getTestAttribute().iterator();
		ArrayList<Testattribute> tas = new ArrayList<Testattribute>();
		while (it_ta.hasNext()) {
			tas.add(ConverterDB_XML(it_ta.next(), ab));
		}
		
		ab.setTestattributes(tas);
		Iterator<TestCaseType> it_tct = next.getTestCases().getTestCase()
				.iterator();
		ArrayList<Abstestcase> tcs = new ArrayList<Abstestcase>();
		while (it_tct.hasNext()) {
			tcs.add(ConverterDB_XML(it_tct.next(), ab));
		}
		//gli tcs devono essere scambiati in abstccs
		ab.setAbstestcases(tcs);
		
		return ab;
	}

	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static Testattribute ConverterDB_XML(TestAttributeType next,
			Abstractcollector ab) {
		Testattribute ta = new Testattribute();
		ta.setName(next.getName());
		ta.setValue(next.getValue().toString());
		ta.setId(next.getID().toString());
		ta.setAbstractcollector(ab);
		return ta;
	}

	
	
	//TODO
	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static Abstestcase ConverterDB_XML(TestCaseType next,
			Abstractcollector ab) {
		Testcase tc = new Testcase();
		tc.setId(next.getID().intValue());
		tc.setDescription(next.getDescription());
		Iterator<TestInstanceType> it_tit = next.getTestInstance().iterator();
		ArrayList<Testinstance> ti = new ArrayList<Testinstance>();
		while (it_tit.hasNext()) {
			ti.add(ConverterDB_XML.fromXML(it_tit.next(), tc));
		}
		Abstestcase abst=new Abstestcase();
		abst.setAbstractcollector(ab);
		abst.setTestcase(tc);
		tc.setTestinstances(ti);
		return abst;
	}

	/**
	 * @param next
	 * @param tc
	 * @return
	 */
	public static Testinstance fromXML(TestInstanceType next, Testcase tc) {
		Testinstance ti = new Testinstance();
		ti.setTInst_ExpectedOutput(next.getExpectedOutput());
		ti.setTInst_HiddenCommunication(next.getHiddenCommunications());
		ti.setTInst_Input(next.getInput());
		ti.setTInst_Operation(next.getOperation());
		ti.setTInst_PostCondition(next.getPostConditions());
		ti.setTInst_Precondition(next.getPreconditions());
		ti.setTestcase(tc);
		return ti;
	}

	// Collector
	/**
	 * @param next
	 * @return
	 */
	public static Collector fromXML(GeneralCollectorType next) {
		Collector c = new Collector();
		c.setId(next.getId());
		c.setDescriptor(next.getDescriptor());
		
		//c.setExpirationTime(next.getExpirationTime().toGregorianCalendar()
			//	.getTime());
		c.setIsStatic(next.isIsStatic());
		c.setToDeploy(next.isToDeploy());
		return c;
	}

	
	
	//TODO:
	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static Collector fromXML(GeneralCollectorType next,
			List<Abstractcollector> ab) {
		Collector c = new Collector();
		c.setId(next.getId());
		c.setDescriptor(next.getDescriptor());
		//c.setExpirationTime(next.getExpirationTime().toGregorianCalendar()
			//	.getTime());
		c.setIsStatic(next.isIsStatic());
		try{
		c.setToDeploy(next.isToDeploy());
		}catch(java.lang.NullPointerException e){
			
		}
		Iterator<Abstractcollector> it_ab = ab.iterator();
		while (it_ab.hasNext()) {
			Abstractcollector a = it_ab.next();
			//TODO
			
			if (next.getAbstractCollectorRef().getId().equalsIgnoreCase(a.getId())) {
				a.addCollector(c);
				c.setAbstractcollector(a);
				break;
			}

		}
		//aggregator Set up
		ArrayList<Aggregator> aggregators=new ArrayList<Aggregator>();
		Aggregator agg=new Aggregator();
		agg.setTransient_(next.getAggregator().getTransient());
		//tocheck
		//agg.setCollector(c);
		agg.setOperation(next.getAggregator().getTestMetrics().getCombiningAlgorithm());
		List<TestMetric> tml = next.getAggregator().getTestMetrics().getTestMetric();
		Iterator<TestMetric> it_tm=tml.iterator();
		ArrayList tms=new ArrayList<Testmetric>();
		while(it_tm.hasNext()){
			Testmetric tm=fromXML(it_tm.next());
			tms.add(tm);
			
		}
		agg.setTestmetrics(tms);
		
		
		aggregators.add(agg);
		c.setAggregators(aggregators);
		//TODO: testcase
		
		return c;
	}

	
	
	
	
	private static Testmetric fromXML(TestMetric next) {
		Testmetric tm=new Testmetric();
		tm.setExpected(tm.getExpected());
		tm.setName(next.getName());
		tm.setOperation(next.getOperation());
		return tm;
	}

	/**
	 * @param toct
	 * @return
	 */
	private static Toc fromXML(TocType toct) {
		// check if TOC exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Toc.findPerTocId")
				.setParameter("tocid", toct.getId());
		try {
			Toc tt = (Toc) query.getSingleResult();
			manager.close();
			System.out.println("TOC ESISTENTE");
			return tt;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();

			Toc t = new Toc();
			t.setConcrete(toct.getConcreteToc());
			t.setDescription(toct.getTocDescription());

			//TODO :make smart function for Cloud Layer
			t.setSaaS(true);
			t.setId(toct.getId());
			t.setUri(toct.getTocURI());
			
			// ar.add(new Tot());
			// t.setTots(ar);
			return t;
		}

	}

	
	//TODO: transistion
	/**
	 * @param lft
	 * @return
	 * @throws Exception 
	 */
	public static Lifecycle fromXML(StateTransitionModelType lft) throws Exception {
		Lifecycle lc = new Lifecycle();
		String initStateID=lft.getInitialState().getStateId();
		String initState="";
		Iterator <StatesType> itst=lft.getStates().iterator();
		while(itst.hasNext()){
			Iterator<StateType> it_st=itst.next().getState().iterator();
			while(it_st.hasNext()){
				AtomicStateType at=it_st.next().getAtomicState();
				String compare=at.getStateId();
				if(compare.equalsIgnoreCase(initStateID)){
					initState=at.getName();
							lc.setIntialState(initState);
					return lc;
				}}
			//TODO
		}
		
		//lc.setIntialState(lft.getInitialState());
		throw new Exception("inital state is not defined");
	}

	/**
	 * @param sp
	 * @return
	 * @throws Exception 
	 */
	
	//TODO: level
	public static Property fromXML(SecurityPropertyType sp) throws Exception {

		// check if property already exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Property.findPerClass")
				.setParameter("clazz", sp.getSProperty().getClazz());
		//TODO; check level as well
		try {
			Property pp = (Property) query
					.getSingleResult();
			manager.close();
			return pp;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();
			throw new Exception("Not supported Property:"+sp.getSProperty().getClazz());
			
		}
			/*Property p = new Property();
			p.setClass_(sp.getSProperty().getClazz());
			p.setId(sp.getSecurityPropertyId());
			p.setSecurityPropertyDefinition(sp.getSecurityPropertyDefinition());
			p.setShortName(sp.getShortName());
			p.setVocabulary(sp.getVocabulary());
			*/
			//TODO it should return null, the property wasn't found
		
		}
	
	

	/**
	 * @param tt
	 * @return
	 * @throws Exception 
	 */
	public static Signature fromXML(SignatureType tt) throws Exception {
		// check
		// check if Tester exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("testManager");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Tester.findPerNameAndRole")
				.setParameter("name", tt.getName())
				.setParameter("role", tt.getRole());
		try {
			Signature t = (Signature) query.getSingleResult();
			manager.close();
			return t;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();
			/*Signature tester = new Signature();
			tester.setName(tt.getName());
			tester.setRole(tt.getRole());*/
			throw new Exception("Signature not supported:"+tt.getName()); 
			//return tester;
		}

	}

	/**
	 * @param input
	 * @return
	 */
	public static String getProperyAndTocs(
		HashMap<Property, HashSet<Toc>> input) {
		
		eu.cumulus.certModelXML.PropertiesAndTocs.PropertiesAndTocsType root = new eu.cumulus.certModelXML.PropertiesAndTocs.PropertiesAndTocsType();
		for (Map.Entry<Property, HashSet<Toc>> entry : input.entrySet()) {
			eu.cumulus.certModelXML.PropertiesAndTocs.PropertyType p = new eu.cumulus.certModelXML.PropertiesAndTocs.PropertyType();
			p.setCategory(entry.getKey().getClass_());
			HashSet<Toc> ta = entry.getValue();
			for (Toc t : ta) {
				eu.cumulus.certModelXML.PropertiesAndTocs.TargetOfCertificationType tt = new eu.cumulus.certModelXML.PropertiesAndTocs.TargetOfCertificationType();
				tt.setID(t.getId());
				System.out.println("TOC XML ID" + t.getId());
				p.getTargetOfCertification().add(tt);
			}
			root.getProperty().add(p);
		}
		eu.cumulus.utilities.JaxbMarshal jax = new eu.cumulus.utilities.JaxbMarshal(
				"eu.cumulus.certModelXML.PropertiesAndTocs");
		String result = jax.getMarshalledString(root);
		return result;
			
	}
	
	
	
	public static eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary toXMLSummurizeObject(Certificate cc) {
		eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary cs = new eu.cumulus.certModelXML.certificationSummury.CertificateSummariesType.CertificateSummary();
		cs.setCertificateSerialNo(cc.getId());

		cs.setSecurityProperty(cc.getCertificationmodel().getPropertyBean()
				.getClass_());
		cs.setTocName(cc.getCertificationmodel().getTocBean().getId());
		cs.setStatus(cc.getStatus());
		
		return cs;
	}
	
	
	
}
