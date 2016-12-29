package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value=Parameterized.class)
public class OnesProcessorShould {
	
	private OnesProcessor onesProcessor;
	
	private int number;
	private String numberInWords;
	
	public OnesProcessorShould(int number, String numberInWords){
		this.number=number;
		this.numberInWords=numberInWords;
	}
	
	 @Parameters(name = "return_{1}_for_number_{0}()")
	 public static Collection<Object[]> data() {
	    return asList(new Object[][] {
	        {1, "ONE"},
	        {2, "TWO"},
	        {3, "THREE"},
	        {10, "TEN"},
	        {19, "NINETEEN"},
	        {20, ""},
	        {21, "ONE"},
	        {99, "NINE"},
	        {100, ""},
	        {101, "ONE"},
	        {9999, "NINE"}
	    });
	  }
	
	@Before
	public void setup(){
		onesProcessor = new OnesProcessor();
	}
	
	@Test
	public void return_first_digit_in_word_for_given_number(){
		assertThat(onesProcessor.convertToWord(number), is(numberInWords));
	}
}
