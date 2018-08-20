package com.capgemini.capstore.services;

import java.util.List;
import java.util.Map;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;

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
	public OrderDetails returnProduct(int id);
}
