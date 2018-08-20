package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.MerchantRepo;
@Component
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private MerchantRepo mrepo;
	
	@Autowired
	private AuthenticationRepo arepo;
	
	@Override
	public Merchant registerCustomer(Merchant merchant,String password,String type){
		
		mrepo.save(merchant);
		
	   Merchant merchant1=mrepo.getMerchantId(merchant.getMobileNo());
	   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	   Authentication auth=new Authentication(merchant1.getMerchantId(),merchant1.getMobileNo(),encoder.encode(password),"USER_MERCHANT",1);
	    
	  //Verifying the value of type of merchant and giving User Access
	   if(type.equals("direct"))
		   auth.setUserAccess("USER_DIRECTMERCHANT");
	    else if(type.equals("thirdparty"))
	       auth.setUserAccess("USER_THIRDPARTYMERCHANT");
	  arepo.save(auth);
	  return merchant;
	}

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
