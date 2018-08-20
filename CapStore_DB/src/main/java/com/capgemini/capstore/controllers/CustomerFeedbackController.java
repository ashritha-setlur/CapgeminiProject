package com.capgemini.capstore.controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.services.CustomerServices;

@Controller
@RestController
public class CustomerFeedbackController {

	@Autowired
	private CustomerServices customerServices;

	@RequestMapping(value="/addFeedback",method=RequestMethod.POST)
	public Feedback addFeedback(@RequestBody String feedBack) throws JSONException{
		JSONObject json=new JSONObject(feedBack);
		Feedback feedbackObj=new Feedback();
		feedbackObj.setFeedbackDesc(json.getString("feedbackdesc"));
		Feedback feedback=customerServices.addFeedback(feedbackObj);
		return feedback;
	}
	//to get product feedback
	@RequestMapping(value="/getFeedback",method=RequestMethod.POST)
	public List<String> getFeedback(@RequestBody String pid) throws JSONException{
		JSONObject json=new JSONObject(pid);
		List<String> feedbacks=customerServices.getFeedbacks(json.getInt("pid"));
		return feedbacks;
	}

	//Add Rating to a product
	@RequestMapping(value="/addRating",method=RequestMethod.POST)
	public Rating addRating(@RequestBody Rating rating){
		Rating rate=customerServices.addRating(rating);
		return rate;
	}
}
