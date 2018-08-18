package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.CartRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.ProductRepo;

@Component(value="managingCartService")
public class ManagingCartServiceImpl implements ManagingCartService{

	@Autowired
	private CustomerRepo customerRepo ;
	@Autowired
	private ProductRepo productRepo ;
	@Autowired
	private CartRepo cartRepo ;
	
	//add a cart to customer object
	@Override
	public void addCart(int custId) {
		Customer customer = customerRepo.getOne(custId);
		Cart cart = new Cart() ;
		cartRepo.save(cart) ;
		customer.setCart(cartRepo.getOne(cart.getCartId()));
		customerRepo.save(customer) ;
	}

	//add a product to the cart
	@Override
	public Product addProductToCart(int prodId, int custId) {
		Product product = productRepo.getOne(prodId) ;
		Customer customer = customerRepo.getOne(custId) ;
		Cart cart = cartRepo.getOne(customer.getCart().getCartId()) ;
		List<Product> products = cart.getProducts() ;
		products.add(product) ;
		cart.setProducts(products);
		cart.setQuantity(cart.getQuantity()+1);
		cartRepo.save(cart) ;
		return product ;
	}

	//remove a product from the cart
	@Override
	public Product removeProductFromCart(int prodId, int custId) {
		Product product = productRepo.getOne(prodId) ;
		Customer customer = customerRepo.getOne(custId) ;
		Cart cart = cartRepo.getOne(customer.getCart().getCartId()) ;
		List<Product> products = cart.getProducts() ;
		products.remove(product);
		cart.setProducts(products);
		cart.setQuantity(cart.getQuantity()-1);
		cartRepo.save(cart) ;
		return product ;
	}

	
	//display all the products from the cart
	@Override
	public List<Product> viewCart(int cartId) {
		return cartRepo.getOne(cartId).getProducts() ;
	}

}
