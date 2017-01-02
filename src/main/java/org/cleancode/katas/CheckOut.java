package org.cleancode.katas;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
	
	private Map<String, Integer> itemPriceMap = new HashMap<>();

	public int price(String products) {
		if(products == null || products.isEmpty()){
			return 0;
		}
		return itemPriceMap.get(products);
	}

	public void setItemPriceMap(Map<String, Integer> itemPriceMap) {
		this.itemPriceMap = itemPriceMap;
	}
}
