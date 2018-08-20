package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Discount;

public interface MerchantDiscountServices {
	
	public int addDiscount(Discount discount);
	
	public List<Discount> displayAllDiscounts();
	
	public void deleteDiscount(int discountId);

}
