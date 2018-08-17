package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.ProductRepo;

@Component(value="serviceRepo")
public class AdminServicesImpl implements AdminServices {


	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private MerchantRepo merchantRepo ;
	@Autowired
	private ProductRepo productRepo;
	
	
	//Method to add Merchant Details

	@Override
	public int addMerchant(Merchant merchant) {
		merchantRepo.save(merchant);
		return  merchant.getMerchantId();
	}
	
	
	//Method to get Single Merchant Details

	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = merchantRepo.getOne(merchantId);
		return merchant;
	}
	
	
	//Method to display the customer details
	@Override
	public  List<Customer> displayAllCustomers() {

		return customerRepo.findAll();	
	}

	
	//Method to display the Merchant details
	@Override
	public List<Merchant> displayAllMerchants() {

		return merchantRepo.findAll();
	}

	
	//Method to display the product details
	@Override
	public List<Product> displayAllProducts() {

		return productRepo.findAll();
	}

}
