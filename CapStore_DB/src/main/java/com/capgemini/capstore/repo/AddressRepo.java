package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>, CrudRepository<Address, Integer> {

}
