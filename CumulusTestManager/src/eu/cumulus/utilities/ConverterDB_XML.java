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

import eu.cumulus.certModelXML.*;
import eu.cumulus.database.*;

/**
 * @author filippogaudenzi
 * 
 */
public class ConverterDB_XML {

	// TestBasedCertificationModel
	/**
	 * @param tbcm
	 * @return
	 */
	static public CertificationModel fromXML(
			eu.cumulus.certModelXML.TestBasedCertificationModelType tbcm) {
		// CertificationModelID
		CertificationModel cm = new CertificationModel();
		cm.setId(tbcm.getCertificationModelId().getCmId());

		// Collectors
		List<AbstracCollectorType> abst = tbcm.getCollectors()
				.getAbstractCollector();
		List<GeneralCollectorType> gct = tbcm.getCollectors().getCollector();

		// generateAbstractCollector
		Iterator<AbstracCollectorType> it_ab = abst.iterator();
		List<AbstractCollector> absDB = new ArrayList<AbstractCollector>();
		while (it_ab.hasNext()) {
			AbstractCollector a = ConverterDB_XML.fromXML(it_ab.next());
			a.setCertificationModel(cm);
			absDB.add(a);
		}
		cm.setAbstractCollectors(absDB);

		// generateGeneralCollector
		Iterator<GeneralCollectorType> it_gc = gct.iterator();
		List<Collector> gcDB = new ArrayList<Collector>();
		while (it_gc.hasNext()) {
			Collector c = ConverterDB_XML.fromXML(it_gc.next(), absDB);
			c.setCertificationModel(cm);
			gcDB.add(c);
		}
		// cm.setCollectors(gcDB);

		// lifeCycle
		LifeCycleType lft = tbcm.getLifeCycle();
		cm.setLifeCycleBean(ConverterDB_XML.fromXML(lft));

		// SecurityProperty
		SecurityPropertyType sp = tbcm.getTestedSecurityProperty();
		cm.setPropertyBean(ConverterDB_XML.fromXML(sp));
		if(cm.getPropertyBean()==null){
			return null;
		}
		// Tester
		TesterType tt = tbcm.getTester();
		cm.setTesterBean(ConverterDB_XML.fromXML(tt));

		// TOC
		TocType toct = tbcm.getToc();
		Toc t = ConverterDB_XML.fromXML(toct);
		cm.setTocBean(t);

		return cm;
	}

	// Abstract Collector
	/**
	 * @param next
	 * @return
	 */
	public static AbstractCollector fromXML(AbstracCollectorType next) {
		AbstractCollector ab = new AbstractCollector();
		ab.setId(next.getId());
		ab.setTestCategory(next.getTestCategory());
		ab.setTestDescription(next.getTestDescription());
		ab.setTestGenerationModelLink(next.getTestGenerationModelLink());// TestGenerationModelLink
		ab.setTestType(next.getTestType());
		Iterator<eu.cumulus.certModelXML.TestAttributeType> it_ta = next
				.getTestAttributes().getTestAttribute().iterator();
		ArrayList<eu.cumulus.database.TestAttribute> tas = new ArrayList<eu.cumulus.database.TestAttribute>();
		while (it_ta.hasNext()) {
			tas.add(ConverterDB_XML(it_ta.next(), ab));
		}
		ab.setTestAttributes(tas);
		Iterator<TestCaseType> it_tct = next.getTestCases().getTestCase()
				.iterator();
		ArrayList<eu.cumulus.database.TestCase> tcs = new ArrayList<eu.cumulus.database.TestCase>();
		while (it_tct.hasNext()) {
			tcs.add(ConverterDB_XML(it_tct.next(), ab));
		}
		ab.setTestCases(tcs);
		return ab;
	}

	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static TestAttribute ConverterDB_XML(TestAttributeType next,
			AbstractCollector ab) {
		TestAttribute ta = new TestAttribute();
		ta.setName(next.getName());
		ta.setValue(next.getValue().toString());
		ta.setId(next.getID().toString());
		ta.setAbstractCollector(ab);
		return ta;
	}

	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static TestCase ConverterDB_XML(TestCaseType next,
			AbstractCollector ab) {
		TestCase tc = new TestCase();
		tc.setId(next.getID().intValue());
		tc.setDescription(next.getDescription());
		Iterator<TestInstanceType> it_tit = next.getTestInstance().iterator();
		ArrayList<TestInstance> ti = new ArrayList<TestInstance>();
		while (it_tit.hasNext()) {
			ti.add(ConverterDB_XML.fromXML(it_tit.next(), tc));
		}
		tc.setTestInstance(ti);
		tc.setAbstractCollector(ab);
		return tc;
	}

	/**
	 * @param next
	 * @param tc
	 * @return
	 */
	public static TestInstance fromXML(TestInstanceType next, TestCase tc) {
		TestInstance ti = new TestInstance();
		ti.setTInst_ExpectedOutput(next.getExpectedOutput());
		ti.setTInst_HiddenCommunication(next.getHiddenCommunications());
		ti.setTInst_Input(next.getInput());
		ti.setTInst_Operation(next.getOperation());
		ti.setTInst_PostCondition(next.getPostConditions());
		ti.setTInst_Precondition(next.getPreconditions());
		ti.setTestCase(tc);
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
		c.setExpirationTime(next.getExpirationTime().toGregorianCalendar()
				.getTime());
		c.setIsStatic(next.isIsStatic());
		c.setToDeploy(next.isToDeploy());
		return c;
	}

	/**
	 * @param next
	 * @param ab
	 * @return
	 */
	public static Collector fromXML(GeneralCollectorType next,
			List<AbstractCollector> ab) {
		Collector c = new Collector();
		c.setId(next.getId());
		c.setDescriptor(next.getDescriptor());
		c.setExpirationTime(next.getExpirationTime().toGregorianCalendar()
				.getTime());
		c.setIsStatic(next.isIsStatic());
		c.setToDeploy(next.isToDeploy());
		Iterator<AbstractCollector> it_ab = ab.iterator();
		while (it_ab.hasNext()) {
			AbstractCollector a = it_ab.next();
			if (next.getAbstractCollector().equalsIgnoreCase(a.getId())) {
				a.addCollector(c);
				c.setAbstractCollectorBean(a);
				break;
			}

		}
		return c;
	}

	/**
	 * @param toct
	 * @return
	 */
	private static Toc fromXML(TocType toct) {
		// check if TOC exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Toc.findPerTocId")
				.setParameter("tocid", toct.getId());
		try {
			eu.cumulus.database.Toc tt = (Toc) query.getSingleResult();
			manager.close();
			System.out.println("TOC TROVATO");
			return tt;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();

			Toc t = new Toc();
			t.setConcrete(toct.getConcreteToc());
			t.setDescription(toct.getTocDescription());

			// TODO :make smart function for Cloud Layer
			t.setSaaS(true);
			t.setId(toct.getId());
			t.setUri(toct.getTocURI());
			ArrayList<Tot> ar = new ArrayList<Tot>();
			// ar.add(new Tot());
			// t.setTots(ar);
			return t;
		}

	}

	/**
	 * @param lft
	 * @return
	 */
	public static LifeCycle fromXML(LifeCycleType lft) {
		LifeCycle lc = new LifeCycle();
		lc.setIntialState(lft.getInitialState());
		return lc;
	}

	/**
	 * @param sp
	 * @return
	 */
	public static Property fromXML(SecurityPropertyType sp) {

		// check if property already exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Property.findPerClass")
				.setParameter("clazz", sp.getSProperty().getClazz());
		try {
			eu.cumulus.database.Property pp = (Property) query
					.getSingleResult();
			manager.close();
			return pp;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();
			return null;
			/*Property p = new Property();
			p.setClass_(sp.getSProperty().getClazz());
			p.setId(sp.getSecurityPropertyId());
			p.setSecurityPropertyDefinition(sp.getSecurityPropertyDefinition());
			p.setShortName(sp.getShortName());
			p.setVocabulary(sp.getVocabulary());
			*/
			//TODO it should return null, the property wasn't found
		}

	}

	/**
	 * @param tt
	 * @return
	 */
	public static Tester fromXML(TesterType tt) {
		// check
		// check if Tester exist
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AxisTest");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("Tester.findPerNameAndRole")
				.setParameter("name", tt.getTesterName())
				.setParameter("role", tt.getTesterRole());
		try {
			eu.cumulus.database.Tester t = (Tester) query.getSingleResult();
			manager.close();
			return t;
		} catch (javax.persistence.NoResultException ex) {
			manager.close();
			Tester tester = new Tester();
			tester.setName(tt.getTesterName());
			tester.setRole(tt.getTesterRole());
			return tester;
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
}
