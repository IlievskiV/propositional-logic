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
	
	/* The calculation is the formula itself */
	@Override
	public Formula calculate() {
		return this;
	}
	
	
	/* The string representation of the variable */
	@Override
	public String toString() {
		return name;
	}


	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}
}	
