package ch.epfl.risd.pl;

import java.util.LinkedList;
import java.util.List;

/**
 * This class will represent a Negation of one Formula
 */
public class Negation extends UnaryFormula {

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Constructor */
	public Negation(LogicalEntity entity) {
		this.entity = entity;
	}

	@Override
	public LogicalEntity calculate() {

		if (entity instanceof Conjunction) {
			/* Cast it to Conjunction */
			Conjunction conjunction = (Conjunction) entity;

			/* Create a temporary list of logical entities */
			List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

			/* Iterate over the sub-entities of the conjunction */
			for (LogicalEntity e : conjunction.subEntities) {
				/* Add them negated in the temporary list */
				temp.add(new Negation(e));
			}

			/* Create a Disjunction and calculate it */
			Disjunction disjunction = new Disjunction(temp);
			return disjunction.calculate();

		} else if (entity instanceof Disjunction) {
			/* Cast it to Disjunction */
			Disjunction disjunction = (Disjunction) entity;

			/* Create a temporary list of logical entities */
			List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

			/* Iterate over the sub-entities of the disjunction */
			for (LogicalEntity e : disjunction.subEntities) {
				/* Add them negated in the temporary list */
				temp.add(new Negation(e));
			}

			/* Create a Conjunction and calculate it */
			Conjunction conjunction = new Conjunction(temp);
			return conjunction.calculate();

		} else if (entity instanceof Negation) {
			/* Cast it to Negation */
			Negation negation = (Negation) entity;

			/* Negation of negation is the entity itself */
			return negation.entity.calculate();
		} else if (entity instanceof PropositionalVariable) {
			/* Return the negation of the variable */
			return this;
		} else {
			/* Cast it to Constant */
			Constant constant = (Constant) entity;

			/* Check the value of the constant */
			if (constant.value == true) {
				return new Constant(false).calculate();
			} else {
				return new Constant(true).calculate();
			}
		}
	}

	@Override
	public LogicalEntity makeCopy() {
		/* Return different Negation object */
		return new Negation(entity.makeCopy());
	}

	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "!" + entity.toString();
	}
}
