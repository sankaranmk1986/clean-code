package org.cleancode.katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class PerfectNumberFinderShould {
	
	private PerfectNumberFinder perfectNumberFinder;
	
	@Before
	public void setup(){
		perfectNumberFinder = new PerfectNumberFinder();
	}
	

	@Test
	public void able_to_create_PerfectNumberFinder(){
		assertNotNull(perfectNumberFinder);
	}
	
	@Test
	public void return_false_for_number_1(){
		assertFalse(perfectNumberFinder.isPerfectNumber(1));
	}
	
}
