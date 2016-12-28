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
	public void return_two_for_number_2(){
		assertThat(numberToWords.convertToWords(2),is("TWO"));
	}
	
	@Test
	public void return_three_for_number_3(){
		assertThat(numberToWords.convertToWords(3),is("THREE"));
	}
	
	@Test
	public void return_nineteen_for_number_19(){
		assertThat(numberToWords.convertToWords(19),is("NINETEEN"));
	}
	
	@Test
	public void return_twentyone_for_number_21(){
		assertThat(numberToWords.convertToWords(21),is("TWENTY ONE"));
	}
	
	@Test
	public void return_thirty_for_number_30(){
		assertThat(numberToWords.convertToWords(30),is("THIRTY"));
	}

	@Test
	public void return_ninetynine_for_number_99(){
		assertThat(numberToWords.convertToWords(99),is("NINETY NINE"));
	}
}
