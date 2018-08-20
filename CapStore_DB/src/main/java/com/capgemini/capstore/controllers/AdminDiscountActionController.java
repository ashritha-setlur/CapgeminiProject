package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.services.AdminDiscountServices;

@RestController
public class AdminDiscountActionController {
@Autowired
private AdminDiscountServices adservices;
//admin adds discounts
@RequestMapping(value="/addAdminDiscount",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public void addAdminDiscount(@RequestBody Discount discount) {
	adservices.addDiscount(discount);
}
@RequestMapping(value="/getAllDiscounts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public List<Discount> getAllDiscounts() {
	return adservices.displayAllDiscounts();
}

@RequestMapping(value="/deleteAdminDiscount",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteAdminDiscount (@RequestBody Discount discount) {
	adservices.deleteDiscount(discount.getDiscountId());

}
}

