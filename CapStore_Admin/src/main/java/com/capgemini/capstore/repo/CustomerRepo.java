package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.capstore.beans.Customer;



public interface CustomerRepo extends  JpaRepository<Customer, Integer>{

	@Query("select customer  from Customer customer")
	public  List<Customer> getAllCustomers();
}