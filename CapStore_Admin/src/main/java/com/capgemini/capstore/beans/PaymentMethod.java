package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PaymentMethod")
public class PaymentMethod {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int cash;
	private int netbanking;

	//Constructors
	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentMethod(int id, int cash, int netbanking) {
		super();
		this.id = id;
		this.cash = cash;
		this.netbanking = netbanking;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getNetbanking() {
		return netbanking;
	}
	public void setNetbanking(int netbanking) {
		this.netbanking = netbanking;
	}
}
