package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;

public interface MerchantServices {

	public int addMerchant(Merchant merchant);

	public Merchant displaySingleMerchant(int merchantId);

	public List<Merchant> displayAllMerchants();

	public void deleteMerchant(int merchantId);
	public Customer registerCustomer(Customer customer, Authentication passwrd);

	public ArrayList<Product> searchByProductBrand(String product);

	public ArrayList<Product> searchByProductName(String product);

}
