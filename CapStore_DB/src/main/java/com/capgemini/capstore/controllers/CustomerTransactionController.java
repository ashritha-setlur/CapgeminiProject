package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.capstore.services.CustomerServices;

@Controller
@RestController
public class CustomerTransactionController {

	@Autowired
	private CustomerServices customerServices;

	@RequestMapping(value="/gettrans", method=RequestMethod.GET)
	public int gettransaction( int method) {
		return  customerServices.saveTransaction(method);
	}

	@RequestMapping(value="/gettrans/{method}", method=RequestMethod.GET)
	public int generatetransaction(@Param(value="method") int method) {
		return  customerServices.saveTransaction(method);
	}

}
