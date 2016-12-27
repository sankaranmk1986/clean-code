package org.cleancode.katas;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class WordCounter {
	
	private final String DEFAULT_DELIMETER = " ";

	public Map<String, Integer> countWords(String word) {
		return countWords(word, DEFAULT_DELIMETER);
	}

	public Map<String, Integer> countWords(String word, String delimeter) {	
		if(word.isEmpty()){
			return new HashMap<String, Integer>();
		}
		return Stream.of(word).map(w->w.split("\\"+delimeter)).flatMap(Arrays::stream).collect(groupingBy(w->w, summingInt(w->1)));
	}
	
}
