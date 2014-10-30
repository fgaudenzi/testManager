package eu.cumulus.testingpkg;

import org.codehaus.janino.ExpressionEvaluator;



public class Evaluator {
	 public static void
	    main(String[] args) throws Exception {
		 
		// Compile the expression once; relatively slow.
		 ExpressionEvaluator ee = new ExpressionEvaluator(
		     "!(cfile)",                     // expression
		     boolean.class,                           // expressionType
		     new String[] { "cfile" },           // parameterNames
		     new Class[] { boolean.class } // parameterTypes
		 );
		  
		 
		 // Evaluate it with varying parameter values; very fast.
		 Boolean res = (Boolean) ee.evaluate(
		     new Object[] {          // parameterValues
		         new Boolean(false),
		         
		     }
		 );
		 //ee.guessParameterNames(scanner)
		 System.out.println("res = " + res);
	 }
}


//scrivere dall'xml la formula boolean utilizzando i collector ID
//Estendere ExpressionEvaluator, mettere un array di stringhe con gli ID dei collector in modo da saper l'ordine!