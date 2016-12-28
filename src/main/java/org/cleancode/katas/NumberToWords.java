package org.cleancode.katas;

public class NumberToWords {
	
	private NumberProcessor numberProcessor = new HundredProcessor();
	
	public String convertToWords(int number) {	
		return numberProcessor.convertToWord(number);
	}
}
