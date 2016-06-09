package ch.epfl.risd.pl;

/**
 * This class is representing a base class.
 */
public abstract class LogicalEntity {
	
	
	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/
	
	/* Function to calculate the formula */
	public abstract LogicalEntity calculate();

	/* Function to evaluate the formula */
	public abstract String evaluate();

}
