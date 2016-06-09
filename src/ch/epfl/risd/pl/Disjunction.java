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

		/* Calculate the first entity */
		LogicalEntity calculatedFirstEntity = subEntities.get(0).calculate();

		/* Create a temporary list of entities */
		List<LogicalEntity> left = extractEntities(calculatedFirstEntity);

		/* Iterate starting from the second */
		for (int i = 1; i < subEntities.size(); i++) {
			/* Take the current entity and calculate it */
			LogicalEntity calculatedCurrentEntity = subEntities.get(i).calculate();

			/* Extract the right list */
			List<LogicalEntity> right = extractEntities(calculatedCurrentEntity);

			/* Create empty temporary list */
			List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

			temp.addAll(left);
			temp.addAll(right);

			left = temp;
		}

		return new Disjunction(left);
	}

	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalEntity makeCopy() {

		/* Create a temporary list */
		List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

		/* Iterate over the list of sub-entities */
		for (LogicalEntity e : subEntities) {
			/* Add copy of them */
			temp.add(e.makeCopy());
		}

		return new Disjunction(temp);
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
