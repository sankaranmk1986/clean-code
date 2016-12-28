package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class NumberToWords {

	public String convertToWords(int number) {
		StringBuilder wordBuilder = new StringBuilder();
		if(number >= 20){
			wordBuilder.append("TWENTY ");
		}
		return wordBuilder.append(convertOnesToWord(number%20)).toString();
	}
	
	private String convertOnesToWord(int number){
		return of(ONES.values())
				.filter(ones -> ones.getNumber() ==number)
				.findFirst()
				.get()
				.name();
	}

}
