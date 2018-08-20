package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.CustomerServices;

@Controller
@RestController
public class CustomerCartController {

	@Autowired
	private CustomerServices customerServices;

	//add product into the cart
	//  (http://localhost:4496/addToCart?prodId=1&custId=1)
	@RequestMapping(value="/addToCart",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addToCart(int prodId,int custId) {
		customerServices.addProductToCart(prodId,custId);
	}

	//remove product from the cart
	//  (http://localhost:4496/removeFromCart?prodId=1&custId=1)
	@RequestMapping(value="/removeFromCart",produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeFromCart(@RequestParam("prodId")int prodId,@RequestParam("custId")int custId) {
		customerServices.removeProductFromCart(prodId, custId) ;
	}
	//view all the products from the cart
	//  (http://localhost:4496/ViewCart?cartId=1)
	@RequestMapping(value="/ViewCart",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> viewCart(@RequestParam("cartId")int cartId) {
		return customerServices .viewCart(cartId) ;
	}

}
