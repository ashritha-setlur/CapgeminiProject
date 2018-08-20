package com.capgemini.capstore.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.repo.CouponsDAO;
import com.capgemini.capstore.repo.OrderDAO;

@Component
public class CouponsServiceImpl implements CouponsService {
	
	@Autowired
	 CouponsDAO couponsdao;
	@Autowired
	OrderDAO orderdao;
	@Override
	public double coupon( int orderid,String promoName) {
		Promo promo = couponsdao.findBypromoId(promoName);
		OrderDetails order= orderdao.getOrderDetails(orderid);
		if(promo!=null)
		{
			LocalDate localdate = LocalDate.now();
			Date date1= Date.valueOf(localdate);
			if(promo.getStartDate().before(date1)&&promo.getEndDate().after(date1)&&order.getOrderAmount()>promo.getPromoQuantity())
			{
				order.setOrderAmount(order.getOrderAmount()-promo.getPromoQuantity());
				
				orderdao.save(order);
				System.out.println("promo added sucessfully");
			}
		}
		else
		{
			System.out.println("Invalid code");
		}
		return 0;
	}

	
}
