package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Integer>, CrudRepository<Merchant, Integer> {

	@Query("select m.merchantId,m.merchantName,m.merchantEmail,m.mobileNo,m.merchantAddress,m.merchantRevPercent,m.dateOfReg,m.merchantRevenue from Merchant m where m.merchantId in (select a.authId from Authentication a where a.userAccess='USER_THIRDPARTYMERCHANT' and a.verification='2')")
	List<Merchant> getThirdPartyMerchant();

	@Query("select m.merchantId,m.merchantName,m.merchantEmail,m.mobileNo,m.merchantAddress,m.merchantRevPercent,m.dateOfReg,m.merchantRevenue from Merchant m where m.merchantId in (select a.authId from Authentication a where a.userAccess='USER_THIRDPARTYMERCHANT' and a.verification='1')")
	List<Merchant> getRequestedThirdPartyMerchant();
	
	@Query("select m from Merchant m where m.mobileNo =:mobile")
	public Merchant getMerchantId(@Param(value="mobile") String mobile);
	@Modifying
	@Transactional
	@Query("update Merchant m set m.merchantRevenue=?2 where m.merchantId=?1")
	public double addMerchantRevenue(int merchantId, double amount);
}
