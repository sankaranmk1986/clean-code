package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DiscountShould {	
	
	@Test
	public void return_130_as_discounted_price_for_AAA(){
		Discount discount = new Discount(3, 130);
		assertThat(discount.calculateDiscountedPrice(3), is(130));
	}

}
