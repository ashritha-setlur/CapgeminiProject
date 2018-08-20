package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>, CrudRepository<Feedback, Integer> {

	@Query("select f from Feedback f where f.id=?1")
	public Feedback getFeedbacksForProduct(int id) ;
}
