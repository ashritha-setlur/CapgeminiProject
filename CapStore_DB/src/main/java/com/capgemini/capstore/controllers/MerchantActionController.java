package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.GenerateInvoice;
import com.capgemini.capstore.services.MerchantServices;

@RestController
public class MerchantActionController {

@Autowired
	private MerchantServices mservices;
@Autowired
private GenerateInvoice invoice;

	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		mservices.addMerchant(merchant);
	
	}
	
	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
	return mservices.displaySingleMerchant(merchantId);
	
	}
		
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

}
