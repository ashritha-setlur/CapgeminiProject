package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> products;
	private int quantity;

	//Constructors

	public Cart(int cartId) {
		super();
		this.cartId = cartId;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
