package com.capgemini.capstore.services;

import com.capgemini.capstore.beans.OrderDetails;

public interface DeliveryProductsService {
	
	public OrderDetails deliveringProducts(int orderId);

}
