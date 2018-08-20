package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.ProductRepo;
@Service
public class CapStoreAdminServicesImplementation implements CapStoreAdminServices {
	@Autowired
    public MerchantRepo merchantRepo;
	@Autowired
    public AuthenticationRepo aRepo;
	@Autowired
	public ProductRepo productRepo;
	@Autowired
	public CustomerRepo customerRepo;

	@Override
	public void addThirdPartyMerchant(int merchantId)  {
	aRepo.saveThirdPartyMerchant(merchantId);
	}
     
	@Override
	public void rejectThirdPartyMerchant(int merchantId) {
	aRepo.rejectThirdPartyMerchant(merchantId);
	}
	

	@Override
	public void deleteThirdPartyMerchant(int merchantId) {
		merchantRepo.deleteById(merchantId);
		aRepo.deleteById(merchantId);
	}

	@Override
	public List<Merchant> viewThirdPartyMerchantRequest() {
	    return merchantRepo.getRequestedThirdPartyMerchant();
	}

	@Override
	public List<Merchant> viewThirdPartyMerchant() {
		return merchantRepo.getThirdPartyMerchant();

	}
	
	@Override
	public int addMerchant(Merchant merchant) {
		merchantRepo.save(merchant);
		return  merchant.getMerchantId();
	}

	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = merchantRepo.getOne(merchantId);
		return merchant;
	}
	
	@Override
	public  List<Customer> displayAllCustomers() {
		List<Customer> cust = customerRepo.getAllCustomers();
		return cust;
	}

	@Override
	public List<Merchant> displayAllMerchants() {
		List<Merchant> merchant = merchantRepo.getAllMerchants();
		return merchant;
	}

	@Override
	public List<Product> displayAllProducts() {
		List<Product> product = productRepo.getAllProducts();
		return product;
	}
}
