package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.ProductRepo;
@Component
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private MerchantRepo mrepo;
	
	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private AuthenticationRepo arepo;
	
	@Autowired
	private ProductRepo prepo;
	
//	@Autowired
//	private CategoryRepo carepo;
	
	//Register Customer
	@Override
	public Customer registerCustomer(Customer customer,Authentication passwrd) {
		
		Customer customer1;
		crepo.save(customer);
		customer1=crepo.getCustomerId(customer.getMobileNo());
	    //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password=passwrd.getPassword();
        Authentication auth=new Authentication(customer1.getId(),customer1.getMobileNo(),password,"USER_CUSTOMER",2);
        arepo.save(auth);
	  return customer;
	}
	
	//Searching product by Brand
	@Override
	public ArrayList<Product> searchByProductBrand(String product) {
		ArrayList<Product> product1=new ArrayList<Product>();
	
		product1=prepo.findProductBrand(product);
		if(product1==null)
		{
			product1=searchByProductName(product);
		}
		return product1;
	}

	//Searching product by Name
	@Override
	public ArrayList<Product> searchByProductName(String product)  {
		ArrayList<Product> product1=new ArrayList<Product>();
		 product1=prepo.findProductName(product);
		return product1;
	}
	

	@Override
	public int addMerchant(Merchant merchant) {
		 mrepo.save(merchant);
		return  merchant.getMerchantId();
	}

	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = mrepo.getOne(merchantId);
		return merchant;
	}

	@Override
	public List<Merchant> displayAllMerchants() {
		return mrepo.findAll();
	}

	@Override
	public void deleteMerchant(int merchantId) {
		mrepo.deleteById(merchantId);
	}

}
