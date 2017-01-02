package org.cleancode.katas;

import static java.lang.String.valueOf;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
	
	private Map<String, Integer> itemPriceMap = new HashMap<>();

	public int price(String products) {
		if(products == null || products.isEmpty()){
			return 0;
		}
		return calculatePrice(products);
	}

	private int calculatePrice(String products) {
		return products.chars().map(product -> itemPriceMap.get(valueOf((char)product))).sum();
	}

	public void setItemPriceMap(Map<String, Integer> itemPriceMap) {
		this.itemPriceMap = itemPriceMap;
	}
}
