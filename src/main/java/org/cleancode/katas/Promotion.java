package org.cleancode.katas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Promotion {
	
	private List<ProductPromotionDetails> productDetails;	

	private int discountedPrice;
	
	public Promotion(List<ProductPromotionDetails> productDetails, int discountedPrice) {
		this.productDetails = productDetails;
		this.discountedPrice = discountedPrice;
	}
	
	public List<ProductPromotionDetails> getProductDetails() {
		return productDetails;
	}
		
	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public boolean isEligibleForPromotion(Map<String, Integer> productCountMap){
		return productDetails.stream()
				.allMatch(productDetails ->isEligibleForPromotion(productCountMap, productDetails));
	}

	private boolean isEligibleForPromotion(Map<String, Integer> productCountMap,
			ProductPromotionDetails productDetails) {
		return productDetails.getCountRequired() <= productCountMap.getOrDefault(productDetails.getProduct().getProductName(),0);
	}
	
	public Map<String, Integer> getProductsRequiredCount(){
		Map<String, Integer> productsRequiredCountMap=new HashMap<>();
		productDetails.stream().forEach(products -> {
			putToMap(productsRequiredCountMap, products);
		});
		return productsRequiredCountMap;
	}

	private void putToMap(Map<String, Integer> productsRequiredCountMap, ProductPromotionDetails products) {
		productsRequiredCountMap.put(products.getProduct().getProductName(),addProductCount(productsRequiredCountMap, products));
	}
	private int addProductCount(Map<String, Integer> productsRequiredCountMap, ProductPromotionDetails products) {
		return productsRequiredCountMap.getOrDefault(products.getProduct().getProductName(),0)+products.getCountRequired();
	}

}
