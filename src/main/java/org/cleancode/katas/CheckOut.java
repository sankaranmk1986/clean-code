package org.cleancode.katas;

public class CheckOut {

	public int price(String products) {
		if(products.equalsIgnoreCase("A")){
			return 50;
		}
		return 0;
	}

}
