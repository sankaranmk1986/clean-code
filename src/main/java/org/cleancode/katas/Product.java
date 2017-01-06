package org.cleancode.katas;

public class Product {

	private String productName;
	private int price;
	
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
		
	public int calculatePrice(int count){
		return count*price;
	}
		
}
