package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.repo.AdminDiscountRepo;

@Component
public class AdminDiscountServicesImpl implements AdminDiscountServices {
@Autowired
private AdminDiscountRepo discrepo;

@Override
public int addDiscount(Discount discount) {
	discrepo.save(discount);
	return discount.getDiscountId();
}

@Override
public List<Discount> displayAllDiscounts() {
	return discrepo.findAll();
}

@Override
public void deleteDiscount(int discountId) {
	discrepo.deleteById(discountId);
	
}
}

