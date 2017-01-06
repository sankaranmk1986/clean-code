package org.cleancode.katas;

import static java.util.Arrays.asList;
import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;
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
		assertThat(getPromotionsAsString(promotions), is("AB_AB_or_B"));
	}
	
	@Test
	public void return_all_possible_combination_if_3A_2B_C_purchased(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 3);
		productCountMap.put("B", 2);
		productCountMap.put("C", 1);
		List<List<Promotion>> promotions = pricingService.calculateEligiblePromotionCombinations(productCountMap);
		assertThat(promotions.size(), is(7));
	}
	
	@Test
    public void product_A_product_B_costs_70(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 1);
		productCountMap.put("B", 1);
		assertThat(pricingService.calculatePrice(productCountMap),is(70));
	}
	
	@Test
    public void product_2A_product_2B_costs_140(){
		Map<String, Integer> productCountMap = new HashMap<>();
		productCountMap.put("A", 2);
		productCountMap.put("B", 2);
		assertThat(pricingService.calculatePrice(productCountMap),is(140));
	}
	
	private String getPromotionsAsString(List<List<Promotion>> combinationOfPromotions){
		StringBuilder productNameCombinationBuilder = new StringBuilder();
		combinationOfPromotions.stream().forEach(appliedPromotions -> {
			productNameCombinationBuilder.append(getProductNames(appliedPromotions)).append("or_");
		});
		return productNameCombinationBuilder.substring(0, productNameCombinationBuilder.length()-4);
	}

	private String getProductNames(List<Promotion> appliedPromotions) {
		StringBuilder productCombinationBuilder = new StringBuilder();
		List<String> productCombinations = appliedPromotions.stream().map(promotion -> getProductNames(promotion)).collect(toList());
		sort(productCombinations);
		productCombinations.stream().forEach(product -> {productCombinationBuilder.append(product).append("_");});
		return productCombinationBuilder.toString();
	}

	private String getProductNames(Promotion promotion) {
		StringBuilder productNameCombinationBuilder = new StringBuilder();
		List<String> promotionDetails = promotion.getProductDetails().stream().map(
				productDetails -> productDetails.getProduct().getProductName()).collect(toList());
		sort(promotionDetails);
		promotionDetails.stream().forEach(productName -> {productNameCombinationBuilder.append(productName);});
		return productNameCombinationBuilder.toString();
	}
}
