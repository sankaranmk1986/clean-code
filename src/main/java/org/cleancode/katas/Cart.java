package org.cleancode.katas;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
	
	private Map<String, Product> productNameMap;

	public Cart(List<Product> availableProducts) {
		productNameMap = availableProducts.stream().collect(Collectors.toMap(Product::getProductName, product->product));
	} 
	
	private List<Product> productsInCart = new ArrayList<Product>();
	
	public void add(String product){
		productsInCart.add(productNameMap.get(product));
	}
	
	public int totalPrice(){
		return calculatePrice();
	}
	
	private int calculatePrice() {
		Map<String, Integer> productCountMap = countProducts();
		return productCountMap.keySet()
				.stream()
				.mapToInt(product -> productNameMap.get(product).calculatePrice(productCountMap.get(product))).sum();
	}
	
	private Map<String, Integer> countProducts() {
		return productsInCart.stream().collect(toMap(Product::getProductName, product -> 1, Integer::sum));
	}

}
