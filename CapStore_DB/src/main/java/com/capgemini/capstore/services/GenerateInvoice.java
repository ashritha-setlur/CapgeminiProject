package com.capgemini.capstore.services;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.PaymentMethod;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Transaction;
import com.capgemini.capstore.repo.AdminRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderDetailsRepo;
import com.capgemini.capstore.repo.TransactionRepo;

@Component
public class GenerateInvoice {
	@Autowired
	OrderDetailsRepo invoice;
	@Autowired
	AdminRepo adminRepo;
    @Autowired
    MerchantRepo merchantRepo;
    @Autowired
    TransactionRepo transactionrepo;
	
    private static int orderId1=100;
	
	public int generateInvoice(int customerId, int productId, double orderAmount,int transactionId)
	{
		int orderId=orderId1++;
		Product product=invoice.findProductByProductId(productId);
		Customer customer=invoice.findCustomerByCustomerId(customerId);
		Transaction transaction=invoice.findtransactionBytransactionId(transactionId);
		OrderDetails order=new OrderDetails();
		order.setOrderId(orderId);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setTransaction(transaction);
		order.setDeliveryStatus("confirmed");		
		java.sql.Date orderDate = new java.sql.Date(new java.util.Date().getTime());
		order.setOrderDate(orderDate);
		order.setDeliveryDate(orderDate);
		order.setOrderAmount(orderAmount);
		java.sql.Date deliveryDate = this.addDays(orderDate, 5);
		order.setDeliveryDate(deliveryDate);
		invoice.save(order);
		return orderId;	
	}
	
	private Date addDays(Date orderDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(orderDate);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
	}
	
	public boolean updateCapRevenue(double amount, int productId)
	{
		Product product=invoice.findProductByProductId(productId);
		Merchant merchant=product.getProductMerchant();
		double totalPrice=product.getProductPrice();
		double percent=merchant.getMerchantRevPercent();
		double capstoreShare=(percent/100)*totalPrice;
		double merchantShare=totalPrice-capstoreShare;
		adminRepo.addCapstoreRevenue(capstoreShare);
		merchantRepo.addMerchantRevenue(merchant.getMerchantId(),merchant.getMerchantRevenue()+merchantShare);
		return true;	
	}
	
	public int savetransaction(int paymentMethod)
	{
		Transaction transaction = new Transaction();
		java.sql.Date transDate = new java.sql.Date(new java.util.Date().getTime());
		transaction.setTransDate(transDate);
		if(paymentMethod==1)
		{
			transaction.setPaymentMethod(new PaymentMethod(1,0));
		}else
		{
			transaction.setPaymentMethod(new PaymentMethod(0,1));
		}
		
		transactionrepo.save(transaction);
		
		System.out.println(transaction.getTransactionId());
		return transaction.getTransactionId();		
	}
	
}
