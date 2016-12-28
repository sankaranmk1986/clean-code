package org.cleancode.katas;

public class NumberToWords {
	
	private TensProcessor numberProcessor = new TensProcessor();
	
	public String convertToWords(int number) {
		if(number == 100){
			return "ONE HUNDRED";
		}
		return numberProcessor.convertToWord(number);
	}
}
