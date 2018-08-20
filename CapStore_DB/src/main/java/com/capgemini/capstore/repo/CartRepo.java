package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>, CrudRepository<Cart, Integer>{

	@Query("SELECT c FROM Cart c WHERE c.cartId=?1")
	public Cart findByCartId(int cartId);

}
