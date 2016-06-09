package ch.epfl.risd.pl;

import java.util.List;

/**
 * This class represents a binary formula, i.e. a formula which contains
 * multiple sub-formulas.
 */
public abstract class BinaryFormula extends Formula {

	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/

	/* The list of sub-formulas of which the binary formula is consisted */
	protected List<Formula> subFormulas;

	/* Get the list of sub-formulas */
	public List<Formula> getSubFormulas() {
		return subFormulas;
	}
}
