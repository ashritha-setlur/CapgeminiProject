package com.capgemini.capstore.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.Authentication;

public interface AuthenticationRepo extends JpaRepository<Authentication,Integer> {
	
	@Transactional
	@Modifying
	@Query("update Authentication a set a.verification ='2' where a.authId=:authId")
	void saveThirdPartyMerchant(@Param("authId")int merchantId);
	@Transactional
	@Modifying
	@Query("update Authentication a set a.verification ='3' where a.authId=:authId")
	void rejectThirdPartyMerchant(@Param("authId") int authId);
}

