package org.cleancode.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

	public Map<String, Integer> countWords(String word) {	
		if(word.isEmpty()){
			return new HashMap<String, Integer>();
		}
		return Stream.of(word).map(w->w.split(" ")).flatMap(Arrays::stream).collect(Collectors.toMap(w->w, w->1));
	}

}
