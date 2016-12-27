package org.cleancode.katas;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class WordCounterShould {
	
	@Test
	public void able_to_create_wordcounter_object(){
		WordCounter wordCounter = new WordCounter();
		assertNotNull(wordCounter);
	}

}
