package com.capgemini.capstore.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>
{
    @Modifying
    @Transactional
    @Query("update Merchant m set m.merchantRevenue=m.merchantRevenue-?2 where m.merchantId=?1 ")
	void updateMerchantRevenue(int merchantId,double merchantPrice);
    @Modifying
    @Transactional
    @Query("update Admin a set a.capstoreRevenue= a.capstoreRevenue-?1")
	void updateAdminRevenue(double adminPrice);
	
}
