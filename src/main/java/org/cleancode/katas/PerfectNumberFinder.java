package org.cleancode.katas;

import static java.util.stream.IntStream.rangeClosed;

public class PerfectNumberFinder {

	public boolean isPerfectNumber(int number) {
		return rangeClosed(1, number/2).filter(divisor -> number%divisor==0).sum() == number?true:false;		
	}

}
