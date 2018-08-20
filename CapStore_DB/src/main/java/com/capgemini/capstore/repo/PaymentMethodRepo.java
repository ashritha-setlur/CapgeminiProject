package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.PaymentMethod;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Integer>, CrudRepository<PaymentMethod, Integer>{

}
