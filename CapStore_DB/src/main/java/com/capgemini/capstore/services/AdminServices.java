package com.capgemini.capstore.services;

import java.util.List;
import java.util.Map;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Promo;

public interface AdminServices {

	public int addMerchant(Merchant merchant);
	public Merchant displaySingleMerchant(int merchantId);
	public List<Customer> displayAllCustomers();
	public List<Merchant> displayAllMerchants();
	public List<Product> displayAllProducts();
	public void setMinOrderAmount(double amount) ;
	public List<Merchant> viewThirdPartyMerchantRequest();
	public void addThirdPartyMerchant(int merchantId);
	public void rejectThirdPartyMerchant(int merchantId);
	public List<Merchant> viewThirdPartyMerchant();
	public void deleteThirdPartyMerchant(int merchantId);
	public double setAvgRatingOfMerchant(int mId);
	public double setAvgRatingOfProduct(int pId);
	public Map<Integer,Double> AvgOfProducts_List(int mId);
	public int addDiscount(Discount discount);
	public List<Discount> displayAllDiscounts();
	public void deleteDiscount(int discountId);
	public int addPromo(Promo promo);
	public List<Promo> displayAllPromos();
	public void deletePromo(int promoId);
	public boolean validateMerchant(int merchantId);
	public void orderStatus(int orderId, int num);
}
