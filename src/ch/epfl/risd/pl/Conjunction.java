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

		/* Flag indicating the end result */
		boolean isDisjunction = false;

		/* Calculate the first entity */
		LogicalEntity calculatedFirstEntity = subEntities.get(0).calculate();

		/* Check if it is disjunction */
		if (calculatedFirstEntity instanceof Disjunction) {
			isDisjunction = true;
			/* Also we should minimize it */
		}

		/* Create a temporary list of entities */
		List<LogicalEntity> left = extractEntities(calculatedFirstEntity);

		/* Iterate starting from the second */
		for (int i = 1; i < subEntities.size(); i++) {
			/* Take the current entity and calculate it */
			LogicalEntity calculatedCurrentEntity = subEntities.get(i).calculate();

			/* Check if it is disjunction */
			if (calculatedCurrentEntity instanceof Disjunction) {
				isDisjunction = true;
				/* We should minimize it */
			}

			/* Extract the right list */
			List<LogicalEntity> right = extractEntities(calculatedCurrentEntity);

			/* Create empty temporary list */
			List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

			/* If we have detected disjunction */
			if (isDisjunction) {
				/* Iterate over the left */
				for (LogicalEntity l : left) {
					/* Iterate over the right */
					for (LogicalEntity r : right) {
						/* Add them as a conjunction */

						/* First extract both entities */
						List<LogicalEntity> all = new LinkedList<LogicalEntity>();

						/* Merge them in one list */
						all.addAll(extractEntities(l));
						all.addAll(extractEntities(r));

						temp.add(new Conjunction(all));
					}
				}
			} else {
				temp.addAll(left);
				temp.addAll(right);
			}

			/* Change left and temporary */
			left = temp;

		}

		if (isDisjunction) {
			return new Disjunction(left);
		} else {
			return new Conjunction(left);
		}
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
		return new Conjunction(temp);
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

	public static void main(String[] args) {

		List<LogicalEntity> temp = new LinkedList<LogicalEntity>();
		temp.add(new PropositionalVariable("p8"));
		temp.add(new PropositionalVariable("p5"));
		temp.add(new PropositionalVariable("p12"));

		LogicalEntity e = new Conjunction(
				new Conjunction(
						new Negation(new Disjunction(new PropositionalVariable("p2"), new PropositionalVariable("p3"))),
						new PropositionalVariable("p4")),
				new Disjunction(new PropositionalVariable("p1"), new Conjunction(temp)));

		System.out.println(e.calculate());

	}
}
