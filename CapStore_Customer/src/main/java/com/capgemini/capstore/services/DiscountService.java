package com.capgemini.capstore.services;

import com.capgemini.capstore.beans.Cart;

public interface DiscountService {

	public Cart discount(int cartId);
}
