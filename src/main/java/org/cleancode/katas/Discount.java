package org.cleancode.katas;

public class Discount {
	
	private int countRequired;
	private int discountedPrice;
	
	public Discount(int countRequired, int discountedPrice) {
		this.countRequired = countRequired;
		this.discountedPrice = discountedPrice;
	}	
	
	public boolean isEligibleForDiscount(int count){
		return count >= countRequired;		
	}
	
	public int calculateDiscountedPrice(int count){
		return discountedPrice*getCountOfDiscountedUnits(count);
	}

	public int getCountOfDiscountedUnits(int count) {
		return (int)(count/countRequired);
	}
	
	public int discountEligibleProductCount(int count) {
		return getCountOfDiscountedUnits(count)*countRequired;
	}
}
