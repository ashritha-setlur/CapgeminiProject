package com.capgemini.capstore.beans;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Category {
	
	@NotNull
	@NotEmpty
	private int categoryId;
	@NotNull
	@NotEmpty
	private String categoryName;
	@NotNull
	@NotEmpty
	private String categoryDesc;
	
	
	//Constructors
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public Category(int categoryId, String categoryName, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}
	
	
	
	//Getters and Setters
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
}
