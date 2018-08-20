package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Discount;

public interface DiscountRepo extends JpaRepository<Discount, Integer>, CrudRepository<Discount, Integer> {

}
