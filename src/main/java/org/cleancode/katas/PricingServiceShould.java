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
				new Promotion(asList( new ProductPromotionDetails(productB, 1),	new ProductPromotionDetails(productC, 1)), 45)));
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
	public void return_2_promotions_if_A_2B_C_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 2);
		productCountMap.put("C", 1);
		List<Promotion> promotions = pricingService.getEligiblePromotions(productCountMap);
		assertThat(promotions.size(), is(2));
		assertThat(promotions.get(0).getDiscountedPrice()+promotions.get(1).getDiscountedPrice(), is(115));
	}

}
