package com.capgemini.capstore.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.capstore.beans.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>, CrudRepository<Admin, Integer> {

	@Transactional
	@Modifying
	@Query("update Admin set minimumOrderAmount=?1")
	public void setMinOrderAmount(double amount) ;
	@Query("update Merchant m set m.merchantRevenue=m.merchantRevenue-?2 where m.merchantId=?1 ")
	void updateMerchantRevenue(int merchantId,double merchantPrice);
	@Modifying
	@Transactional
	@Query("update Admin a set a.capstoreRevenue= a.capstoreRevenue-?1")
	void updateAdminRevenue(double adminPrice);
}
