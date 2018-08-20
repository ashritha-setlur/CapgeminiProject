package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>, CrudRepository<Rating, Integer> {
	@Query(value = "SELECT r.ratingValue FROM Rating r WHERE r.product.productId=:pId")
	public List<Double> getRatingList(@Param(value = "pId")int pId);
	@Query(value = "SELECT m.merchantInventory.products FROM Merchant m WHERE m.merchantId=:mId")
	public List<Product> getProductListforMerchant(@Param(value = "mId")int mId);

}
