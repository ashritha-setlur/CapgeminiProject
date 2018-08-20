package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.services.MerchantDiscountServices;

@RestController
public class MerchantDiscountActionController {
@Autowired
private MerchantDiscountServices mdservices;
//merchant adds discounts
@RequestMapping(value="/addMerchantDiscount",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public void addMerchantDiscount(@RequestBody Discount discount) {
	mdservices.addDiscount(discount);
}

@RequestMapping(value="/getAllMerchantDiscounts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public List<Discount>getAllMerchantDiscounts(){
	return mdservices.displayAllDiscounts();
	}

@RequestMapping(value="/deleteMerchantDiscount",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteMerchantDiscount (@RequestBody Discount discount) {
	
	mdservices.deleteDiscount(discount.getDiscountId());
}
}

