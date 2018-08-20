package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>, CrudRepository<Customer , Integer>{

	// To retrieve Customer ID after saving customer Credentials
	@Query("select c from Customer c where c.mobileNo =:mobile")
	public Customer getCustomerId(@Param(value="mobile") String mobile);
	@Query(value ="select cust from Customer cust where cust.id=?1")
	public Customer getShipmentDetails(@Param(value ="customerId") int customerId);
	//To retrieve all the Customer Details
	@Query("select customer  from Customer customer")
	public  List<Customer> getAllCustomers();
}
