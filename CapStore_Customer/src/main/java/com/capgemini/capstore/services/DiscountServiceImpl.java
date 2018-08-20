package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.DiscountDAO;

@Component
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	 DiscountDAO discountDAO;
	Discount discount;
	@Override
	public Cart discount(int cartId) {
		Cart products= discountDAO.findByDiscountId(cartId);
		System.out.println(products);
		List<Product> productlist= products.getProducts();
		for(Product product:productlist)
		{
			String discount = product.getProductDiscount().getDiscountDesc();
			int discount1= Integer.parseInt(discount);
			float discountprice = (float) (0.01*discount1);
    		double price =  product.getProductPrice();
    		String finalprice= Double.toString(price-(price*discountprice));
    		product.getProductDiscount().setDiscountDesc(finalprice);
		}

		discountDAO.save(products);
		return products;
	}
	
	

}
