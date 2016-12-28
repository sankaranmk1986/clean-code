package org.cleancode.katas;

public enum ONES {
	ONE(1),TWO(2),THREE(3);
	
	private int number;
	
	ONES(int number){
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

}
