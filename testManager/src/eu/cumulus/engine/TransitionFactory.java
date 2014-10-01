package eu.cumulus.engine;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import eu.cumulus.engine.LyfeCycleTransitionsSaxParser.Trans;

public class TransitionFactory {

	
	
	public static HashMap<String,ArrayList<Transition>> getTransition(String XML,ArrayList<String> states) throws Exception {
		HashMap<String, ArrayList<Transition>> result = new HashMap<String,ArrayList<Transition>>();
		for(String state:states){
			result.put(state, new  ArrayList<Transition>());
		}
		
		
		 SAXParserFactory  spf = SAXParserFactory.newInstance();
		spf.setValidating(false);
		//spf.setNamespaceAware(false);
		SAXParser saxParser;
		LyfeCycleTransitionsSaxParser tranParser;
		try {
			saxParser = spf.newSAXParser();
			 tranParser = new LyfeCycleTransitionsSaxParser();
			saxParser.parse( new InputSource(new StringReader(XML)),tranParser);
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}			
		//saxParser.getTransition();
		ArrayList<Trans> transitions = tranParser.getTransitions();
		for (Trans t : transitions){ 
			result.get(t.getFrom()).add(new Transition(t.getFrom(),t.getTo(),t.getExp(),t.getCollectors()));
		}
		return result;
		
		
		
		//return null;
	}
}
