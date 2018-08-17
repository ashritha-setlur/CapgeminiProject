package com.capgemini.capstore.beans;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Wishlist {
	
	@OneToOne
	private Product product;
	private int quantity;
	
	//Constructors
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wishlist(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	//Getters and Setters
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
