package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.repo.MerchantDiscountRepo;

@Component
public class MerchantDiscountServicesImpl implements MerchantDiscountServices{
@Autowired
private MerchantDiscountRepo mdiscrepo;
	
@Override
	public int addDiscount(Discount discount) {
		mdiscrepo.save(discount);
		return discount.getDiscountId();
	}

	@Override
	public List<Discount> displayAllDiscounts() {
		return mdiscrepo.findAll();
	}

	@Override
	public void deleteDiscount(int discountId) {
	mdiscrepo.deleteById(discountId);
		
}
	
}

