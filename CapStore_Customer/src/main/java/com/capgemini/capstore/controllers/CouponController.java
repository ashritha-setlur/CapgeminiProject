package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.CouponsService;

@RestController
public class CouponController {

	@Autowired
	CouponsService couponservice;

	@RequestMapping(value="/validatePromo" ,method=RequestMethod.GET)
	public void promovalidate(int orderId, String promo)
	{
		couponservice.coupon(orderId,promo);
	}
}
