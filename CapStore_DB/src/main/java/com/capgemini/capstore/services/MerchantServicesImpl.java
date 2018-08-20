package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.MerchantRepo;

@Component(value="merchantService")
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private AuthenticationRepo aRepo;
	@Autowired
	private MerchantRepo merchantRepo;
	@Override
	//Register Merchant
	public Merchant registerMerchant(Merchant merchant, String password, String type) {
		Merchant merchant1;

		merchantRepo.save(merchant);

		merchant1=merchantRepo.getMerchantId(merchant.getMobileNo());
		@SuppressWarnings("unused")
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Authentication auth=new Authentication(merchant1.getMerchantId(),merchant1.getMobileNo(),password,"USER_MERCHANT",2);
		if(type.equals("direct"))
			auth.setUserAccess("USER_DIRECTMERCHANT");
		else
			auth.setUserAccess("USER_THIRDPARTYMERCHANT");
		aRepo.save(auth);
		return merchant;
	}

}
