package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;

public interface CapStoreAdminServices {


	public List<Merchant> viewThirdPartyMerchantRequest();
	public void addThirdPartyMerchant(int merchantId);
	public void rejectThirdPartyMerchant(int merchantId);
	public List<Merchant> viewThirdPartyMerchant();
	public void deleteThirdPartyMerchant(int merchantId);
	public List<OrderDetails> viewReturnedProduct();
	public List<OrderDetails> acceptReturnedProduct(int orderId);

}
