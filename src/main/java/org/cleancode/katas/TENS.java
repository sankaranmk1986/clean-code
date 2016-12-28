package org.cleancode.katas;

public enum TENS {	
	TWENTY(2),
	THIRTY(3),
	FOURTY(4),
	FIFTY(5),
	SIXTY(6),
	SEVENTY(7),
	EIGHTY(8),
	NINETY(9);
	
	private int exponent;
	
	TENS(int exponent){
		this.exponent=exponent;
	}

	public int getExponent() {
		return exponent;
	}

}
