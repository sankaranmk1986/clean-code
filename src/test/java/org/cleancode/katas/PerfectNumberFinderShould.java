package org.cleancode.katas;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

public class PerfectNumberFinderShould {

	@Test
	public void able_to_create_PerfectNumberFinder(){
		PefectNumberFinder perfectNumberFinder = new PerfectNumberFinder();
		assertNotNull(perfectNumberFinder);
	}
	
}
