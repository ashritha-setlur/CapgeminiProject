package com.capgemini.capstore.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>,CrudRepository<Product, Integer>{

/*	@Query("Select product from Product product")
	public List<Product> getAllProducts();*/
}
