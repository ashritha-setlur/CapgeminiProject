package com.capgemini.capstore.beans;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
public class Inventory {

	@OneToMany
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
