package org.cleancode.katas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PricingService {

	private PricingRuleEngine pricingRuleEngine;
	private List<Product> availableProducts;

	public PricingService(List<Promotion> availablePromotions, List<Product> availableProducts) {
		pricingRuleEngine = new PricingRuleEngine(availablePromotions);
		this.availableProducts = availableProducts;
	}

	public List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap) {
		return pricingRuleEngine.calculateEligiblePromotionCombinations(productCountMap, new ArrayList<>());
	}

	public int calculateMinimumPrice(Map<String, Integer> productCountMap) {
		return calculateEligiblePromotionCombinations(productCountMap).stream()
				.mapToInt(promotions -> calculatePrice(promotions, new HashMap<>(productCountMap)))
				.min().getAsInt();
	}
	
	private int calculatePrice(List<Promotion> promotions, Map<String, Integer> productCountMap){
		AtomicInteger price=new AtomicInteger(0);
		promotions.stream().forEach(promotion -> {			
			deductCountFromProductCountMap(productCountMap, promotion.getProductsRequiredCount());		
			price.getAndAdd(promotion.getDiscountedPrice());
		});
		price.getAndAdd(getPriceForNonPromotionProducts(productCountMap));
		return price.intValue();
	}

	private int getPriceForNonPromotionProducts(Map<String, Integer> productCountMap) {
		return productCountMap.keySet().stream().mapToInt(productName -> getActualPrice(productName,productCountMap.get(productName))).sum();
	}

	private void deductCountFromProductCountMap(Map<String, Integer> productCountMap,
			Map<String, Integer> productsRequiredCount) {
		productCountMap.keySet().stream().forEach(productName ->{
			productCountMap.put(productName,getAvailableProductCountAfterPromotion(productCountMap, productsRequiredCount, productName));
		});
	}

	private int getAvailableProductCountAfterPromotion(Map<String, Integer> productCountMap,
			Map<String, Integer> productsRequiredCount, String productName) {
		return productCountMap.get(productName)-productsRequiredCount.getOrDefault(productName,0);
	}
	
	private int getActualPrice(String productName, int count){
		return availableProducts.stream()
				.filter(product -> product.getProductName().equalsIgnoreCase(productName))
				.mapToInt(product -> product.calculatePrice(count))
				.sum();
	}
}
