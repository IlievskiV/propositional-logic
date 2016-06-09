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
	protected List<LogicalEntity> subEntities;
	
	/* Get the list of sub-entities */
	public List<LogicalEntity> getSubEntities() {
		return subEntities;
	}
}
