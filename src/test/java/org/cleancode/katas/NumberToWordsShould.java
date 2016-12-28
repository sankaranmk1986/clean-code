package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumberToWordsShould {
	
	@Test
	public void return_one_for_number_1(){
		assertThat(new NumberToWords().convertToWords(1),is("ONE"));
	}

}
