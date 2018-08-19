package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Wishlist;

public interface CustomerWishlistRepo extends JpaRepository<Wishlist,Integer>{
	
	

}
