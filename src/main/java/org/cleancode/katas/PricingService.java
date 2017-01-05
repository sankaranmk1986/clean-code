package org.cleancode.katas;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PricingService {

	private List<Promotion> availablePromotions;

	public PricingService(List<Promotion> availablePromotions) {
		this.availablePromotions = availablePromotions;
	}
	
	public List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap){
		List<List<Promotion>> eligiblePromotionCombinations=new ArrayList<>();
		getEligiblePromotions(productCountMap).stream()
				.forEach(promotion ->{
					List<Promotion> promotions = new ArrayList<>();
					promotions.add(promotion);
					eligiblePromotionCombinations.add(promotions);
				});
		return eligiblePromotionCombinations;
	}

	public List<Promotion> getEligiblePromotions(Map<String, Integer> productCountMap) {
		return availablePromotions.stream()
							.filter(promotion -> promotion.isEligibleForPromotion(productCountMap))
							.collect(toList());
	}

}
