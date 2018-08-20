package com.capgemini.capstore.controllers;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.services.AdminServices;

@Controller
@RestController
public class AdminRatingController {

	@Autowired
	AdminServices adminServices;

	@RequestMapping(value="/saveAvgProductRating", method=RequestMethod.POST)
	public double saveAvgProductRating(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		double avgProductRating = adminServices.setAvgRatingOfProduct(jSon.getInt("pId"));
		return avgProductRating;

	}

	@RequestMapping(value="/getAvgOfProducts_List", method=RequestMethod.POST)
	public Map<Integer,Double> getAvgOfProducts_List(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		Map<Integer,Double> product_list = adminServices.AvgOfProducts_List(jSon.getInt("mId"));
		return product_list;
	}

	@RequestMapping(value="/saveAvgMerchantRating", method=RequestMethod.POST)
	public double saveAvgMerchantRating(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		double avgMerchantRating = adminServices.setAvgRatingOfMerchant(jSon.getInt("mId"));
		return avgMerchantRating;
	}

}
