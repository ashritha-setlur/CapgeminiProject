package com.capgemini.capstore.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rating")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ratingId;
	@OneToOne(cascade=CascadeType.ALL)
	private Product product;
	private double rating;
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	//Constructors
	public Rating(int ratingId) {
		super();
		this.ratingId = ratingId;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int ratingId, Product product, double rating, Customer customer) {
		super();
		this.ratingId = ratingId;
		this.product = product;
		this.rating = rating;
		this.customer = customer;
	}

	//Getters and Setters
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
