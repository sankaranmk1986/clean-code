package org.cleancode.katas;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	public Map<String, Integer> countWords(String word) {	
		if(word.isEmpty()){
			return new HashMap<String, Integer>();
		}
		Map<String, Integer> wordcountMap = new HashMap<>();
		wordcountMap.put(word, 1);
		return wordcountMap;
	}

}
