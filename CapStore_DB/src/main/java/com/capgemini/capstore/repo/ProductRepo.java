package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer> {

	//getting the products within the given range
	@Query("select p from Product p where p.productName=?1 AND (p.productPrice between 100 AND 10000)")
	public List<Product> getProductsWithinRange(String searchedItem);
	//getting the products based on ascending order of price
	@Query("select p from Product p where p.productName=?1 order by p.productPrice ASC")
	public List<Product> getProductAscPrice(String searchedItem);
	//getting the products based on descending order of price
	@Query("select p from Product p where p.productName=?1 order by productPrice DESC")
	public List<Product> getProductDescPrice(String searchedItem);
	//getting the products based on mostly viewed products
	@Query("select p from Product p where p.productName=?1 order by productViews DESC")
	public List<Product> getProductMostlyViewed(String searchedItem);
	//getting the products based on its ratings  
	//@Query("select r.product from Rating r where r.product.productName=?1 and r.rating>=(select max(ra.rating) from Rating ra)")
	@Query("select r.product from Rating r where r.product in (select p from Product p where p.productName =?1) order by r.ratingValue DESC")
	public List<Product> getBestProducts(String searchedItem);
	@Query("select cart.products from Cart cart where cart.products=?1")
	public Product getOneProduct(Product product);
	@Query("select p from Product p where p.productName LIKE %:key%")
	public List<Product> findProductName(@Param(value="key") String key);
	@Query("select p from Product p where p.productBrand LIKE %:key%")
	public List<Product> findProductBrand(@Param(value="key") String key);
	@Query("Select product from Product product")
	public List<Product> getAllProducts();
	@Query("Select p from Product p where p.productId=?1")
	public Product getProduct(int productId);
}
