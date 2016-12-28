package org.cleancode.katas;

public class NumberToWords {
	
	private NumberProcessor numberProcessor = new HundredProcessor();
	
	public String convertToWords(int number) {	
		if(number == 1000){
			return "ONE THOUSAND";
		}
		return numberProcessor.convertToWord(number);
	}
}
