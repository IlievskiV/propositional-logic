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
		List<LogicalEntity> temp = new LinkedList<LogicalEntity>();
		
		/* If Formula */
		if (calculatedFirstEntity instanceof Formula) {
			if (calculatedFirstEntity instanceof UnaryFormula) {
				/* Cast it to Unary Formula */
				UnaryFormula unaryFormula = (UnaryFormula) calculatedFirstEntity;
				/* Add the sub-entity of the unary formula */
				temp.add(unaryFormula.entity.makeCopy());
			} else {
				/* Cast it to Binary Formula */
				BinaryFormula binaryFormula = (BinaryFormula) calculatedFirstEntity;
				/* Iterate over the sub-entities and add them */
				for (LogicalEntity e : binaryFormula.subEntities) {
					temp.add(e.makeCopy());
				}
			}
		}
		/* If Literal */
		else {
			temp.add(calculatedFirstEntity.makeCopy());
		}
		
		
		/* Iterate starting from the second */
		for (int i = 1; i < subEntities.size(); i++) {
			/* Take the current entity and calculate it */
			LogicalEntity calculatedCurrentEntity = subEntities.get(i).calculate();

			/* Check if it is disjunction */
			if (calculatedCurrentEntity instanceof Disjunction) {
				isDisjunction = true;
				/* We should minimize it */
			}
			
			
			/* If we have detected disjunction */
			if (isDisjunction) {
				
			}else{
				
			}
		}

		/* Iterate over the sub-entities */

		return null;
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
}
