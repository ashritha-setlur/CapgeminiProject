package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
