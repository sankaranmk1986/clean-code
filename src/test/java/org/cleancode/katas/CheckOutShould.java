package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value=Parameterized.class)
public class CheckOutShould {
	
	private CheckOut checkOut;
	
	private String items;
	private int price;
	
	public CheckOutShould(String items, int price){
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
	        {"BB", 45}
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
		checkOut = new CheckOut(products);
	}
	
	@Test
	public void return_price_for_items_added(){
		assertThat(checkOut.price(items), is(price));		
	}

}
