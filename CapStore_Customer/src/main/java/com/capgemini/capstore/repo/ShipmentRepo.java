package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Customer;

public interface ShipmentRepo extends JpaRepository<Customer, Integer> {
	
	//Query to retrieve customer object from the database
	@Query(value ="select cust from Customer cust where cust.id=?1")
	public Customer getShipmentDetails(@Param(value ="customerId") int customerId);
	
}
