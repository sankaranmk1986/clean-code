package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PricingServiceShould {
	
	private PricingService pricingService;
	
	@Before
	public void setup(){
		Product productA = new Product("A", 50);
		Product productB = new Product("B", 30);
		Product productC = new Product("C", 20);
		pricingService = new PricingService(asList(new Promotion(asList( new ProductPromotionDetails(productA, 1),
				new ProductPromotionDetails(productB, 1)), 70),
				new Promotion(asList( new ProductPromotionDetails(productB, 1),	new ProductPromotionDetails(productC, 1)), 45),
				new Promotion(asList( new ProductPromotionDetails(productA, 3)),130),
				new Promotion(asList( new ProductPromotionDetails(productB, 2)), 45)));
	}
	
	@Test
	public void return_promotion_if_A_B_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 1);
		List<Promotion> promotions = pricingService.getEligiblePromotions(productCountMap);
		assertThat(promotions.size(), is(1));
		assertThat(promotions.get(0).getDiscountedPrice(), is(70));
	}
	
	@Test
	public void return_3_promotions_if_A_2B_C_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 2);
		productCountMap.put("C", 1);
		List<Promotion> promotions = pricingService.getEligiblePromotions(productCountMap);
		assertThat(promotions.size(), is(3));
		assertThat(promotions.get(0).getDiscountedPrice()
				+promotions.get(1).getDiscountedPrice()+promotions.get(2).getDiscountedPrice(), is(160));
	}
	
	@Test
	public void return_4_promotions_if_3A_2B_C_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 3);
		productCountMap.put("B", 2);
		productCountMap.put("C", 1);
		List<Promotion> promotions = pricingService.getEligiblePromotions(productCountMap);
		assertThat(promotions.size(), is(4));
	}
	
	@Test
	public void return_0_promotions_if_A_C_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("C", 1);
		List<Promotion> promotions = pricingService.getEligiblePromotions(productCountMap);
		assertThat(promotions.size(), is(0));
	}
	
	@Test
	public void return_AB_as_eligible_combination_if_A_B_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 1);
		List<List<Promotion>> promotions = pricingService.calculateEligiblePromotionCombinations(productCountMap);
		assertThat(promotions.size(), is(1));
		assertThat(promotions.get(0).size(), is(1));
		assertThat(promotions.get(0).get(0).getDiscountedPrice(), is(70));
	}
	
	@Test
	public void return_AB_AB_or_BB_as_eligible_combination_if_2A_2B_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 2);
		productCountMap.put("B", 2);
		List<List<Promotion>> promotions = pricingService.calculateEligiblePromotionCombinations(productCountMap);
		assertThat(promotions.size(), is(2));
		assertThat(promotions.get(0).size() + promotions.get(1).size(), is(3));
	}

}
