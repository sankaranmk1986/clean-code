package org.cleancode.katas;

public class NumberToWords {

	public String convertToWords(int number) {
		if(number==2){
			return "TWO";
		}else if(number==3){
			return "THREE";
		}
		return "ONE";
	}

}
