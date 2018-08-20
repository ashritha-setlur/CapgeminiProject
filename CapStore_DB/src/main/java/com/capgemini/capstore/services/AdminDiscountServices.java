package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Discount;

public interface AdminDiscountServices {
	
	public int addDiscount(Discount discount);
	
	public List<Discount> displayAllDiscounts();
	
	public void deleteDiscount(int discountId);

	
}

