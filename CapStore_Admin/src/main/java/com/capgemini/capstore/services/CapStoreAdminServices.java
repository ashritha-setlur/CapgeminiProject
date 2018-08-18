package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Merchant;

public interface CapStoreAdminServices {
	    
	
	public List<Merchant> viewThirdPartyMerchantRequest();
		public void addThirdPartyMerchant(int merchantId);
		public void rejectThirdPartyMerchant(int merchantId);
		public List<Merchant> viewThirdPartyMerchant();
		public void deleteThirdPartyMerchant(int merchantId);
}
