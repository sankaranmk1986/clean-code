package org.cleancode.katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PerfectNumberFinderShould {

	@Test
	public void able_to_create_PerfectNumberFinder(){
		PerfectNumberFinder perfectNumberFinder = new PerfectNumberFinder();
		assertNotNull(perfectNumberFinder);
	}
	
	@Test
	public void return_false_for_number_1(){
		PerfectNumberFinder perfectNumberFinder = new PerfectNumberFinder();
		assertFalse(perfectNumberFinder.isPerfectNumber(1));
	}
	
}
