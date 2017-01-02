package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

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
	  public static Collection<Object[]> data() {
	    return asList(new Object[][] {
	        {"A", 50,1, 50},
	        {"A", 50, 2,100}		       
	      });
	  }

	@Test
	public void return_correct_price_for_products(){
		Product product = new Product(productName, price);
		assertThat(product.calculatePrice(numberOfProductPurchased), is(totalPrice));
	}
	
	

}
