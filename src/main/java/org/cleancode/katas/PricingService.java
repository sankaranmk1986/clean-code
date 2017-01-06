package org.cleancode.katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PricingService {

	private PricingRuleEngine pricingRuleEngine;

	public PricingService(List<Promotion> availablePromotions) {
		pricingRuleEngine = new PricingRuleEngine(availablePromotions);
	}

	public List<List<Promotion>> calculateEligiblePromotionCombinations(Map<String, Integer> productCountMap) {
		return pricingRuleEngine.calculateEligiblePromotionCombinations(productCountMap, new ArrayList<>());
	}
}
