package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.OrderDetailsRepo;

@Service
public class DeliveryProductsServiceImpl implements DeliveryProductsService {

	@Autowired
	OrderDetailsRepo orderDetailsRepo;
	
	@Override
	public OrderDetails deliveringProducts(int orderId) {
		
		
		OrderDetails orderDetails=orderDetailsRepo.deliveringProducts(orderId);
		if(orderDetails.getDeliveryStatus().equalsIgnoreCase("delivered"))
		{
			Product deliverproduct = orderDetails.getProduct();
			
				int qty=deliverproduct.getProductQuantity()-1;
				deliverproduct.setProductQuantity(qty);
				
				
			
				orderDetailsRepo.save(orderDetails);
			return orderDetails;
		}
		else 
		{
			return orderDetails;
		}
	}

}
