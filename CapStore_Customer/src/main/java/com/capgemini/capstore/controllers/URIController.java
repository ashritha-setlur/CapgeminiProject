package com.capgemini.capstore.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.capstore.beans.Category;


@Controller
public class URIController {

	@RequestMapping(method=RequestMethod.POST,value="/")
	public ModelAndView getHomePage() {
		RestTemplate restTemplate = new RestTemplate();
		Category[] displayCategories = restTemplate.getForObject("http://localhost:4496/sample.json",Category[].class);
		List<Category> categoryList = Arrays.asList(displayCategories);
		return new ModelAndView("index","categories",categoryList);
	}
	
	@RequestMapping(value="/registerCustomer")
	public void registerCustomer(HttpServletRequest request) {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String gender = request.getParameter("gender");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String pincode = request.getParameter("pincode");
				
		
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
