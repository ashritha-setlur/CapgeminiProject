package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>, CrudRepository<Category, Integer> {

}
