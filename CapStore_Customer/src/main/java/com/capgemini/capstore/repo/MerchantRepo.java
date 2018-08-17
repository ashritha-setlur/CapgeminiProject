package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Integer> {


}
