package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class TensProcessor implements NumberProcessor {
	
	private String AND_WITH_SPACE=" AND ";
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	public String convertToWord(int number){
		StringBuilder wordBuilder = new StringBuilder();
		appendRequiredString(number%1000, wordBuilder);
		wordBuilder.append(convertTensToWord(number%100));
		return wordBuilder.append(onesProcessor.convertToWord(number)).toString();
	}

	private void appendRequiredString(int number, StringBuilder wordBuilder) {	
		int remainder = number%100;
		if(number > 100 && remainder>0){		
			wordBuilder.append(AND_WITH_SPACE);
		}
	}
	
	private String convertTensToWord(int number){
		if(number >=20){
			int tenthDigit = number/10;
			return of(TENS.values())
					.filter(tens -> tens.getExponent() ==tenthDigit)
					.findFirst()
					.get()
					.name();
		}
		return "";
	}


}
