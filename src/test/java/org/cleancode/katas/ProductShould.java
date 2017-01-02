package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(value=Parameterized.class)
public class ProductShould {
	
	private String productName;
	private int price, numberOfProductPurchased, totalPrice;	
	private Map<Integer, Integer> discountDetails;
	
	 public ProductShould(String productName, int price, int numberOfProductPurchased, int totalPrice,Map<Integer, Integer> discountDetails) {
		this.productName = productName;
		this.price = price;
		this.numberOfProductPurchased = numberOfProductPurchased;
		this.totalPrice = totalPrice;
		this.discountDetails=discountDetails;
	}
	  
	  @Parameters(name = "return_{3}_for_products_{0}_times{2}()")
	  public static Collection<Object[]> dataWithDiscount() {
		Map<Integer, Integer> discountDetails = new HashMap<>();
		discountDetails.put(3, 130);
	    return asList(new Object[][] {
	        {"A", 50, 1, 50,discountDetails},
	        {"A", 50, 2,100,discountDetails},	       
	        {"A", 50, 3, 130,discountDetails}
	      });
	  }

	@Test
	public void return_correct_price_for_products(){
		List<Discount> availableDiscounts=new ArrayList<Discount>();
		if(discountDetails != null){
			discountDetails.keySet()
				.stream()
				.forEach(minimumProductCountRequired -> 
					{
						availableDiscounts.add(new Discount(minimumProductCountRequired, discountDetails.get(minimumProductCountRequired)));
					});
		}
		Product product = new Product(productName, price,availableDiscounts);
		assertThat(product.calculatePrice(numberOfProductPurchased), is(totalPrice));
	}
	
	

}
