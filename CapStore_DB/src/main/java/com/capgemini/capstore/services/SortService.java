package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Product;

public interface SortService {

	public List<Product> getProductInRange(String searchedItem);
	public List<Product> getProductAscPrice(String searchedItem);
	public List<Product> getProductDescPrice(String searchedItem);
	public List<Product> getProductMostViewd(String searchedItem);
	public List<Product> getProductRating(String searchedItem);
	
}
