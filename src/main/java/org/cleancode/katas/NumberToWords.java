package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class NumberToWords {

	public String convertToWords(int number) {
		StringBuilder wordBuilder = new StringBuilder();
		if(number == 30){
			wordBuilder.append("THIRTY");
		}else {
			if(number >= 20){
				wordBuilder.append("TWENTY ");
			}
			wordBuilder.append(convertOnesToWord(number%20));
		}
		return wordBuilder.toString();
	}
	
	private String convertOnesToWord(int number){
		return of(ONES.values())
				.filter(ones -> ones.getNumber() ==number)
				.findFirst()
				.get()
				.name();
	}

}
