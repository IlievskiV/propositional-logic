package ch.epfl.risd.pl;

/**
 * This class will represent the unary formula, i.e. a formula which contains
 * only one sub-formula.
 */
public abstract class UnaryFormula extends Formula {
	
	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/
	
	/* The  sub-formula this formula is containing */
	protected LogicalEntity entity;
}
