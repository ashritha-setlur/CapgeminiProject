package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Promo;

public interface MerchantPromoServices {

	public int addPromo(Promo promo);	
	public List<Promo> displayAllPromos();
	public void deletePromo(int promoId);
}

