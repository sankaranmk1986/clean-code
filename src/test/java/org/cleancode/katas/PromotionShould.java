package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

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
		assertTrue(promotion.isEligibleForPromotion(productCountMap));		
	}
	
	@Test
	public void return_false_if_product_A_and_B_purchased(){
		Promotion promotion = new Promotion(asList( new ProductPromotionDetails(productA, 2), new ProductPromotionDetails(productB, 1)), 110);
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 1);
		assertFalse(promotion.isEligibleForPromotion(productCountMap));		
	}
	
	@Test
	public void return_true_if_product_4_A_and_2_B_purchased(){
		Promotion promotion = new Promotion(asList( new ProductPromotionDetails(productA, 2), new ProductPromotionDetails(productB, 1)), 110);
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 4);
		productCountMap.put("B", 2);
		assertTrue(promotion.isEligibleForPromotion(productCountMap));		
	}

}
