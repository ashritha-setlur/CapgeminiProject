package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.repo.RatingRepo;


@Component
public class RatingServicesImpl implements RatingServices{

	@Autowired
	RatingRepo repo;

	Map<Integer,Double> merchant_Avg_list = new HashMap<Integer, Double>();
	Map<Integer,Double> product_Avg_list = new HashMap<Integer, Double>();

	@Override
	public Rating addRating(Rating rating) {
		repo.save(rating);
		return null;

	}

	//Returns the average rating of a product
	public double setAvgRatingOfProduct(int pId) {

		List<Double> product_rating_list = repo.getRatingList(pId);
		Double sum=0.0;
		for (Double i : product_rating_list) {	
			sum+=i;
		}
		Double avgRating = sum / product_rating_list.size();
		
		return avgRating;

	}

	//Returns a list which contains average rating of all the products of a merchant
	@Override
	public Map<Integer, Double> AvgOfProducts_List(int mId) {
		List<Product> id = repo.getProductListforMerchant(mId);
		List<Integer> product_id_list = new ArrayList<Integer>();
		Iterator<Product> it = id.iterator();
		while(it.hasNext()) {
			int i=it.next().getProductId();
			product_id_list.add(i);
		}

		for (int i : product_id_list) {
			double avgRating = setAvgRatingOfProduct(i);
			product_Avg_list.put(i, avgRating);
		}
		
		return product_Avg_list;
	}
	
	//Returns the average rating of a merchant
		@Override
		public double setAvgRatingOfMerchant(int mId) {
			List<Product> id = repo.getProductListforMerchant(mId);
			System.out.println("List ids are:"+id);
			List<Integer> product_id_list = new ArrayList<Integer>();
			Iterator<Product> it = id.iterator();
			while(it.hasNext()) {
				int i=it.next().getProductId();
				product_id_list.add(i);
			}

			double sum = 0;
			for (int i : product_id_list) {
				double avgRating = setAvgRatingOfProduct(i);
				product_Avg_list.put(i, avgRating);
				sum = sum + avgRating;
			}
			double avgRating = sum / product_id_list.size();
		
			return avgRating;
		}
		
		
}
