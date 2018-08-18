package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.capstore.beans.Authentication;

@Repository
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
