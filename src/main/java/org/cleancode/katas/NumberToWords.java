package org.cleancode.katas;

public class NumberToWords {
	
	private TensProcessor numberProcessor = new TensProcessor();
	
	public String convertToWords(int number) {
		StringBuilder wordBuilder = new StringBuilder();
		if(number >= 100){
			wordBuilder.append("ONE HUNDRED");
			number=number%100;
			if(number > 0){
				wordBuilder.append(" AND ");
			}
		}
		return wordBuilder.append(numberProcessor.convertToWord(number)).toString();
	}
}
