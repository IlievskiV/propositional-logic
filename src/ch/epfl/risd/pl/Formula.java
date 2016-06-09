package ch.epfl.risd.pl;

/**
 * Base class for the propositional logic.
 */
public abstract class Formula {

	/* Function to calculate the formula */
	public abstract Formula calculate();
	
	/* Function to evaluate the formula */
	public abstract String evaluate();

}
