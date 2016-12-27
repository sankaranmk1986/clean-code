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

	private void assertMapSize(Map<String, Integer> wordCountMap, int expectedSize) {
		assertThat(wordCountMap.size(), is(expectedSize));
	}
	
	private void assertWordCount(Map<String, Integer> wordcountMap, String word, int expectedCount) {
		assertThat(wordcountMap.get(word), is(expectedCount));
	}
	
	
	@Test
	public void able_to_create_wordcounter_object(){
		assertNotNull(wordCounter);
	}	
	
	@Test
	public void return_emptymap_for_empty_string(){
		assertMapSize( wordCounter.countWords(""), 0);
	}
	
	@Test
	public void return_count_1_for_word_without_space(){
		Map<String, Integer> wordcountMap = wordCounter.countWords("word");
		assertMapSize(wordcountMap, 1);
		assertWordCount(wordcountMap, "word", 1);
	}

	
	@Test
	public void return_count_1_for_2_different_words_with_space(){
		Map<String, Integer> wordcountMap = wordCounter.countWords("word count");
		assertMapSize(wordcountMap, 2);
		assertWordCount(wordcountMap, "word", 1);
		assertWordCount(wordcountMap, "count", 1);
	}
	
	@Test
	public void return_count_1_for_3_different_words_with_space(){
		Map<String, Integer> wordcountMap = wordCounter.countWords("word count exercise");
		assertMapSize(wordcountMap, 3);
		assertWordCount(wordcountMap, "word", 1);
		assertWordCount(wordcountMap, "count", 1);
		assertWordCount(wordcountMap, "exercise", 1);
	}
	
	@Test
	public void return_count_2_for_repeated_word(){
		Map<String, Integer> wordcountMap = wordCounter.countWords("word word");
		assertMapSize(wordcountMap, 1);
		assertWordCount(wordcountMap, "word", 2);
	}

}
