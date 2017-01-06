package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value=Enclosed.class)
public class CheckOutShould {	
	
	@RunWith(value=Parameterized.class)
	public static class OneTimeCheckOutShould{
	
		private CheckOut checkOut;
		
		private String items;
		private int price;
		
		public OneTimeCheckOutShould(String items, int price){
			this.items=items;
			this.price=price;
		}
		
		 @Parameters(name = "return_{1}_for_items_{0}()")
		  public static Collection<Object[]> data() {
		    return asList(new Object[][] {
		        {"A", 50},
		        {"B", 30},
		        {"AB", 70},
		        {"ABA", 120},
		        {"AAA", 130},
		        {"AAAA", 180},
		        {"BB", 45},
		        {"CDBA",105},
		        {"BABAA",175},
		        {"AAAAAA",260},
		        {"DABABA",190},
		        {"ABBCAB",185},
		        {"BCBA",115}
		      });
		  }
		
		@Before
		public void setup(){
			Product productA= new Product("A", 50);
			Product productB = new Product("B", 30);
			Product productC = new Product("C", 20);
			Product productD = new Product("D", 15);
			List<Product> availableProducts = asList(productA, productB, productC, productD);
			List<Promotion> availablePromotions = asList(new Promotion(asList( new ProductPromotionDetails(productA, 1),
					new ProductPromotionDetails(productB, 1)), 70),
					new Promotion(asList( new ProductPromotionDetails(productB, 1),	new ProductPromotionDetails(productC, 1)), 45),
					new Promotion(asList( new ProductPromotionDetails(productA, 3)),130),
					new Promotion(asList( new ProductPromotionDetails(productB, 2)), 45));
			checkOut = new CheckOut(availableProducts,availablePromotions);
		}
		
		@Test
		public void return_price_for_items_added(){
			assertThat(checkOut.price(items), is(price));		
		}
	}
	
	@RunWith(value=Parameterized.class)
	public static class IncrementalCheckOutShould{
	
		private CheckOut checkOut;
		
		private List<String> products;
		private int price;
		
		public IncrementalCheckOutShould(List<String> products, int price){
			this.products=products;
			this.price=price;
		}
		
		 @Parameters(name = "return_{1}_for_items_{0}()")
		  public static Collection<Object[]> data() {
		    return asList(new Object[][] {
		        {asList("A"), 50},
		        {asList("A","A"), 100},
		        {asList("A","A", "A"), 130},
		        {asList("A","A", "A", "A"), 180},
		        {asList("A","B", "C", "D"), 105},
		        {asList("B","B"), 45},
		        {asList("A","A","A","B","B"), 175},
		        {asList("A","A","A","A","A","A"), 260},
		        {asList("D","A","B","A","B","A"), 190},
		        {asList("D","A","B","B","C","A"), 175},
		        {asList("A","A","A","B","B","B","B"), 220}
		      });
		  }
		
		@Before
		public void setup(){
			Product productA= new Product("A", 50);
			Product productB = new Product("B", 30);
			Product productC = new Product("C", 20);
			Product productD = new Product("D", 15);
			List<Product> availableProducts = asList(productA, productB, productC, productD);
			List<Promotion> availablePromotions = asList(new Promotion(asList( new ProductPromotionDetails(productA, 1),
					new ProductPromotionDetails(productB, 1)), 70),
					new Promotion(asList( new ProductPromotionDetails(productB, 1),	new ProductPromotionDetails(productC, 1)), 45),
					new Promotion(asList( new ProductPromotionDetails(productA, 3)),130),
					new Promotion(asList( new ProductPromotionDetails(productB, 2)), 45));
			checkOut = new CheckOut(availableProducts,availablePromotions);
		}
		
		@Test
		public void return_total_for_product_added(){
			products.stream().forEach(product->{checkOut.addToCart(product);});
			assertThat(checkOut.total(), is(price));
		}
		
	}
	
}
