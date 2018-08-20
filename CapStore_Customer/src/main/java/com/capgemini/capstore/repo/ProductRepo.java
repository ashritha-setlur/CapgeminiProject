package com.capgemini.capstore.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

	@Query("select p from Product p where p.productName LIKE %:key%")
	public ArrayList<Product> findProductName(@Param(value="key") String key);
	
	@Query("select p from Product p where p.productBrand LIKE %:key%")
	public ArrayList<Product> findProductBrand(@Param(value="key") String key);

}
