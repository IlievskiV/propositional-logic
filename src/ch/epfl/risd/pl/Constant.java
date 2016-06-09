package ch.epfl.risd.pl;


/**
 * This class represents a Constant with a value either TRUE of FALSE;
 */
public class Constant extends Formula{
	
	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/
	
	/* The value of the constant */
	private boolean value;
	
	
	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/
	
	/* Constructor */
	public Constant(boolean value){
		this.value = value;
	}
	
	
	/* Nothing to calculate for the Constant */
	@Override
	public Formula calculate() {
		return this;
	}
	
	/* Not implemented yet */
	@Override
	public String evaluate() {
		return null;
	}

	/* The String representation of the Constant */
	@Override
	public String toString() {
		return "" + value;
	}
}
