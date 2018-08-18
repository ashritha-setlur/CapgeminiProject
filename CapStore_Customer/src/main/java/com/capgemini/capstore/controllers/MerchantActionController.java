package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.services.MerchantServices;

@Controller
public class MerchantActionController {

@Autowired
	private MerchantServices mservices;

	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		mservices.addMerchant(merchant);
	
	}
	
	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
	return mservices.displaySingleMerchant(merchantId);
	
	}

}
