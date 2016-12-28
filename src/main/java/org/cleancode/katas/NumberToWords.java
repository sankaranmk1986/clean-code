package org.cleancode.katas;

public class NumberToWords {
	
	private NumberProcessor numberProcessor = new HundredsAndHigherDigitProcessor();
	
	public String convertToWords(int number) {	
		return numberProcessor.convertToWord(number);
	}
}
