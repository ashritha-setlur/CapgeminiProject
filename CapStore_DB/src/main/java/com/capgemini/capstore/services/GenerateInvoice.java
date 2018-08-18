package com.capgemini.capstore.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Transaction;
import com.capgemini.capstore.repo.OrderDetailsRepo;
@Component
public class GenerateInvoice {
	@Autowired
	OrderDetailsRepo invoice;
	

	private static int orderId=100;
	
	public int generateInvoice(int customerId, int productId, int orderAmount,int transactionId)
	{
//		OrderDetails order=new OrderDetails();
//		order.setOrderId(orderId++);
		
		Product product=invoice.findProductByProductId(productId);
		Customer customer=invoice.findCustomerByCustomerId(customerId);
		Transaction trans=invoice.findtransactionBytransactionId(transactionId);
		OrderDetails order=new OrderDetails();
		order.setOrderId(orderId++);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setDeliveryStatus("confirmed");
		long millis=System.currentTimeMillis();
		java.sql.Date orderDate = new java.sql.Date(new java.util.Date().getTime());
		order.setDeliveryDate(orderDate);
		java.sql.Date deliveryDate = this.addDays(orderDate, 5);
		order.setDeliveryDate(deliveryDate);
		invoice.save(order);
		return orderId++;	
	}
	
	private Date addDays(Date orderDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(orderDate);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
	}
	
}
