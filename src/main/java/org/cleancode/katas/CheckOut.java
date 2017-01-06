package org.cleancode.katas;

import static java.util.Arrays.asList;

import java.util.List;

public class CheckOut {
	
	private Cart cart;

	public CheckOut(List<Product> availableProducts, List<Promotion> availablePromotions) {
		cart = new Cart(availableProducts,availablePromotions);
	}

	public int price(String products) {
		if(products == null || products.isEmpty()){
			return 0;
		}
		return calculatePrice(products);
	}
	
	public void addToCart(String product){
		cart.add(product);
	}
	
	public int total(){
		return cart.totalPrice();
	}

	private int calculatePrice(String products) {
		addMultipleItemsToCart(products);
		return cart.totalPrice();
	}

	private void addMultipleItemsToCart(String products) {
		asList(products.split("")).stream().forEach(product ->{addToCart(product);});
	}

}
