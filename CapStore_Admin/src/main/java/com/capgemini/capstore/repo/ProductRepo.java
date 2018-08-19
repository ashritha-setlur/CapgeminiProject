package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
