package org.cleancode.katas;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PricingService {

	private List<Promotion> availablePromotions;

	public PricingService(List<Promotion> availablePromotions) {
		this.availablePromotions = availablePromotions;
	}

	public List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap) {
		return calculateEligiblePromotionCombinations(productCountMap, new ArrayList<>());
	}

	private List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap,
			List<Promotion> appliedPromotions) {
		List<List<Promotion>> promotionCombinations = new ArrayList<>();
		addAppliedPromotionsFirstTime(appliedPromotions, promotionCombinations);
		determineEligiblePromotionCombination(productCountMap, appliedPromotions, promotionCombinations);
		return promotionCombinations;
	}

	private void determineEligiblePromotionCombination(Map<String, Integer> productCountMap,
			List<Promotion> appliedPromotions, List<List<Promotion>> promotionCombinations) {
		List<Promotion> originalAppliedPromotions = new ArrayList<>(appliedPromotions);
		AtomicInteger eligiblePromotionsCount = new AtomicInteger(0);
		getEligiblePromotions(productCountMap).stream()//
				.forEach(eligiblePromotion -> {//
					Map<String, Integer> originalProductCountMap = new HashMap<>(productCountMap);
					adjustProductCount(eligiblePromotion, originalProductCountMap);
					List<Promotion> promotions = appliedPromotions;
					if (eligiblePromotionsCount.getAndIncrement() > 0) {
						promotions = new ArrayList<>(originalAppliedPromotions);
						promotionCombinations.add(promotions);
					}
					promotions.add(eligiblePromotion);
					promotionCombinations
							.addAll(calculateEligiblePromotionCombinations(originalProductCountMap, promotions));

				});
	}

	private void addAppliedPromotionsFirstTime(List<Promotion> appliedPromotions,
			List<List<Promotion>> promotionCombinations) {
		if (appliedPromotions.isEmpty()) {
			promotionCombinations.add(appliedPromotions);
		}
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
