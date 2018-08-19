package com.capgemini.capstore.services;

import java.util.Map;

import com.capgemini.capstore.beans.Rating;

public interface RatingServices {
	
	public Rating addRating(Rating rating);

	public double setAvgRatingOfMerchant(int mId);
	
	public double setAvgRatingOfProduct(int pId);
	
	public Map<Integer,Double> AvgOfProducts_List(int mId);
	
	}
