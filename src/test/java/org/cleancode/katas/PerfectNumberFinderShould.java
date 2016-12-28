package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PerfectNumberFinderShould {
	
	private PerfectNumberFinder perfectNumberFinder;
	private int number;
	private boolean result;
	
	public PerfectNumberFinderShould(int number, boolean result){
		this.number=number;
		this.result=result;
	}
	
	 @Parameters(name = "return_{1}_for_number_{0}()")
	  public static Collection<Object[]> data() {
	    return asList(new Object[][] {
	        {1, false},
	        {2, false},
	        {6, true},
	        {10, false},
	        {28, true},
	        {495, false},
	        {496, true},
	        {8127, false},
	        {8128, true}
	    });
	  }
	
	@Before
	public void setup(){
		perfectNumberFinder = new PerfectNumberFinder();
	}
	

	@Test
	public void able_to_create_PerfectNumberFinder(){
		assertNotNull(perfectNumberFinder);
	}
	
	@Test
	public void find_given_number_is_a_perfect_number(){
		Assert.assertThat(perfectNumberFinder.isPerfectNumber(number), is(result));
	}
	
}
