package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class OnesProcessor implements NumberProcessor {

	public String convertToWord(int number) {
		boolean tensFound=false;
		if (number >= 20) {
			number = number % 10;		
		}
		return convertOnesToWord(number,tensFound);
	}

	private String convertOnesToWord(int number, boolean tensFound) {
		StringBuilder wordBuilder = new StringBuilder();
		if (number > 0) {
			wordBuilder.append(of(ONES.values())
								.filter(ones -> ones.getNumber() == number)
								.findFirst()
								.get()
								.name());
		}	
		return wordBuilder.toString();
	}

}
