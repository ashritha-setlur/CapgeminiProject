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
import com.capgemini.capstore.services.AdminServices;

@Controller
@RestController
public class AdminActionController {

	@Autowired
	AdminServices adminServices;

	//Method to add Merchant

	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		adminServices.addMerchant(merchant);	
	}


	//Method to get the Single Merchant Details

	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
		return adminServices.displaySingleMerchant(merchantId);

	}


	//Method to display the customer details

	@RequestMapping(value="/displayAllCustomers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return  adminServices.displayAllCustomers();
	}


	//Method to display the Merchant details

	@RequestMapping(value="/displayAllMerchants", method=RequestMethod.GET)
	public List<Merchant> getAllMerchants() {
		return  adminServices.displayAllMerchants();
	}


	//Method to display the Product details

	@RequestMapping(value="/displayAllProducts", method=RequestMethod.GET)
	public List<Product> getAllProducts() {
		return  adminServices.displayAllProducts();
	}

	@RequestMapping(value = "/viewThirdPartyMerchantRequest",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> viewThirdPartyMerchantRequest() {
		return adminServices.viewThirdPartyMerchantRequest();
	}

	@RequestMapping(value = "/viewThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> viewThirdPartyMerchant() {
		return adminServices.viewThirdPartyMerchant();
	}

	@RequestMapping(value = "/addThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> addThirdPartyMerchant(int merchantId) {
		adminServices.addThirdPartyMerchant(merchantId);
		return adminServices.viewThirdPartyMerchantRequest();

	}

	@RequestMapping(value = "/rejectThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> rejectThirdPartyMerchant(int merchantId) {
		adminServices.rejectThirdPartyMerchant(merchantId);
		return adminServices.viewThirdPartyMerchantRequest();
	}

	@RequestMapping(value = "/deleteThirdPartyMerchant",method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Merchant> deleteThirdPartyMerchant(int merchantId) {
		adminServices.deleteThirdPartyMerchant(merchantId);
		return adminServices.viewThirdPartyMerchant();
	}
	@RequestMapping(value="/verify", method=RequestMethod.GET)
	public boolean changeVerification(int merchantId)
	{
		return adminServices.validateMerchant(merchantId);
	}
	
	@RequestMapping(value="/deliveryStatus",method=RequestMethod.GET)
	public void orderStatus(int orderId,int num){
		adminServices.orderStatus(orderId,num);
	}
}