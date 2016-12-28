package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class TensProcessor {
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	public String convertToWord(int number){
		StringBuilder wordBuilder = new StringBuilder();
		if(number >= 20){
			wordBuilder.append(convertTensToWord(number/10));
		}		
		return wordBuilder.append(onesProcessor.convertToWord(number)).toString();
	}
	
	private String convertTensToWord(int number){
		return of(TENS.values())
				.filter(tens -> tens.getExponent() ==number)
				.findFirst()
				.get()
				.name();
	}


}
