package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.repo.MerchantRepo;
@Component
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private MerchantRepo mrepo;
	
		

	@Override
	public int addMerchant(Merchant merchant) {
		 mrepo.save(merchant);
		return  merchant.getMerchantId();
	}

	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = mrepo.getOne(merchantId);
		return merchant;
	}

	@Override
	public List<Merchant> displayAllMerchants() {
		return mrepo.findAll();
	}

	@Override
	public void deleteMerchant(int merchantId) {
		mrepo.deleteById(merchantId);
	}

}
