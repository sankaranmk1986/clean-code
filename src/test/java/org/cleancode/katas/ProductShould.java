package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value=Parameterized.class)
public class ProductShould {
	
	private String productName;
	private int price, numberOfProductPurchased, totalPrice;	
	
	 public ProductShould(String productName, int price, int numberOfProductPurchased, int totalPrice) {
		this.productName = productName;
		this.price = price;
		this.numberOfProductPurchased = numberOfProductPurchased;
		this.totalPrice = totalPrice;
	}
	  
	  @Parameters(name = "return_{3}_for_products_{0}_times{2}()")
	  public static Collection<Object[]> dataWithDiscount() {
		Map<Integer, Integer> discountDetails = new HashMap<>();
		discountDetails.put(3, 130);
		Map<Integer, Integer> discountDetailsForB = new HashMap<>();
		discountDetailsForB.put(2, 45);
	    return asList(new Object[][] {
	        {"A", 50, 1, 50},
	        {"A", 50, 2,100},	       
	        {"A", 50, 3, 150},
	        {"A", 50, 4, 200},
	        {"A", 50, 6, 300},
	        {"A", 50, 7, 350},
	        {"B", 30, 1, 30},
	        {"B", 30, 2, 60},
	        {"B", 30, 3, 90}
	      });
	  }

	@Test
	public void return_correct_price_for_products(){
		Product product = new Product(productName, price);
		assertThat(product.calculatePrice(numberOfProductPurchased), is(totalPrice));
	}
	
	

}
