package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Promo;

@Repository
public interface AdminPromoRepo extends JpaRepository<Promo,Integer>{
}
