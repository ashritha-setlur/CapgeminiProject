package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
public class Wishlist {

	@OneToMany
	private List<Product> products;
	private int quantity;

	//Constructors
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
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
