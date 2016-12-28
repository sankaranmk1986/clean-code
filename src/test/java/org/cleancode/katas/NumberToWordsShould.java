package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumberToWordsShould {
	
	private NumberToWords numberToWords;
	
	@Before
	public void setup(){
		numberToWords = new NumberToWords();
	}
	
	@Test
	public void return_one_for_number_1(){
		assertThat(numberToWords.convertToWords(1),is("ONE"));
	}
	
	@Test
	public void return_two_for_number_1(){
		assertThat(numberToWords.convertToWords(2),is("TWO"));
	}

}
