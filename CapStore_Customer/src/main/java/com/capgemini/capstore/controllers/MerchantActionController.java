package com.capgemini.capstore.controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.MerchantServices;

@RestController
public class MerchantActionController {

@Autowired
	private MerchantServices mservices;

	@RequestMapping(value="/addMerchant", method=RequestMethod.POST)
	public void addMerchant(@RequestBody Merchant merchant) {
		mservices.addMerchant(merchant);
	
	}
	
	@RequestMapping(value="/getMerchant", method=RequestMethod.GET)
	public Merchant getMerchant(int merchantId) {
	return mservices.displaySingleMerchant(merchantId);
	
	}
	//to add product feedback
		@RequestMapping(value="/addFeedback",method=RequestMethod.POST)
		public Feedback addFeedback(@RequestBody String feedBack) throws JSONException
		{
			JSONObject json=new JSONObject(feedBack);
			Feedback feedbackObj=new Feedback();
			feedbackObj.setFeedbackDesc(json.getString("feedbackdesc"));
			Customer customer=new Customer();
			customer.setId(json.getInt("customerId"));
			Product product=new Product();
			product.setProductId(json.getInt("productId"));
			feedbackObj.setProduct(product);
			feedbackObj.setCustomer(customer);
			Feedback feedback=mservices.addFeedback(feedbackObj);
			return feedback;
		}
		
		
		//to get product feedback
		@RequestMapping(value="/getFeedback",method=RequestMethod.POST)
		public List<Feedback> getFeedback(@RequestBody String pid) throws JSONException
		{
			JSONObject json=new JSONObject(pid);
			List<Feedback> feedbacks=mservices.getFeedbacks(json.getInt("pid"));
			return feedbacks;
			
		}
		
		
//		@RequestMapping(value="/getFeedback",method=RequestMethod.GET)
//		public List<Feedback> getFeedback(int id)
//		{
//			List<Feedback> feedbacks=services.getFeedbacks(id);
//			return feedbacks;
//			
//		}
}
