package eu.cumulus.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Parses the ASC translations file
 * 
 * @author celli
 *
 */
public class LyfeCycleTransitionsSaxParser extends DefaultHandler {

	// mappings
	private Map<String, List<String>> code2uris;

	// flag for contents
	private boolean isCode;
	private boolean isURI;
	private String tmpCode;

	private String formula = "", from, to;
	private boolean tran = false, subtran = false, negated = false;
	// to read the entire content
	private StringBuffer buffer;
	private String element;
	private ArrayList<Trans> transitions;
	private ArrayList<String> collectors;
	private Logger log;

	public ArrayList<Trans> getTransitions() {
		return transitions;
	}

	public LyfeCycleTransitionsSaxParser() {
		log = Logger.getLogger(LyfeCycleTransitionsSaxParser.class);
		this.transitions = new ArrayList<Trans>();
		this.collectors = new ArrayList<String>();
	}

	public void startDocument() throws SAXException {
		// System.out.println("start document   : ");
	}

	public void endDocument() throws SAXException {
		// System.out.println("end document     : ");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.element = qName;
		//System.out.println("start element    : " + qName);
		if (qName.equalsIgnoreCase("transitions")) {
			 System.out.println("START ANALYZING");
		} else {
			if (qName.equalsIgnoreCase("transition")) {
				log.info("Buildin Life Cycle Transistion From:"
						+ attributes.getValue("From") + " TO:"
						+ attributes.getValue("To"));
				System.out.println("Buildin Life Cycle Transistion From:"
						+ attributes.getValue("From") + " TO:"
						+ attributes.getValue("To"));
				this.from = attributes.getValue("From");
				this.to = attributes.getValue("To");
			} else {
				if (qName.equalsIgnoreCase("whencondition")) {
					tran = true;
					if (attributes.getValue("negated") != null) {
						if (attributes.getValue("negated").equalsIgnoreCase("true"))
							formula += "!(";
						else
							formula += "(";
					} else {
						formula += "(";
					}
				}
			}
			if ((qName.equalsIgnoreCase("LogicalExpression"))
					|| (qName.equalsIgnoreCase("LogicalOperator"))){
				if ((qName.equalsIgnoreCase("LogicalExpression"))
						&& (attributes.getValue("negated") != null))
					if (attributes.getValue("negated").equalsIgnoreCase("true"))
						this.negated = true;
					else
						this.negated = false;
			subtran = true;
			if (this.element.compareTo("LogicalExpression") == 0) {

				// System.out.println(this.element);
				// System.out.println("Adding "+contenuto+" to Formula");
				//
				if (negated) {
					this.formula += "!(";

				} else {
					this.formula += "(";
				}
				negated = false;
				tran=false;
			}
			}
		}

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("end element    : " + qName);
		if (qName.equalsIgnoreCase("transition")) {
			formula += ")";

			// change formula October
			formula = formula.trim().replaceAll("//s+", "");
			log.info("Transition Formula:" + this.formula + "");
			System.out.println("Transition Formula:" + this.formula + "");
			// save transition
			String[] cols = new String[collectors.size()];
			int i = 0;
			for (String c : this.collectors) {
				cols[i] = c;
				i++;
			}
			this.transitions.add(new Trans(this.from, this.to, this.formula,
					cols));
			this.formula = "";
			this.collectors.clear();

		}
		if (qName.compareTo("LogicalExpression") == 0) {
			formula += ")";
		}
		// if(!formula.equalsIgnoreCase(""))
		// System.out.println("formula      : " + formula);
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
		
		String contenuto = new String(ch, start, length);
		contenuto = contenuto.replaceAll("\\s", "");
		/*if(!contenuto.equalsIgnoreCase(""))
			 System.out.println("start characters : " + new String(ch, start, length));*/
			
		if (this.tran) {
			if (this.element.compareTo("collectorCondition") == 0) {

				// System.out.println(this.element);
				// System.out.println("Adding "+contenuto+" to Formula");
				//
				contenuto = contenuto.replaceAll("\\s", "");
				this.formula += contenuto;

				this.collectors.add(contenuto);

				tran = false;
			}
			/* CHANGED IN OCTOBER
			 * *if (this.element.compareTo("LogicalExpression") == 0) {

				// System.out.println(this.element);
				// System.out.println("Adding "+contenuto+" to Formula");
				//

				this.formula += "(";
				tran = false;
			}*/
		} else {
			if (this.subtran) {
				if (this.element.compareTo("collectorCondition") == 0) {

					// ADDED 15/10/2014
					String ck = contenuto.replaceAll(" ", "");
					if (!ck.equalsIgnoreCase(""))
						this.collectors.add(contenuto);

					this.formula += contenuto;

					subtran = false;
				}
				/*CHANGED IN OCTOBER
				 * if (this.element.compareTo("LogicalExpression") == 0) {

					// System.out.println(this.element);
					// System.out.println("Adding "+contenuto+" to Formula");
					//
					if (negated) {
						this.formula += "!(";

					} else {
						this.formula += "(";
					}
					negated = false;

				}*/
				if (this.element.compareTo("LogicalOperator") == 0) {

					// System.out.println(this.element);
					// System.out.println("Adding "+contenuto+" to Formula");

					String op = "";
					if (contenuto.equalsIgnoreCase("and"))
						op = "&&";
					if (contenuto.equalsIgnoreCase("or"))
						op = "||";
					if (!op.equalsIgnoreCase(""))
						formula += " " + op + " ";

				}
			}
		}
		// System.out.println("start characters : " +
		// new String(ch, start, length));
	}

	public class Trans {
		private String from, to, exp;
		private String[] collectors;

		public String[] getCollectors() {
			return collectors;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getExp() {
			return exp;
		}

		public void setExp(String exp) {
			this.exp = exp;
		}

		public Trans(String from, String to, String exp, String[] cols) {
			this.to = to;
			this.from = from;
			this.exp = exp;
			this.collectors = cols;
		}
	}

}