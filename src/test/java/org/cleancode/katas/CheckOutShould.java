package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CheckOutShould {
	
	@Test
	public void return_0_if_no_product_added(){
		CheckOut checkOut = new CheckOut();
		assertThat(checkOut.price(""), is(0));		
	}

}
