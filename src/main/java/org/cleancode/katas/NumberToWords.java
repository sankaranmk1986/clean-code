package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class NumberToWords {

	public String convertToWords(int number) {
		return of(ONES.values())
				.filter(ones -> ones.getNumber() ==number)
				.findFirst()
				.get()
				.name();
	}

}
