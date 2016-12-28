package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class TensProcessor implements NumberProcessor {
	
	private String AND_WITH_SPACE=" AND ";
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	public String convertToWord(int number){
		StringBuilder wordBuilder = new StringBuilder();		
		if(number >= 100){
			number = number%100;	
			appendRequiredString(number, wordBuilder);
		}
		wordBuilder.append(convertTensToWord(number));
		return wordBuilder.append(onesProcessor.convertToWord(number)).toString();
	}

	private void appendRequiredString(int number, StringBuilder wordBuilder) {
		if(number>0){
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
