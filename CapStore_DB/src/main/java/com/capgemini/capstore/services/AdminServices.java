package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.capstore.beans.Customer;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;

public interface AdminServices {

	public int addMerchant(Merchant merchant);

	public Merchant displaySingleMerchant(int merchantId);

	public List<Customer> displayAllCustomers();
	
	public List<Merchant> displayAllMerchants();
	
	public List<Product> displayAllProducts();
}
