package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
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
		        {"AB", 80},
		        {"ABA", 130},
		        {"AAA", 130},
		        {"AAAA", 180},
		        {"BB", 45},
		        {"CDBA",115},
		        {"BABAA",175},
		        {"AAAAAA",260},
		        {"DABABA",190}
		      });
		  }
		
		@Before
		public void setup(){
			List<Discount> discounts = new ArrayList<>();
			discounts.add(new Discount(3, 130));
			List<Product> products = new ArrayList<Product>();
			products.add(new Product("A", 50, discounts));
			discounts = new ArrayList<>();
			discounts.add(new Discount(2, 45));
			products.add(new Product("B", 30, discounts));
			products.add(new Product("C", 20));
			products.add(new Product("D", 15));
			checkOut = new CheckOut(products);
		}
		
		@Test
		public void return_price_for_items_added(){
			assertThat(checkOut.price(items), is(price));		
		}
	}
	
	public static class IncrementalCheckOutShould{
	
		private CheckOut checkOut;
		
		@Before
		public void setup(){
			List<Discount> discounts = new ArrayList<>();
			discounts.add(new Discount(3, 130));
			List<Product> products = new ArrayList<Product>();
			products.add(new Product("A", 50, discounts));
			discounts = new ArrayList<>();
			discounts.add(new Discount(2, 45));
			products.add(new Product("B", 30, discounts));
			products.add(new Product("C", 20));
			products.add(new Product("D", 15));
			checkOut = new CheckOut(products);
		}
		
		@Test
		public void return_total_50_for_product_A(){
			checkOut.addToCart("A");
			assertThat(checkOut.total(), is(50));
		}
		
		@Test
		public void return_total_100_for_product_A_added_twice(){
			checkOut.addToCart("A");
			checkOut.addToCart("A");
			assertThat(checkOut.total(), is(100));
		}
	}

}
