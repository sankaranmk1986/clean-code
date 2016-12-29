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
public class TensProcessorShould {
	
	private TensProcessor tensProcessor;
	
	private int number;
	private String numberInWords;
	
	public TensProcessorShould(int number, String numberInWords){
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
	        {21, "TWENTY ONE"},
	        {30, "THIRTY"},
	        {99, "NINETY NINE"},
	        {100, ""},
	        {101, "ONE"},
	        {523, "TWENTY THREE"},
	        {891, "NINETY ONE"},
	        {1000, ""},
	        {1001, "ONE"},
	        {2632, "THIRTY TWO"},
	        {8990, "NINETY"},
	        {9999, "NINETY NINE"}
	    });
	  }
	
	@Before
	public void setup(){
		tensProcessor = new TensProcessor();
	}
	
	@Test
	public void return_2_digit_in_word_for_given_number(){
		assertThat(tensProcessor.convertToWord(number), is(numberInWords));
	}
}
