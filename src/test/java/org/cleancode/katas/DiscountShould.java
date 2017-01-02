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
public class DiscountShould {
	
	private int count, price, discountedPrice,purchasedProdcutCount;
	
	public DiscountShould(int count, int price,int purchasedProdcutCount, int discountedPrice) {
		this.count=count;
		this.price=price;
		this.purchasedProdcutCount=purchasedProdcutCount;
		this.discountedPrice=discountedPrice;
	}
	
	 @Parameters(name = "return_{3}_for_items_{2}()")
	  public static Collection<Object[]> data() {
	    return asList(new Object[][] {
	        {3, 130,3, 130},
	        {3, 130, 4,130},	
	        {3, 130, 6,260},
	        {2, 45, 1,0},
	        {2, 45, 2,45},
	        {2, 45, 4,90}
	      });
	  }
	
	@Test
	public void return_130_as_discounted_price_for_AAA(){
		Discount discount = new Discount(count, price);
		assertThat(discount.calculateDiscountedPrice(purchasedProdcutCount), is(discountedPrice));
	}

}
