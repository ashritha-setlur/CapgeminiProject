package com.capgemini.capstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getHomePage() {
		return "index";
	}
	
	@RequestMapping(value="/getLogin")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/registerAsMerchant")
	public String getMerchantRegistrationPage() {
		return "registerMerchant";
	}
	
	@RequestMapping(value="/registerAsCustomer")
	public String getCustomerRegistrationPage() {
		return "registerCustomer";
	}
	
	@RequestMapping(value="/getProduct")
	public String getProductPage() {
		return "product";
	}

	@RequestMapping(value="/getCheckout")
	public String getCheckoutPage() {
		return "checkout";
	}
	
	@RequestMapping(value="/getContact")
	public String getContactPage() {
		return "contact";
	}
	
	@RequestMapping(value="/getCategory")
	public String getCategoryPage() {
		return "category";
	}
	
	@RequestMapping(value="/getCustomerProfile")
	public String getCustomerProfilePage() {
		return "customerProfile";
	}
	
}
