package com.capgemini.capstore.services;

import java.util.List;
import com.capgemini.capstore.beans.Merchant;

public interface MerchantServices {

	public int addMerchant(Merchant merchant);

	public Merchant displaySingleMerchant(int merchantId);

	public List<Merchant> displayAllMerchants();

	public void deleteMerchant(int merchantId);

}
