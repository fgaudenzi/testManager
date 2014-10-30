package eu.cumulus.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.cumulus.certificate.model.AtomicStateType;
import org.cumulus.certificate.model.IndividualTransitionType;
import org.cumulus.certificate.model.LogicalExpressionType;
import org.cumulus.certificate.model.StateTransitionModelType;
import org.cumulus.certificate.model.StateType;
import org.cumulus.certificate.model.StatesType;
import org.cumulus.certificate.model.TransitionsType;
import org.cumulus.certificate.model.test.GeneralCollectorType;
import org.cumulus.certificate.model.test.GeneralCollectorType.Aggregator.TestMetrics;
import org.cumulus.certificate.model.test.TestCertificationModel;
import org.cumulus.certificate.model.test.TestMetricsType.TestMetric;

import com.mysql.jdbc.log.Log;

import eu.cumulus.Persistence.DBtables.Certificate;
import eu.cumulus.Persistence.DBtables.Certificationmodel;
import eu.cumulus.ServiceInterface.TestManagerInterfaceImplementation;
import eu.cumulus.init.InitContextListener;

/**
 * @author iridium
 *
 */
public class CertificationEvaluator {
    private HashMap<String, Collector> collectors;
	private String LifeCycleState;
	private HashMap<String,ArrayList<Transition>> transitions;
	private String cmID;
	private Logger log;
    public CertificationEvaluator(String xml, String status) {
    	log = Logger.getLogger(CertificationEvaluator.class);
    	this.LifeCycleState=status;
		String context = "org.cumulus.certificate.model.test";
		eu.cumulus.utilities.JaxbUnmarshal unmarshall = new eu.cumulus.utilities.JaxbUnmarshal(xml, context);
		JAXBElement obj = (JAXBElement) unmarshall.getUnmarshalledObject();
		this.collectors=new HashMap<String, Collector>();
		TestCertificationModel tbcm = (TestCertificationModel) obj
				.getValue();
		this.cmID=tbcm.getCertificationModelID();
		List<GeneralCollectorType> colls = tbcm.getCollectors().getCollector();
		Iterator<GeneralCollectorType> it_colls = colls.iterator();
		while(it_colls.hasNext()){
			GeneralCollectorType gc=it_colls.next();
			String colid=gc.getId();
			GeneralCollectorType.Aggregator agg=gc.getAggregator();
			List<TestMetric> tm = agg.getTestMetrics().getTestMetric();
			Iterator<TestMetric> it_tm=tm.iterator();
			TestMetric values=it_tm.next();
			this.collectors.put(colid, 
			new Collector(colid, new Aggregator(values.getExpected(),values.getOperation())));
		}
		
		StateTransitionModelType lc = tbcm.getLifeCycle();
		List<StatesType> states_xml = lc.getStates();
		Iterator<StatesType> it_states = states_xml.iterator();
		ArrayList<String> states=new ArrayList<String>();
		while(it_states.hasNext()){
			Iterator<StateType> it_app = it_states.next().getState().iterator();
			while(it_app.hasNext()){
			AtomicStateType app=it_app.next().getAtomicState();
			String state=app.getStateId();
			states.add(state);
			//System.out.println(state);
			}
		}
		try {
			this.transitions=TransitionFactory.getTransition(xml, states);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		log.info("Transition Evaluation Complete");
		
		/*List<IndividualTransitionType> trs = lc.getTransitions().iterator().next().getTransition();
		Iterator<IndividualTransitionType> it_trs = trs.iterator();
		while(it_trs.hasNext()){
			IndividualTransitionType tran = it_trs.next();
			String from=tran.getFrom();
			String to=tran.getTo();
			LogicalExpressionType condition = tran.getWhenCondition();
			String expression=createLogicalExpression("",condition);
			try {
				Transition t = new Transition(from,to,expression, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		}*/
	}
    
 /*   
    private static String createLogicalExpression(String formula,
			LogicalExpressionType condition) {
		// TODO Auto-generated method stub
    	String single_condition=condition.getCondition().getCollectorCondition();
    	if(single_condition!=null){
    		formula+=" single_condition ";
    	}
    	//List<Object> pair = condition.getLogicalOperatorAndLogicalExpression();
    	LogicalExpressionType nextFormula = condition.getLogicalExpressionRoot();
    	String operator = (String) condition.getLogicalOperatorAndLogicalExpression().get(0);
		formula+=operator+" ";
    	return formula;
	}

*/
	/**
     * 
     */
    private boolean checkTransition(Transition t){
    	String[] colls=t.getParam();
    	boolean ready=true;
    	ArrayList<Boolean> values = new ArrayList<Boolean>(); 
    	for(String coll:colls){
    		Boolean c_stat=this.collectors.get(coll).getStatus();
    		if(c_stat==null){
    			ready=false;
    			break;
    		}else{
    			values.add(c_stat);
    		}
    	}
    	log.info("Transition enabled:"+ready);
    	if(ready){
    		try {
    			log.info("values:"+values.toString()+" expression:"+t.getExpr()+" output:"+t.evaluate(values));
				return t.evaluate(values);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
				}
    	}else{
    		return false;
    	}
    	
    }
    private void LifeCycleUpdater(){
    	ArrayList<Transition> ts=this.transitions.get(this.LifeCycleState);
    	for(Transition t:ts){
    		log.info("Checking Transition from "+t.from+" to "+t.to);
    		if((checkTransition(t))&&(!t.getTo().equalsIgnoreCase(this.LifeCycleState))){
    			//make movement
    			EntityManagerFactory factory = Persistence
    					.createEntityManagerFactory("testManager");
    			EntityManager manager = factory.createEntityManager();
    			Certificationmodel cmR = null;
    			cmR = manager.find(Certificationmodel.class, cmID);
    			Query query = manager
    					.createNamedQuery("Certificate.findPerCM").setParameter("cm", cmR);
    			List<Certificate> ll = query.getResultList();
    			Iterator<Certificate> it_c=ll.iterator();
    			Certificate cc=null;
    			if(it_c.hasNext()){
    				cc=it_c.next();
    				cc.setStatus(t.to);
    				Logger log = Logger.getLogger(CertificationEvaluator.class);
    				log.info("Changed CERTIFICATE " +cc.getTimestamp()+" status from "+t.from+" to "+t.to);
    				this.LifeCycleState=t.to;
    				manager.getTransaction().begin();
    				manager.merge(cc);
    				//manager.merge(cc);
    				manager.getTransaction().commit();
    				// Random randomGenerator = new Random();
    				// create certificate!
    				manager.close();
    				return;
    			}else{
    				
    			}
    			
    				
    		}
    	}
    }
    
    
    
    
    static public String evaluateTransition (Transition[] t){
    	return null;
    }
    
    /**
     * @param c_id
     * @param value
     */
    public void updateCollector(String c_id,String value){
    	Logger log = Logger.getLogger(TestManagerInterfaceImplementation.class);
		log.info("Collector:"+ c_id+ " update state to:"+value);
    	Collector checker=this.collectors.get(c_id);
		value=value.replaceAll("[\n\r]", "");
    	checker.updateAggregator(value);
    	LifeCycleUpdater();
    }
   
    /**
     * @author iridium
     *
     */
    private class Collector{
		Aggregator agg;
		String id;
		Boolean Status=null;
		public Collector(String id,Aggregator aggregator){
			this.agg=aggregator;
			this.id=id;
		}
		/**
		 * @param value
		 */
		public void updateAggregator(String value) {
			Status=agg.checker(value);
			
		}
		/**
		 * @return
		 */
		public Boolean getStatus(){
			return Status;
		}
		
	}
	
	/**
	 * @author iridium
	 *
	 */
	private class Aggregator{
		String expected,tested;
		String operation;
		
		/**
		 * @param expected
		 * @param operation
		 */
		public Aggregator(String expected, String operation){
			this.expected=expected.replace("\t", "");
			this.operation=operation.replace("\t", "");
		}
		/**
		 * @param tested
		 * @return
		 */
		public boolean checker(String tested){
			try{
			if (expected.equalsIgnoreCase("TRUE") || expected.equalsIgnoreCase("FALSE")) {
				boolean expected_value=Boolean.parseBoolean(expected);
				boolean tested_value;
				if (tested.equalsIgnoreCase("TRUE"))
					tested_value=true;
				else
					tested_value=false;
				
				if(operation.equalsIgnoreCase("=")){
					if(expected_value==tested_value)
						return true;
					else
						return false;
				}
				
				
			}else{
				int expected_value=Integer.parseInt(expected);
				tested=tested.replaceAll("[\n\r]", "");
				int tested_value=Integer.parseInt(tested);
				//Operation
				if(operation.equalsIgnoreCase("=")){
					if(expected_value==tested_value)
						return true;
				}else{
					if(operation.equalsIgnoreCase("<")){
						if(expected_value>tested_value)
							return true;
					}else{
						if(operation.equalsIgnoreCase(">=")){
							if(expected_value<=tested_value)
								return true;
						}
					}
				}
			}
			}catch(Exception e){
				return false;
			}
			return false;
		}
	}

}
