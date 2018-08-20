package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.CapStoreAdminServices;
@Controller
@RestController
public class AdminActionController {
	@Autowired
	private CapStoreAdminServices capStoreAdminServices;
	

	
	@RequestMapping(value = "/viewThirdPartyMerchantRequest",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> viewThirdPartyMerchantRequest() {
		return capStoreAdminServices.viewThirdPartyMerchantRequest();
	}

	@RequestMapping(value = "/viewThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> viewThirdPartyMerchant() {
		return capStoreAdminServices.viewThirdPartyMerchant();
	}

	@RequestMapping(value = "/addThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> addThirdPartyMerchant(int merchantId) {
		capStoreAdminServices.addThirdPartyMerchant(merchantId);
		return capStoreAdminServices.viewThirdPartyMerchantRequest();

	}

	@RequestMapping(value = "/rejectThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Merchant> rejectThirdPartyMerchant(int merchantId) {
		capStoreAdminServices.rejectThirdPartyMerchant(merchantId);
		return capStoreAdminServices.viewThirdPartyMerchantRequest();
	}
	
	@RequestMapping(value = "/deleteThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> deleteThirdPartyMerchant(int merchantId) {
		capStoreAdminServices.deleteThirdPartyMerchant(merchantId);
		return capStoreAdminServices.viewThirdPartyMerchant();
	}
	
	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		capStoreAdminServices.addMerchant(merchant);
	
	}
	
	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
	return capStoreAdminServices.displaySingleMerchant(merchantId);
	
	}
	
	@RequestMapping(value="/displayAllMerchants", method=RequestMethod.GET)
	public List<Merchant> displayAllMerchants() {
		return capStoreAdminServices.displayAllMerchants();
	}
	
	@RequestMapping(value="/displayAllCustomers", method=RequestMethod.GET)
	public List<Customer> displayAllCustomers() {
		return capStoreAdminServices.displayAllCustomers();
	}
	
	@RequestMapping(value="/displayAllProducts", method=RequestMethod.GET)
	public List<Product> displayAllProducts() {
		return capStoreAdminServices.displayAllProducts();
	}
}
