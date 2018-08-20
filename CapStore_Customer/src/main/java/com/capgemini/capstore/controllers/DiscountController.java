package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.services.DiscountService;

@RestController
public class DiscountController {
	@Autowired
	DiscountService discountservice;
	@RequestMapping(value="/applydiscount", method=RequestMethod.GET)
	public Cart applydiscount(int cartId)
	{
		return discountservice.discount(cartId);
	}
}
