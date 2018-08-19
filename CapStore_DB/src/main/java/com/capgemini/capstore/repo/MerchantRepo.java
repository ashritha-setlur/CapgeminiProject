package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Merchant;


public interface MerchantRepo extends JpaRepository<Merchant, Integer> {

	@Modifying
	@Transactional
@Query("update Merchant m set m.merchantRevenue=?2 where m.merchantId=?1")
public double addMerchantRevenue(int merchantId, double amount);

}
