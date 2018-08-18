package com.capgemini.capstore.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	@Transactional
	@Modifying
	@Query("update Admin set minimumOrderAmount=?1")
	public void setMinOrderAmount(double amount) ;
}
