package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WordCounterShould {
	
	private WordCounter wordCounter;
	
	@Before
	public void setup() {
		wordCounter = new WordCounter();
	}
	
	@Test
	public void able_to_create_wordcounter_object(){
		assertNotNull(wordCounter);
	}	
	
	@Test
	public void return_emptymap_for_empty_string(){
		Map<String, Integer> wordCountMap = wordCounter.countWords("");
		assertThat(wordCountMap.size(), is(0));
	}

}
