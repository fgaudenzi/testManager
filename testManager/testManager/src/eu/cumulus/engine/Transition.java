package eu.cumulus.engine;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;

public class Transition  {
	String from,to;
	private ExpressionEvaluator ev;
	private String[] param;
	public String[] getParam() {
		return param;
	}
	private String expr;
	public Transition(String from,String to,String expr,String[] param) throws Exception{
		this.from=from;
		this.to=to;
		this.param=param;
		Class[] app=new Class[param.length];
		for(int i=0;i<param.length;i++){
			app[i]=boolean.class;
		}
		this.expr=expr;
		this.ev=new ExpressionEvaluator(
			     expr,                     // expression
			     boolean.class,                           // expressionType
			     param,           // parameterNames
			     app // parameterTypes
			 );
	}
	public boolean evaluate(ArrayList<Boolean> values) throws Exception {
		Object[] toEv = new Object[values.size()];
		int i=0;
		for(Boolean b:values){
			toEv[i]=b;
			i++;
		}
		return (Boolean) this.ev.evaluate(toEv);
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getExpr() {
		return expr;
	}
	
	
	
	
	
	
	/*
	 *  ExpressionEvaluator ee = new ExpressionEvaluator(
		     "coll1 && coll2 || coll3 ",                     // expression
		     boolean.class,                           // expressionType
		     new String[] { "coll1", "coll2", "coll3" },           // parameterNames
		     new Class[] { boolean.class, boolean.class,boolean.class } // parameterTypes
		 );
	 */
}
