package org.cleancode.katas;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	      });
	  }
	
	@Before
	public void setup(){
		checkOut = new CheckOut();
		Map<String, Integer> itemPriceMap = new HashMap<>();
		itemPriceMap.put("A", 50);
		itemPriceMap.put("B", 30);
		checkOut.setItemPriceMap(itemPriceMap);
	}
	
	@Test
	public void return_price_for_items_added(){
		assertThat(checkOut.price(items), is(price));		
	}

}
