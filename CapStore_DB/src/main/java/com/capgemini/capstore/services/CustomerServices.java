package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;

public interface CustomerServices {

    //public List<Product> displayAllProducts();
	
	public String getDeliveryStatus(int orderId);
	
	public void updateCustomer(Customer customer); 
	
	public Wishlist display (int custid);
	
	public List<OrderDetails> displayCustomerOrderedItems(int id);
	
}
