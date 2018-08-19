package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.GenerateInvoice;

@RestController
public class MerchantActionController {


		@Autowired
		private GenerateInvoice invoice;


		
	//controller to test through postman
	@RequestMapping(value="/getInvoice", method=RequestMethod.GET)
	public int getInvoice(int customerId,int productId, int orderAmount,int transactionId) {
		return invoice.generateInvoice(customerId, productId, orderAmount,transactionId);	
	}
	
	//controller to call
	@RequestMapping(value="/getInvoice/{customerId,productId,orderAmount,transactionId}", method=RequestMethod.GET)
	public int generateInvoice(@Param("customerId") int customerId, @Param("productId")int productId, @Param("orderAmount") int orderAmount,@Param("transactionId")int transactionId) {
		return invoice.generateInvoice(customerId, productId, orderAmount,transactionId);	
	}
	
	@RequestMapping(value="/gettrans", method=RequestMethod.GET)
	public int gettransaction(int method) {
		return  invoice.savetransaction(method);
	}

}
