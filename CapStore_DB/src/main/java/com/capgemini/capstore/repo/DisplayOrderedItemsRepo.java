package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.OrderDetails;

public interface DisplayOrderedItemsRepo  extends JpaRepository<OrderDetails, Integer>{
   @Query("select o from OrderDetails o where o.customer.id=?1")
   public List<OrderDetails> findByCustomerId(int id);
 }
