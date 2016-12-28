package org.cleancode.katas;

public class HundredProcessor implements NumberProcessor {
	
	private final String HUNDRED="HUNDRED";
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	private TensProcessor tensProcessor = new TensProcessor();
	
	@Override
	public String convertToWord(int number) {
		StringBuilder wordBuilder = new StringBuilder();
		if(number >= 100){
			wordBuilder.append(convertHundredsToWords(number/100));
		}		
		return wordBuilder.append(tensProcessor.convertToWord(number)).toString();
	}
	
	private String convertHundredsToWords(int number){
		return new StringBuilder().append(onesProcessor.convertToWord(number))
					.append(" ")
					.append(HUNDRED).toString();
		
	}

}
