package ch.epfl.risd.pl;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is representing a base class.
 */
public abstract class LogicalEntity {

	/****************************************************************************/
	/* PUBLIC METHODS */
	/***************************************************************************/

	/* Function to calculate the formula */
	public abstract LogicalEntity calculate();

	/* Function to evaluate the formula */
	public abstract String evaluate();

	/* Function to make copy of the object */
	public abstract LogicalEntity makeCopy();

	/* Function to extract entities in one list */
	public List<LogicalEntity> extractEntities(LogicalEntity entity) {

		/* Create a temporary list of entities */
		List<LogicalEntity> temp = new LinkedList<LogicalEntity>();

		/* If Formula */
		if (entity instanceof Formula) {
			if (entity instanceof UnaryFormula) {
				/* Cast it to Unary Formula */
				UnaryFormula unaryFormula = (UnaryFormula) entity;
				/* Add the sub-entity of the unary formula */
				temp.add(unaryFormula.makeCopy());
			} else {
				/* Cast it to Binary Formula */
				BinaryFormula binaryFormula = (BinaryFormula) entity;
				/* Iterate over the sub-entities and add them */
				for (LogicalEntity e : binaryFormula.subEntities) {
					temp.add(e.makeCopy());
				}
			}
		}
		/* If Literal */
		else {
			temp.add(entity);
		}
		return temp;
	}
}
