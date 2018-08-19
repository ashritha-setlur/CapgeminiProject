package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	@Modifying
	@Transactional
	@Query("update Admin a set a.capstoreRevenue=a.capstoreRevenue+?1")
	public double addCapstoreRevenue(double amount);
}
