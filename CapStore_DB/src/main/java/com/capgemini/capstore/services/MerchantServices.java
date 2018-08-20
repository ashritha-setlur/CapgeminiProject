package com.capgemini.capstore.services;

import com.capgemini.capstore.beans.Merchant;

public interface MerchantServices {
	public Merchant registerMerchant(Merchant merchant, String password, String type);
}
