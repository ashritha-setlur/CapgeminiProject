package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>, CrudRepository<Cart, Integer>{

}
