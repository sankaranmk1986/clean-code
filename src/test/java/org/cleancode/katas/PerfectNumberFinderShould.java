package org.cleancode.katas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	public void return_false_for_nonperfect_number(){
		assertFalse(perfectNumberFinder.isPerfectNumber(1));
		assertFalse(perfectNumberFinder.isPerfectNumber(10));
		assertFalse(perfectNumberFinder.isPerfectNumber(495));
		assertFalse(perfectNumberFinder.isPerfectNumber(8127));
	}
	
	@Test
	public void return_true_for_perfect_number(){
		assertTrue(perfectNumberFinder.isPerfectNumber(6));
		assertTrue(perfectNumberFinder.isPerfectNumber(28));
		assertTrue(perfectNumberFinder.isPerfectNumber(496));
		assertTrue(perfectNumberFinder.isPerfectNumber(8128));
	}	
	
}
