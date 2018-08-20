package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Integer> {

	// To fetch Merchant ID after saving his credentials
	@Query("select m from Merchant m where m.mobileNo =:mobile")
	public Merchant getMerchantId(@Param(value="mobile") String mobile);
}
