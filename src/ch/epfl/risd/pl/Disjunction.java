package ch.epfl.risd.pl;

import java.util.LinkedList;
import java.util.List;

/**
 * This class will represent the Disjunction
 */
public class Disjunction extends Formula {

	/****************************************************************************/
	/* VARIABLES */
	/***************************************************************************/

	/* The list of sub-formulas of which the disjunction is consisted */
	private List<Formula> subFormulas;

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Constructor for empty list of sub-formulas */
	public Disjunction() {
		subFormulas = new LinkedList<>();
	}

	/* Constructor for disjunction of two formulas */
	public Disjunction(Formula formula1, Formula formula2) {
		subFormulas = new LinkedList<>();
		subFormulas.add(formula1);
		subFormulas.add(formula2);
	}

	/* Constructor for the disjunction of list of sub-formulas */
	public Disjunction(List<Formula> subFormulas) {
		this.subFormulas = subFormulas;
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
		/* The resulting string */
		StringBuilder sb = new StringBuilder();

		/* Iterate over the sub-formulas */
		for (Formula f : subFormulas) {
			sb.append(f.toString() + "+");
		}

		/* Cut the last star */
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	/* Get the list of sub-formulas */
	public List<Formula> getSubFormulas() {
		return subFormulas;
	}
}
