package org.cleancode.katas;

public class NumberToWords {
	
	private TensProcessor numberProcessor = new TensProcessor();
	
	public String convertToWords(int number) {
		return numberProcessor.convertToWord(number);
	}
}
