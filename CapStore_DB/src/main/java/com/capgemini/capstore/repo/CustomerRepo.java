package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.OrderDetails;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
  //updating profile
}
