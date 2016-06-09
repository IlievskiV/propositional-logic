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
		subEntities = new LinkedList<LogicalEntity>();
	}

	/* Constructor for conjunction of two formulas */
	public Conjunction(LogicalEntity entity1, LogicalEntity entity2) {
		subEntities = new LinkedList<LogicalEntity>();
		subEntities.add(entity1);
		subEntities.add(entity2);
	}

	/* Constructor for the conjunction of list of sub-formulas */
	public Conjunction(List<LogicalEntity> subEntities) {
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

		/* Iterate over the sub-entitiess */
		for (LogicalEntity l : subEntities) {
			sb.append(l.toString() + "*");
		}

		/* Cut the last star */
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}
