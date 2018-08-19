package com.capgemini.capstore.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.capstore.beans.Category;


@Controller
public class URIController {

	@RequestMapping(value="/")
	public ModelAndView getHomePage() {
		RestTemplate restTemplate = new RestTemplate();
		Category[] displayCategories = restTemplate.getForObject("http://localhost:4496/sample.json",Category[].class);
		List<Category> categoryList = Arrays.asList(displayCategories);
		return new ModelAndView("index","categories",categoryList);
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
