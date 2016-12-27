package org.cleancode.katas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterShould {
	
	@Test
	public void able_to_create_wordcounter_object(){
		WordCounter wordCounter = new WordCounter();
		assertNotNull(wordCounter);
	}
	
	@Test
	public void return_emptymap_for_empty_string(){
		WordCounter wordCounter = new WordCounter();
		Map<String, Integer> wordCountMap = wordCounter.countWords("");
		assertThat(wordCountMap.size(), is(0));
	}

}
