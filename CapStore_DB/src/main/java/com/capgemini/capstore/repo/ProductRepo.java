package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("select cart.products from Cart cart where cart.products=?1")
	public Product getOneProduct(Product product);

	
}
