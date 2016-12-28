package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class TensProcessor implements NumberProcessor {
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	public String convertToWord(int number){
		StringBuilder wordBuilder = new StringBuilder();
		wordBuilder.append(convertTensToWord(number%100));
		return wordBuilder.append(onesProcessor.convertToWord(number)).toString();
	}	
	
	private String convertTensToWord(int number){
		StringBuilder wordBuilder = new StringBuilder();
		if(number >=20){
			int tenthDigit = number/10;
			wordBuilder.append(of(TENS.values())
					.filter(tens -> tens.getExponent() ==tenthDigit)
					.findFirst()
					.get()
					.name());
			if(number%10 > 0){
				wordBuilder.append(" ");
			}			
		}
		return wordBuilder.toString();
	}


}
