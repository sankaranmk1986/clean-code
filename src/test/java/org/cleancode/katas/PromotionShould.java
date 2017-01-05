package org.cleancode.katas;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PromotionShould {
	private Product productA = new Product("A", 50);
	private Product productB = new Product("B", 30);
	
	@Test
	public void return_true_if_product_A_and_B_purchased(){
		Promotion promotion = new Promotion(asList( new ProductPromotionDetails(productA, 1), new ProductPromotionDetails(productB, 1)), 70);
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 1);
		Assert.assertTrue(promotion.isEligibleForPromotion(productCountMap));		
	}

}
