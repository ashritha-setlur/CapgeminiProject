package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>,CrudRepository<Customer, Integer>{

	/*@Query("select customer  from Customer customer")
	public  List<Customer> getAllCustomers();
*/
}
