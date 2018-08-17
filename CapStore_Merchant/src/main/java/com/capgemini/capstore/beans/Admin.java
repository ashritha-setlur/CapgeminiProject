package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Details")
public class Admin {

	@Id
	private int id;
	private double minimumOrderAmount;
	private double capstoreRevenue;

	// Constructors

	public Admin(int id, double minimumOrderAmount, double capstoreRevenue) {
		super();
		this.id = id;
		this.minimumOrderAmount = minimumOrderAmount;
		this.capstoreRevenue = capstoreRevenue;
	}

	public Admin() {
		super();
	}

	public Admin(int id) {
		super();
		this.id = id;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMinimumOrderAmount() {
		return minimumOrderAmount;
	}

	public void setMinimumOrderAmount(double minimumOrderAmount) {
		this.minimumOrderAmount = minimumOrderAmount;
	}

	public double getCapstoreRevenue() {
		return capstoreRevenue;
	}

	public void setCapstoreRevenue(double capstoreRevenue) {
		this.capstoreRevenue = capstoreRevenue;
	}
}
