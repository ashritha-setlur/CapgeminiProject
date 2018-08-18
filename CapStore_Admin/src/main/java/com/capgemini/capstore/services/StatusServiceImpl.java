package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.repo.Status;

@Component
public class StatusServiceImpl implements StatusService{

    @Autowired
	Status order;

	public StatusServiceImpl() {
		
	}
	
	public void orderStatus(int orderId, int num){

		if(num==1)
		{
			OrderDetails order1 =order.findOrderByOrderId(orderId);
			order1.setDeliveryStatus("Delivered");
			order.save(order1);
			System.out.println("delivered");
		}
		else if(num==2)
		{
			OrderDetails order1 =order.findOrderByOrderId(orderId);
			order1.setDeliveryStatus("Returned");
			order.save(order1);
			System.out.println("returned");
		}
	}

}