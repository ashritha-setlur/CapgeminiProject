package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>, CrudRepository<Transaction, Integer> {

}
