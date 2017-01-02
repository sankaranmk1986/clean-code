package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CheckOutShould {
	
	private CheckOut checkOut;
	
	@Before
	public void setup(){
		checkOut = new CheckOut();
		Map<String, Integer> itemPriceMap = new HashMap<>();
		itemPriceMap.put("A", 50);
		itemPriceMap.put("B", 30);
		checkOut.setItemPriceMap(itemPriceMap);
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
