package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.CustomerWishlistRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderRepo;
import com.capgemini.capstore.repo.DisplayOrderedItemsRepo;

@Component
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	private MerchantRepo mrepo;
	
	//status delivery
	@Autowired
	private OrderRepo orepo;
	
	//update profile
	@Autowired
	private CustomerRepo crepo;
	
	//Wishlist
	@Autowired
	private CustomerWishlistRepo wrepo;
	

	//Wishlist
	@Autowired
	private DisplayOrderedItemsRepo prepo;
	
    //OrderedItemsDisplay
	@Override
	public List<OrderDetails> displayCustomerOrderedItems(int id) {
	List<OrderDetails> listOfproducts = prepo.findByCustomerId(id);
	return listOfproducts;
	}

	
	//wishlist display
	@Override
	public Wishlist display(int custid) {
		Customer customer = crepo.getOne(custid);
	    return wrepo.getOne(customer.getWishlist().getWishlistId());
	}
	
   //status delivery
	@Override
	public String getDeliveryStatus(int orderId) {
		OrderDetails oDetails = orepo.getOne(orderId);
	    String status = oDetails.getDeliveryStatus();
		return status;
	}

	//update his profile information
    @Override
	public void updateCustomer(Customer customer) {
		 crepo.save(customer);
	}
}
