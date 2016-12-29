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
public class HundredsAndHigherDigitProcessorShould {
	
	private HundredsAndHigherDigitProcessor processor;
	
	private int number;
	private String numberInWords;
	
	public HundredsAndHigherDigitProcessorShould(int number, String numberInWords){
		this.number=number;
		this.numberInWords=numberInWords;
	}
	
	 @Parameters(name = "return_{1}_for_number_{0}()")
	 public static Collection<Object[]> data() {
	    return asList(new Object[][] {
	        {1, "ONE"},
	        {100, "ONE HUNDRED"},
	        {301, "THREE HUNDRED AND ONE"},
	        {999, "NINE HUNDRED AND NINETY NINE"},
	        {1000, "ONE THOUSAND"},
	        {1001, "ONE THOUSAND ONE"},
	        {2500, "TWO THOUSAND FIVE HUNDRED"},
	        {8000, "EIGHT THOUSAND"},
	        {9998, "NINE THOUSAND NINE HUNDRED AND NINETY EIGHT"}
	    });
	  }
	
	@Before
	public void setup(){
		processor = new HundredsAndHigherDigitProcessor();
	}
	
	@Test
	public void return_word_for_given_number(){
		assertThat(processor.convertToWord(number), is(numberInWords));
	}
}
