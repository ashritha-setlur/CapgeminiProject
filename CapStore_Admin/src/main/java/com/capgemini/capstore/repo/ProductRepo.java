package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("Select product from Product product")
	public List<Product> getAllProducts();
}
