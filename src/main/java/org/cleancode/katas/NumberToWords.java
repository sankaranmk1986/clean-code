package org.cleancode.katas;

public class NumberToWords {
	
	private NumberProcessorContext processorContext = new NumberProcessorContext();
	
	public String convertToWords(int number) {	
		return processorContext.convertToWord(number);
	}
}
