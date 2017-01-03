package org.cleancode.katas;

import java.util.List;

public class Product {

	private String productName;
	private int price;
	private List<Discount> discount;
	
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public Product(String productName, int price, List<Discount> discount) {
		this(productName,price);
		this.discount = discount;
	}
	
	public String getProductName() {
		return productName;
	}
		
	public int calculatePrice(int count){
		return isDiscountAvailable(count)?calculateDiscountedPrice(count):calculateActualPrice(count);
	}
	
	private boolean isDiscountAvailable(int count){
		return discount == null ? false:
				discount.stream()
				.filter(discount -> discount.isEligibleForDiscount(count))
				.findFirst()
				.isPresent();
	}
	
	private int calculateDiscountedPrice(int count){
		return calculateDiscountedPrice(count,availableDiscount(count));		
	}
	
	private Discount availableDiscount(int count) {
		return discount.stream()
				.filter(discount -> discount.isEligibleForDiscount(count))
				.findFirst()
				.get();
	}	
	
	private int calculateDiscountedPrice(int count, Discount availableDiscount){
		return availableDiscount.calculateDiscountedPrice(count)
				+calculateActualPrice(discountNotEligibleProductCount(count, availableDiscount));
	}
		
	private int calculateActualPrice(Integer count){
		return count*price;
	}
	
	private int discountNotEligibleProductCount(int count, Discount availableDiscount) {
		return count-availableDiscount.discountEligibleProductCount(count);
	}
	
}
