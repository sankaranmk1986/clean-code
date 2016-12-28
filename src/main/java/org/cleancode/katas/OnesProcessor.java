package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class OnesProcessor {

	public String convertToWord(int number) {
		boolean tensFound=false;
		if (number >= 20) {
			number = number % 10;		
			tensFound=true;
		}
		return convertOnesToWord(number,tensFound);
	}

	private String convertOnesToWord(int number, boolean tensFound) {
		StringBuilder wordBuilder = new StringBuilder();
		if (number > 0) {
			if(tensFound){
				wordBuilder.append(" ");
			}
			wordBuilder.append(of(ONES.values())
								.filter(ones -> ones.getNumber() == number)
								.findFirst()
								.get()
								.name());
		}	
		return wordBuilder.toString();
	}

}
