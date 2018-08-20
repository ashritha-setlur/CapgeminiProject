package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer>, CrudRepository<Feedback, Integer> {

	@Query(value = "SELECT f.feedbackDesc FROM Feedback f WHERE f.product.productId=:pId")
	public List<String> getFeedbackList(@Param(value = "pId")int pId);
}
