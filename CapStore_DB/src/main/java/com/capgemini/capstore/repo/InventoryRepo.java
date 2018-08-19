package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer>, CrudRepository<Inventory, Integer> {

}
