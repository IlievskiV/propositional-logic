package ch.epfl.risd.pl;

import java.util.LinkedList;
import java.util.List;

/**
 * This class will represent the Disjunction
 */
public class Disjunction extends BinaryFormula {

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Constructor for empty list of sub-formulas */
	public Disjunction() {
		subEntities = new LinkedList<LogicalEntity>();
	}

	/* Constructor for disjunction of two formulas */
	public Disjunction(LogicalEntity entity1, LogicalEntity entity2) {
		subEntities = new LinkedList<LogicalEntity>();
		subEntities.add(entity1);
		subEntities.add(entity2);
	}

	/* Constructor for the disjunction of list of sub-formulas */
	public Disjunction(List<LogicalEntity> subEntities) {
		this.subEntities = subEntities;
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

		/* Iterate over the sub-entities */
		for (LogicalEntity l : subEntities) {
			sb.append(l.toString() + "+");
		}

		/* Cut the last star */
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
