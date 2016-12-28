package org.cleancode.katas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PerfectNumberFinderShould {

	@Test
	public void able_to_create_PerfectNumberFinder(){
		PerfectNumberFinder perfectNumberFinder = new PerfectNumberFinder();
		assertNotNull(perfectNumberFinder);
	}
	
}
