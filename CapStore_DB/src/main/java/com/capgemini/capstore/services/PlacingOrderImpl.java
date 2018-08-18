package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.CartRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.ProductRepo;
@Component
public class PlacingOrderImpl implements PlacingOrderServices {
	
	@Autowired
	ProductRepo placingOrder;	
	@Autowired
	CartRepo cartrepo;
	@Autowired
	CustomerRepo cust_repo;
	@Autowired
	ProductRepo prod_repo;
	
	//method to check if required quantity is present in the inventory
	
	@Override
	public boolean placeOrder(int custId, int cartId, int prodId) {
		
				Customer customer=cust_repo.getOne(custId);
				
				Cart cart= cartrepo.getOne(customer.getCart().getCartId());
						
				Product product=prod_repo.getOne(prodId);
				
				if(product.getProductQuantity()>=cart.getQuantity())
				{
					return true;
				}else
				{
				
					return false;
				}	
			
	}
	
	
	
	
	
	
	
	
	
	

}
