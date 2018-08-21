package com.capgemini.capstore.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;


@Controller
public class URIController {

	@RequestMapping(method=RequestMethod.GET,value="/")
	public ModelAndView getHomePage() {
		RestTemplate restTemplate = new RestTemplate();
		Category[] displayCategories = restTemplate.getForObject("http://localhost:4496/index.json",Category[].class);
		List<Category> categoryList = Arrays.asList(displayCategories);
		return new ModelAndView("index","categories",categoryList);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registerCustomer")
	public void registerCustomer(@RequestBody String json) {
		
		System.out.println(json);
		
		try {
			JSONObject jSon = new JSONObject(json);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject("http://localhost:4496/customerRegister", jSon, JSONObject.class);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String mobileNo = request.getParameter("mobileNo");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password1");
//		String dateOfBirth = request.getParameter("dateOfBirth");
//		String gender = request.getParameter("gender");
//		String addressLine1 = request.getParameter("addressLine1");
//		String addressLine2 = request.getParameter("addressLine2");
//		String city = request.getParameter("city");
//		String state = request.getParameter("state");
//		String country = request.getParameter("country");
//		String pincode = request.getParameter("pincode");
		
		
		
				
		
	}
//	
	@RequestMapping(value="/getLogin")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/signin")
	public void signingIn() {
	
	}
	
	@RequestMapping(value="/registerAsMerchant")
	public String getMerchantRegistrationPage() {
		return "registerMerchant";
	}
	
	@RequestMapping(value="/registerAsCustomer")
	public String getCustomerRegistrationPage() {
		return "registerCustomer";
	}
	
	@RequestMapping(value="/getProduct/{productId}")
	public ModelAndView getProductPage(@PathVariable int productId ) {
		RestTemplate restTemplate = new RestTemplate();
		Product displayProduct = restTemplate.getForObject("http://localhost:4496/product.json",Product.class);
		return new ModelAndView("product","product",displayProduct);
	}

	@RequestMapping(value="/getProduct/addToCart/{productId}")
	public ModelAndView getCheckoutPage(@PathVariable int productId) {
		RestTemplate restTemplate = new RestTemplate();
		OrderDetails displayOrder = restTemplate.getForObject("http://localhost:4496/order.json",OrderDetails.class);
		return new ModelAndView("checkout","order",displayOrder);
	}
	
	@RequestMapping(value="/getContact")
	public String getContactPage() {
		return "contact";
	}
	
	@RequestMapping(value="/getCategory/{categoryId}")
	public String getCategoryPage(@PathVariable int categoryId) {
		return "category";
	}
	
	@RequestMapping(value="/getCustomerProfile")
	public String getCustomerProfilePage() {
		return "customerProfile";
	}
	
	@RequestMapping(value="/getProduct/addToCart/placeOrder")
	public String getSuccessPage() {
		return "success";
	}
	
	
}
