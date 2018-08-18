package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.AdminSetMinOrderAmountService;

@Controller
@RestController
public class AdminSetMinOrderAmountActionController {

	@Autowired
	private AdminSetMinOrderAmountService adminSetMinOrderAmountService ;
	
	//Admin sets the minimum order amount
	@RequestMapping(value="/adminPage",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void setMinOrderAmount(double amount) {
		adminSetMinOrderAmountService.setMinOrderAmount(amount);
	}
	
}