package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.repo.AdminPromoRepo;

@Component
public class AdminPromoServicesImpl implements AdminPromoServices {
@Autowired
private AdminPromoRepo prorepo;

@Override
public int addPromo(Promo promo) {
	prorepo.save(promo);
	return promo.getPromoId();
}
@Override
public List<Promo> displayAllPromos() {
	return prorepo.findAll();
}
@Override
public void deletePromo(int promoId) {
	prorepo.deleteById(promoId);	
}

}
