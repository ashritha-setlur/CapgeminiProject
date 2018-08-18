package com.capgemini.capstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Integer>{
	
	@Query("select m from Merchant m where m.merchantId in (select a.authId from Authentication a where a.userAccess='USER_THIRDPARTYMERCHANT' and a.verification='2')")
	List<Merchant> getThirdPartyMerchant();
	
	@Query("select m from Merchant m where m.merchantId in (select a.authId from Authentication a where a.userAccess='USER_THIRDPARTYMERCHANT' and a.verification='1')")
	List<Merchant> getRequestedThirdPartyMerchant();
}
