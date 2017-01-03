package org.cleancode.katas;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckOut {
	
	private Map<String, Product> productNameMap;

	public CheckOut(List<Product> availableProducts) {
		productNameMap = availableProducts.stream().collect(Collectors.toMap(Product::getProductName, product->product));
	}

	public int price(String products) {
		if(products == null || products.isEmpty()){
			return 0;
		}
		return calculatePrice(products);
	}
	
	public void addToCart(String products){
		
	}
	
	public int total(){
		return 50;
	}

	private int calculatePrice(String products) {
		Map<String, Integer> productCountMap = countProducts(products);
		return productCountMap.keySet()
				.stream()
				.mapToInt(product -> productNameMap.get(product).calculatePrice(productCountMap.get(product))).sum();
	}

	private Map<String, Integer> countProducts(String products) {
		return asList(products.split("")).stream().collect(toMap(product -> product, product -> 1, Integer::sum));
	}

}
