package ch.epfl.risd.pl;

/**
 * This class represents propositional variable in mathematical logic. It can be
 * true or false.
 */

public class PropositionalVariable extends Formula {

	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/

	/* The name of the propositional variable */
	private String name;

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/
	
	/* Nothing to calculate for Propositional Variable */
	@Override
	public Formula calculate() {
		return this;
	}
	
	/* Not implemented yet */
	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* The string representation of the Propositional Variable */
	@Override
	public String toString() {
		return name;
	}
}	
