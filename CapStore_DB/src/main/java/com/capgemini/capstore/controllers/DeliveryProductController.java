package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.services.DeliveryProductsService;

@RestController
public class DeliveryProductController {

	@Autowired
	DeliveryProductsService deliveryProductService;
	
	@RequestMapping(value="/deliveryproducts",method=RequestMethod.GET)
	public OrderDetails quantityupdate1(int OrderId)
	{
		return deliveryProductService.deliveringProducts(OrderId);
	}
}
