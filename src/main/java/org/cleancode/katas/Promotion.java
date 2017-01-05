package org.cleancode.katas;

import java.util.List;
import java.util.Map;

public class Promotion {
	
	private List<ProductPromotionDetails> productDetails;
	private int discountedPrice;
	
	public Promotion(List<ProductPromotionDetails> productDetails, int discountedPrice) {
		this.productDetails = productDetails;
		this.discountedPrice = discountedPrice;
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

}
