package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Wishlist")
public class Wishlist {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishlistId;

	@OneToMany
	private List<Product> products;


	//Constructors
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
}
