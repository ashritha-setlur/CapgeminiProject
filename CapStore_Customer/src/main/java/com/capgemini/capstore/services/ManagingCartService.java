package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Product;

public interface ManagingCartService {

	public void addCart(int custId) ;
	
	public Product addProductToCart(int prodId,int custId) ;
	public Product removeProductFromCart(int prodId,int custId) ;
	public List<Product> viewCart(int cartId) ;
}
