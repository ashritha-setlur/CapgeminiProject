package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	@RequestMapping(value="/getInvoice", method=RequestMethod.GET)
	public int getInvoice(int customerId,int productId, int orderAmount,int transactionId) {
		return invoice.generateInvoice(customerId, productId, orderAmount,transactionId);	
	}

}
