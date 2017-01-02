package org.cleancode.katas;

public class CheckOut {

	public int price(String products) {
		if(products.equalsIgnoreCase("A")){
			return 50;
		}else if(products.equalsIgnoreCase("B")){
			return 30;
		}
		return 0;
	}

}
