package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckOutShould {
	
	private CheckOut checkOut;
	
	@Before
	public void setup(){
		checkOut = new CheckOut();
	}
	
	@Test
	public void return_0_if_no_product_added(){
		assertThat(checkOut.price(""), is(0));		
	}
	
	@Test
	public void return_50_if_A_product_added(){
		assertThat(checkOut.price("A"), is(50));		
	}
	
	@Test
	public void return_30_if_B_product_added(){
		assertThat(checkOut.price("B"), is(30));		
	}
	

}
