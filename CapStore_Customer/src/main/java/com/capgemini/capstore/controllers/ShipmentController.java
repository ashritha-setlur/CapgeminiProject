package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.services.ShipmentService;

//Controller
@RestController
public class ShipmentController {
	
	//Service object
	@Autowired
	ShipmentService service;
	//Retrieving the customer object from service layer based on the customer id passed
	@RequestMapping(value="/getShipmentDetails")
	public Customer getDetails(int customerId) {		
		return service.retrieveShipmentDetails(customerId);		 
	}
	
}
