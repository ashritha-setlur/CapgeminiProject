package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Discount")
public class Discount {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int discountId;
	private String discountName;
	private String discountDesc;

	//Constructors
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(int discountId) {
		super();
		this.discountId = discountId;
	}

	public Discount(int discountId,String discountName, String discountDesc) {
		super();
		this.discountId = discountId;
		this.discountName = discountName;
		this.discountDesc = discountDesc;
	}


	//Getters and Setters
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDiscountDesc() {
		return discountDesc;
	}

	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}
}
