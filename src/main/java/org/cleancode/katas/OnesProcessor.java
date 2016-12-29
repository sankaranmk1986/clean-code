package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class OnesProcessor implements NumberProcessor {

	@Override
	public String convertToWord(int number) {
		if (number >= 20) {
			number = number % 10;
		}
		return convertOnesToWord(number);
	}

	private String convertOnesToWord(int number) {
		if (number > 0) {
			return onesToWord(number);
		}
		return "";
	}

	private String onesToWord(int number) {
		return of(ONES.values())//
				.filter(ones -> ones.getNumber() == number)//
				.findFirst()//
				.get()//
				.name();
	}

}
