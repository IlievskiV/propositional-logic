package ch.epfl.risd.pl.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import ch.epfl.risd.pl.Disjunction;
import ch.epfl.risd.pl.LogicalEntity;
import ch.epfl.risd.pl.PropositionalVariable;

/**
 * This class will contain all tests for calculation of one logical entity.
 */

public class CalculationTests {

	@Test
	public void test1() {
		LogicalEntity e = new Disjunction(new PropositionalVariable("a"), new PropositionalVariable("b"));
	}

}
