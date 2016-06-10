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
		
		/* Create empty temporary list */
		List<LogicalEntity> res = new LinkedList<LogicalEntity>();
		
		
		for(LogicalEntity e : subEntities){
			LogicalEntity calculatedCurrentEntity = e.calculate();
			res.add(calculatedCurrentEntity);
		}
		
		return new Disjunction(res);
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
