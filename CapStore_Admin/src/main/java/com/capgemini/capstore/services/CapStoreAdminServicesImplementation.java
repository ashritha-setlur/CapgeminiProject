package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.MerchantRepo;
@Service
public class CapStoreAdminServicesImplementation implements CapStoreAdminServices {
	@Autowired
    public MerchantRepo merchantRepo;
	@Autowired
    public AuthenticationRepo aRepo;


	@Override
	public void addThirdPartyMerchant(int merchantId)  {
	aRepo.saveThirdPartyMerchant(merchantId);
	}
     
	@Override
	public void rejectThirdPartyMerchant(int merchantId) {
	aRepo.rejectThirdPartyMerchant(merchantId);
	}
	

	@Override
	public void deleteThirdPartyMerchant(int merchantId) {
		merchantRepo.deleteById(merchantId);
		aRepo.deleteById(merchantId);
	}

	@Override
	public List<Merchant> viewThirdPartyMerchantRequest() {
	    return merchantRepo.getRequestedThirdPartyMerchant();
	}

	@Override
	public List<Merchant> viewThirdPartyMerchant() {
		return merchantRepo.getThirdPartyMerchant();

	}
}
