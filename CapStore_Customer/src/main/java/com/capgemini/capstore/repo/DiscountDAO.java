package com.capgemini.capstore.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Cart;

@Repository
public interface DiscountDAO extends JpaRepository<Cart, Integer> {
	
	@Query("SELECT c FROM Cart c WHERE c.cartId=?1")
	Cart findByDiscountId(int cartId);
}
