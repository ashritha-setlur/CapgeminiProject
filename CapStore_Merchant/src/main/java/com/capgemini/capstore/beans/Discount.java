package com.capgemini.capstore.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Discount {

	@NotNull
	@NotEmpty
	private int discountId;
	@NotNull
	@NotEmpty
	private String discountName;
	@NotNull
	@NotEmpty
	private String discountDesc;

	//Constructors
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(@NotNull @NotEmpty int discountId) {
		super();
		this.discountId = discountId;
	}

	public Discount(@NotNull @NotEmpty int discountId, @NotNull @NotEmpty String discountName,
			@NotNull @NotEmpty String discountDesc) {
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
