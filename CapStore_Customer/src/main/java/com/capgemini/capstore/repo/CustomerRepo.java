package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	// To retrieve Customer ID after saving customer Credentials
	@Query("select c from Customer c where c.mobileNo =:mobile")
	public Customer getCustomerId(@Param(value="mobile") String mobile);
}
