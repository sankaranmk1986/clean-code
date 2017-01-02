package org.cleancode.katas;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ProductShould {
	
	@Test
	public void return_50_for_productA(){
		Product product = new Product("A", 50);
		assertThat(product.calculatePrice(1), is(50));
	}

}
