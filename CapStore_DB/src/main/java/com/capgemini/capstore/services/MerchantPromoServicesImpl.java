package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.repo.MerchantPromoRepo;

@Component
public class MerchantPromoServicesImpl implements MerchantPromoServices {
@Autowired
private MerchantPromoRepo mprorepo;
	@Override
	public int addPromo(Promo promo) {
		mprorepo.save(promo);
		return promo.getPromoId();
		
	}

	@Override
	public List<Promo> displayAllPromos() {
		
		return mprorepo.findAll();
	}

	@Override
	public void deletePromo(int promoId) {
		mprorepo.deleteById(promoId);
}
	}

