package eu.cumulus.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Celemetry {
    static private String TASK_CERTIFICATION="testagent.tasks.start_certification";
	
	public static String wrapMessage(String m) {
		//Marshalling m
		eu.cumulus.utilities.JaxbUnmarshal jax = new eu.cumulus.utilities.JaxbUnmarshal(m, "eu.cumulus.agentMessageXML");
		eu.cumulus.agentMessageXML.Collector coll=(eu.cumulus.agentMessageXML.Collector)jax.getUnmarshalledObject();		
		String cm_id=coll.getCmid();
		String coll_id=coll.getId();
		String agent="agent1";
		
		//new eu.cumulus.utilities.JaxbUnmarshal(
		// TODO Auto-generated method stub
		JSONObject jobj=new JSONObject();
		jobj.put("id", agent+"#"+cm_id+"#"+coll_id);
		jobj.put("task", TASK_CERTIFICATION);
		jobj.put("retries", 0);
		JSONArray args=new JSONArray();
		args.add(m);
		jobj.put("args", args);
		return jobj.toString();
	}

}
