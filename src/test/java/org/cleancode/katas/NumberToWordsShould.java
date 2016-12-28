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
public class NumberToWordsShould {
	
	private NumberToWords numberToWords;
	
	private int number;
	private String numberInWords;
	
	public NumberToWordsShould(int number, String numberInWords){
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
	        {20, "TWENTY"},
	        {21, "TWENTY ONE"},
	        {30, "THIRTY"},
	        {99, "NINETY NINE"},
	        {100, "ONE HUNDRED"},
	        {101, "ONE HUNDRED AND ONE"},
	        {341, "THREE HUNDRED AND FOURTY ONE"},
	        {999, "NINE HUNDRED AND NINETY NINE"},
	        {1000, "ONE THOUSAND"},
	        {1001, "ONE THOUSAND ONE"},
	        {2657, "TWO THOUSAND SIX HUNDRED AND FIFTY SEVEN"},
	        {8990, "EIGHT THOUSAND NINE HUNDRED AND NINETY"},
	        {9999, "NINE THOUSAND NINE HUNDRED AND NINETY NINE"}
	    });
	  }
	
	@Before
	public void setup(){
		numberToWords = new NumberToWords();
	}
	
	@Test
	public void return_word_for_given_number(){
		assertThat(numberToWords.convertToWords(number), is(numberInWords));
	}
}
