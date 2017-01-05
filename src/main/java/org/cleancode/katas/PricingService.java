package org.cleancode.katas;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingService {

	private List<Promotion> availablePromotions;

	public PricingService(List<Promotion> availablePromotions) {
		this.availablePromotions = availablePromotions;
	}

	public List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap) {
		return getEligiblePromotions(productCountMap).stream()//
				.map(promotion ->calculateEligiblePromotionCombinations(promotion, new HashMap<>(productCountMap)))//
				.collect(toList());
	}

	private List<Promotion> calculateEligiblePromotionCombinations(Promotion promotion, Map<String, Integer> productCountMap) {
		adjustProductCount(promotion, productCountMap);
		List<Promotion> promotions = new ArrayList<>();
		getEligiblePromotions(productCountMap).stream()//
				.forEach(eligiblePromotion -> {//
					promotions.addAll(calculateEligiblePromotionCombinations(eligiblePromotion, new HashMap<>(productCountMap)));
				});
		promotions.add(promotion);
		return promotions;
	}

	private void adjustProductCount(Promotion promotion, Map<String, Integer> productCountMap) {
		promotion.getProductDetails().stream().forEach(productDetails -> {
			productCountMap.put(productDetails.getProduct().getProductName(),
					getProductCountAfterApplyingPromotion(productCountMap, productDetails));
		});
	}

	private int getProductCountAfterApplyingPromotion(Map<String, Integer> productCountMap,
			ProductPromotionDetails productDetails) {
		return productCountMap.get(productDetails.getProduct().getProductName()) - productDetails.getCountRequired();
	}

	public List<Promotion> getEligiblePromotions(Map<String, Integer> productCountMap) {
		return availablePromotions.stream().filter(promotion -> promotion.isEligibleForPromotion(productCountMap))
				.collect(toList());
	}

}
