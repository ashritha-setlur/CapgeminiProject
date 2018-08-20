package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Promo;

public interface PromoRepo extends JpaRepository<Promo, Integer>, CrudRepository<Promo, Integer> {

	@Query("SELECT p FROM Promo p WHERE p.promoName=?1")
	public Promo findByPromoName(String promoName);

}
