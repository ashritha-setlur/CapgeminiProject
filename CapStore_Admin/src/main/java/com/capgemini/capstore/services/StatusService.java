package com.capgemini.capstore.services;


import com.capgemini.capstore.beans.OrderDetails;


public interface StatusService {
	//public int getId(int orderId);
	//displaying order status for particular orderId
	public void orderStatus(int orderId, int num);
}
