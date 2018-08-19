package com.capgemini.capstore.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.services.RatingServices;

@RestController
public class RatingController {

	@Autowired
	RatingServices services;

	@RequestMapping(value="/addRating",method=RequestMethod.POST)
	public Rating addRating(@RequestBody Rating rating)
	{
		Rating rate=services.addRating(rating);
		return rate;

	}
	
	@RequestMapping(value="/saveAvgProductRating", method=RequestMethod.POST)
	public void saveAvgProductRating(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		services.setAvgRatingOfProduct(jSon.getInt("pId"));
	}
	
	@RequestMapping(value="/getAvgOfProducts_List", method=RequestMethod.POST)
	public void getAvgOfProducts_List(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		services.AvgOfProducts_List(jSon.getInt("mId"));
	}

	@RequestMapping(value="/saveAvgMerchantRating", method=RequestMethod.POST)
	public void saveAvgMerchantRating(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		services.setAvgRatingOfMerchant(jSon.getInt("mId"));
	}



}
