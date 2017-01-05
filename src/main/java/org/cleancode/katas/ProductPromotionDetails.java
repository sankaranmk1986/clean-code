package org.cleancode.katas;

public class ProductPromotionDetails {
	
	private Product product;
	private int countRequired;
	
	public ProductPromotionDetails(Product product, int countRequired) {
		this.product = product;
		this.countRequired = countRequired;
	}

	public Product getProduct() {
		return product;
	}
	
	public int getCountRequired() {
		return countRequired;
	}
	
}
