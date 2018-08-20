package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Promo;

public interface MerchantServices {

	public Merchant registerMerchant(Merchant merchant, String password, String type);
	public int addDiscount(Discount discount);
	public List<Discount> displayAllDiscounts();
	public void deleteDiscount(int discountId);
	public int addPromo(Promo promo);	
	public List<Promo> displayAllPromos();
	public void deletePromo(int promoId);
	public OrderDetails deliveringProducts(int orderId);
}
