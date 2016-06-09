package ch.epfl.risd.pl;

/**
 * This class will represent a Negation of one Formula
 */
public class Negation extends UnaryFormula {

	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/

	

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Constructor */
	public Negation(Formula formula) {
		this.formula = formula;
	}
	
	
	@Override
	public Formula calculate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return formula.toString();
	}
}
