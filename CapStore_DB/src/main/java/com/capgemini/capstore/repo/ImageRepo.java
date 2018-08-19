package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Image;

public interface ImageRepo extends JpaRepository<Image, Integer>, CrudRepository<Image, Integer>{

}
