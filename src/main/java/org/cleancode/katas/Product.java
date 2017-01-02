package org.cleancode.katas;

import java.util.List;

public class Product {
	
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public Product(String productName, int price, List<Discount> discount) {
		this(productName,price);
		this.discount = discount;
	}

	private String productName;
	private int price;
	private List<Discount> discount;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Discount> getDiscount() {
		return discount;
	}
	public void setDiscount(List<Discount> discount) {
		this.discount = discount;
	}
	
	public int calculatePrice(int count){
		return price*count;
	}
	
	
}
