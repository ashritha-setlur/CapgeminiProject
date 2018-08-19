package com.capgemini.capstore.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.MerchantServices;

@Controller
@RestController
public class CustomerUIController {

	@RequestMapping(value="/adddiscount")
	public String discountPage(ModelMap model){
		RestTemplate restTemplate = new RestTemplate();
		Product[] addDiscount = restTemplate.getForObject("http://localhost:9899/addDiscount.json",Product[].class);
		List<Product> productList=Arrays.asList(addDiscount);
		model.put("product",productList);
		return "adddiscount";
	}

}
