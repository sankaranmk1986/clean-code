package org.cleancode.katas;

import static java.lang.Math.log10;

import java.util.HashMap;
import java.util.Map;

public class NumberProcessorContext {
	
	private Map<Integer, NumberProcessor> numberProcessorMap = new HashMap<Integer, NumberProcessor>();
	
	public NumberProcessorContext(){
		numberProcessorMap.put(1, new OnesProcessor());
		numberProcessorMap.put(2, new TensProcessor());
		numberProcessorMap.put(3, new HundredsAndHigherDigitProcessor());
	}
	
	public String convertToWord(int number){
		return getNumberProcessor(number).convertToWord(number);
	}
	
	private NumberProcessor getNumberProcessor(int number){
		int length = (int)(log10(number)+1);
		if(length > 3){
			length=3;
		}
		return numberProcessorMap.get(length);
	}

}
