package ch.epfl.risd.pl;

/**
 * This class represents propositional variable in mathematical logic. It can be
 * true or false.
 */

public class PropositionalVariable extends Literal {

	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/

	/* The name of the propositional variable */
	private String name;

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	public PropositionalVariable(String name) {
		this.name = name;
	}

	/* Nothing to calculate for Propositional Variable */
	@Override
	public LogicalEntity calculate() {
		return this;
	}

	/* Not implemented yet */
	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalEntity makeCopy() {
		/* Return different Propositional Variable with the same name */
		return new PropositionalVariable(this.name);
	}

	/* The string representation of the Propositional Variable */
	@Override
	public String toString() {
		return name;
	}
}
