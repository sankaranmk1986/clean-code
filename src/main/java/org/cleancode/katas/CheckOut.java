package org.cleancode.katas;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

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
		Map<String, Integer> productCountMap = countProducts(products);
		return productCountMap.keySet()
				.stream()
				.mapToInt(product -> calculatePrice(productCountMap, product)).sum();
	}

	private int calculatePrice(Map<String, Integer> productCountMap, String product) {
		return isDiscountApplicable(productCountMap, product)? 
				calculateDiscountedPrice(productCountMap, product):calculateActualPrice(productCountMap.get(product),product);
	}

	private int calculateDiscountedPrice(Map<String, Integer> productCountMap, String product) {
		return 130+calculateActualPrice(productCountMap.get(product)-3,product);
	}
		
	private int calculateActualPrice(Integer count, String product){
		return itemPriceMap.get(product)*count;
	}

	private boolean isDiscountApplicable(Map<String, Integer> productCountMap, String product) {
		return productCountMap.get(product) >= 3;
	}

	private Map<String, Integer> countProducts(String products) {
		return asList(products.split("")).stream().collect(toMap(product -> product, product -> 1, Integer::sum));
	}

	public void setItemPriceMap(Map<String, Integer> itemPriceMap) {
		this.itemPriceMap = itemPriceMap;
	}
}
