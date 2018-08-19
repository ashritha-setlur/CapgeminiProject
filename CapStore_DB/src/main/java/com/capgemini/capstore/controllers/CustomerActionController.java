package com.capgemini.capstore.controllers;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.MerchantServices;

@RestController
public class CustomerActionController {

	@Autowired
	private MerchantServices mservices;
    
    // Register Customer
    @RequestMapping(method=RequestMethod.POST,value={"/customerRegister"},produces=MediaType.APPLICATION_JSON_VALUE)
    public String registerAction(@RequestBody String json) throws JSONException {
	Customer customerObj=new Customer();
	Authentication auth=new Authentication();
	JSONObject jSon=new JSONObject(json);
	customerObj.setFirstName(jSon.getString("firstName"));
	customerObj.setLastName(jSon.getString("lastName"));
	customerObj.setGender(jSon.getString("gender"));
	customerObj.setEmail(jSon.getString("customerEmail"));
	customerObj.setMobileNo(jSon.getString("mobileNo"));
	long pinCode=jSon.getInt("pincode");
    
	customerObj.setAddress(new Address(jSon.getString("addressline1"),jSon.getString("addressline2"),jSon.getString("city"),jSon.getString("state"),pinCode,jSon.getString("country")));

	mservices.registerCustomer(customerObj,auth);
	return "success";
}
    //Search for Products(by product name,product brand and category name)
    @RequestMapping(method=RequestMethod.POST, value={"/searchAction"},produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Product> search(@RequestBody String jSon) throws JSONException  
	{
		
	   JSONObject json=new JSONObject(jSon);
	ArrayList<Product> productObj=new ArrayList<Product>(); 
	 
	
			productObj=mservices.searchByProductBrand(json.getString("key"));
		
			return productObj;
	}
    
	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		mservices.addMerchant(merchant);
	
	}
	
	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
	return mservices.displaySingleMerchant(merchantId);
	
	}
}
