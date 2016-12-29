package org.cleancode.katas;

import static java.util.stream.Stream.of;

public class TensProcessor implements NumberProcessor {

	private OnesProcessor onesProcessor = new OnesProcessor();

	@Override
	public String convertToWord(int number) {
		StringBuilder wordBuilder = new StringBuilder();
		convertTensToWord(number % 100, wordBuilder);
		return wordBuilder.append(onesProcessor.convertToWord(number)).toString();
	}

	private void convertTensToWord(int number,StringBuilder wordBuilder) {
		if (number >= 20) {
			int tenthDigit = number / 10;
			wordBuilder.append(tenthDigitToWord(tenthDigit));
			if (number % 10 > 0) {
				wordBuilder.append(" ");
			}
		}
	}

	private String tenthDigitToWord(int tenthDigit) {
		return of(TENS.values())//
				.filter(tens -> tens.getExponent() == tenthDigit)//
				.findFirst()//
				.get()//
				.name();
	}

}
