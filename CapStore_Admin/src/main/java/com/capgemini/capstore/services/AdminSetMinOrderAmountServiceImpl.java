package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Admin;
import com.capgemini.capstore.repo.AdminRepo;

@Component(value="adminSetMinOrderAmountService")
public class AdminSetMinOrderAmountServiceImpl implements AdminSetMinOrderAmountService{

	@Autowired
	private AdminRepo adminRepo ;
	
	@Override
	public void setMinOrderAmount(double amount) {
		adminRepo.setMinOrderAmount(amount) ;
	}

	
}
