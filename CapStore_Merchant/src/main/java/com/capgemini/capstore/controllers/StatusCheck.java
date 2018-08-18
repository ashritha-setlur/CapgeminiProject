package com.capgemini.capstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.services.StatusService;



@RestController
public class StatusCheck {
	
@Autowired
StatusService statusservice;


@RequestMapping(value="/deliveryStatus",method=RequestMethod.GET)
public void orderStatus(int orderId,int num)
{
	statusservice.orderStatus(orderId,num);
}
}