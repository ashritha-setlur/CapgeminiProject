package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.repo.ISortDao;
@Component(value="sortservice")
public class SortServiceImpl implements SortService{

	@Autowired
	private ISortDao dao;
	
	@Override
	public List<Product> getProductInRange(String searchedItem) {
		List<Product> result = dao.getProductsWithinRange(searchedItem);
		if(result==null)
		{
		   System.out.println("products are unavaliable between the price 100 and 1000");
		}
		return result;
		//return dao.getProductsWithinRange(searchedItem);
	}

	@Override
	public List<Product> getProductAscPrice(String searchedItem) {
		
		return dao.getProductAscPrice(searchedItem);
	}

	@Override
	public List<Product> getProductDescPrice(String searchedItem) {
		
		return dao.getProductDescPrice(searchedItem);
	}

	@Override
	public List<Product> getProductMostViewd(String searchedItem) {
		
		return dao.getProductMostlyViewed(searchedItem);
	}

	@Override
	public List<Product> getProductRating(String searchedItem) {
		
		return dao.getBestProducts(searchedItem);
	}

	
	
	
}
