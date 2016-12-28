package org.cleancode.katas;

public class HundredsAndHigherDigitProcessor implements NumberProcessor {
	
	private String AND_WITH_SPACE=" AND ";
	
	private final String HUNDRED="HUNDRED";
	
	private final String THOUSAND="THOUSAND";
	
	private OnesProcessor onesProcessor = new OnesProcessor();
	
	private TensProcessor tensProcessor = new TensProcessor();
	
	@Override
	public String convertToWord(int number) {
		boolean thousandFound=false;
		StringBuilder wordBuilder = new StringBuilder();
		if(number >= 1000){	
			wordBuilder.append(convertFirstDigitToWords(number/1000, THOUSAND));
			thousandFound=true;
		}	
		convertHundredsToWord(number, thousandFound, wordBuilder);
		return wordBuilder.append(tensProcessor.convertToWord(number)).toString();
	}

	private void convertHundredsToWord(int number, boolean thousandFound, StringBuilder wordBuilder) {
		if(thousandFound){
			number=number%1000;
			if(number > 0){
				wordBuilder.append(" ");
			}			
		}
		if(number >= 100){			
			wordBuilder.append(convertFirstDigitToWords(number/100, HUNDRED));
			appendAndWithSpace(number,wordBuilder);
		}
	}
	
	private String convertFirstDigitToWords(int number, String wordToAppend){
		return new StringBuilder().append(onesProcessor.convertToWord(number))
					.append(" ")
					.append(wordToAppend).toString();
		
	}
	
	private void appendAndWithSpace(int number, StringBuilder wordBuilder) {	
		int remainder = number%100;
		if(remainder>0){		
			wordBuilder.append(AND_WITH_SPACE);
		}
	}

}
