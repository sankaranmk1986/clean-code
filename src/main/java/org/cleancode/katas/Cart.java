package org.cleancode.katas;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
	
	private Map<String, Product> productNameMap;
	private PricingService pricingService;

	public Cart(List<Product> availableProducts, List<Promotion> availablePromotions) {
		productNameMap = availableProducts.stream().collect(Collectors.toMap(Product::getProductName, product->product));
		pricingService = new PricingService(availablePromotions, availableProducts);
	} 
	
	private List<Product> productsInCart = new ArrayList<Product>();
	
	public void add(String product){
		productsInCart.add(productNameMap.get(product));
	}
	
	public int totalPrice(){
		return calculatePrice();
	}
	
	private int calculatePrice() {
		return pricingService.calculateMinimumPrice(countProducts());
	}
	
	private Map<String, Integer> countProducts() {
		return productsInCart.stream().collect(toMap(Product::getProductName, product -> 1, Integer::sum));
	}

}
