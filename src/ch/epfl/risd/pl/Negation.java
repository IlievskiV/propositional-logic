package ch.epfl.risd.pl;

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
		
		if(entity instanceof Conjunction){
			
		}else if(entity instanceof Disjunction){
			
		}else if(entity instanceof Negation){
			
		}else if(entity instanceof PropositionalVariable){
			
		}else{
			
		}
		
		return null;
	}

	@Override
	public String evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return entity.toString();
	}
}
