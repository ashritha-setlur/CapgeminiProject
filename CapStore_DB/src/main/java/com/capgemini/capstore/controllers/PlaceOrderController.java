package com.capgemini.capstore.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.PlacingOrderServices;

@RestController
public class PlaceOrderController {

@Autowired
PlacingOrderServices orderservice;

@RequestMapping(value="/Order",method=RequestMethod.GET)
public boolean placeOrder(int custId, int cartId, int prodId)
{
	 return orderservice.placeOrder(custId,cartId,prodId);
	
}
}
