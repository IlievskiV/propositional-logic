package ch.epfl.risd.pl;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a Conjunction.
 */
public class Conjunction extends BinaryFormula {

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Constructor for empty list of sub-formulas */
	public Conjunction() {
		subFormulas = new LinkedList<Formula>();
	}

	/* Constructor for conjunction of two formulas */
	public Conjunction(Formula formula1, Formula formula2) {
		subFormulas = new LinkedList<Formula>();
		subFormulas.add(formula1);
		subFormulas.add(formula2);
	}

	/* Constructor for the conjunction of list of sub-formulas */
	public Conjunction(List<Formula> subFormulas) {
		this.subFormulas = subFormulas;
	}

	@Override
	public LogicalEntity calculate() {
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
			sb.append(f.toString() + "*");
		}

		/* Cut the last star */
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
