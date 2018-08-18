package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.Product;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{
	
	
	@Query("select f from Feedback f where f.id=?1")
	public Feedback getFeedbacksForProduct(int id) ;
}
