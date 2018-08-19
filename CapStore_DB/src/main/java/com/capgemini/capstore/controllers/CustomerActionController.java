package com.capgemini.capstore.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.services.CustomerServices;

@RestController
public class CustomerActionController {

	@Autowired
	private CustomerServices cservices;
	
	//getting delivery status
	@RequestMapping(value="/getDeliveryStatus", method=RequestMethod.GET)
	public String getDeliveryStatus(int orderId) {
		return cservices.getDeliveryStatus(orderId);
	}

	//customer can update his profile
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public void updateCustomer(@RequestBody Customer customer)
	{
		cservices.updateCustomer(customer);
	}

	/*@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public void updateCustomer(Customer customer,Principal principal)
	{
		mservices.updateCustomer(customer);
	}*/

	//customer can display his wishlist
	@RequestMapping(value="/display" , method=RequestMethod.GET)
	public Wishlist display (int custid) {
		return cservices.display(custid);
	}

    // customer can display customer ordered items
	@RequestMapping(value="/displayCustomerOrderedItems", method=RequestMethod.GET)

	public List<OrderDetails> displayCustomerOrderedItems(int id){
		return cservices.displayCustomerOrderedItems(id);
	}
}
