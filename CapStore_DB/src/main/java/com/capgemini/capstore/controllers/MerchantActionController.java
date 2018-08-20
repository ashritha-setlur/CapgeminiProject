package com.capgemini.capstore.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.services.MerchantServices;

@Controller
@RestController
public class MerchantActionController {

	@Autowired
	private MerchantServices merchantService;

	//Register Merchant
	@RequestMapping(method=RequestMethod.POST,value={"/merchantRegister"},produces={"application/text"})
	public void registerAction(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json);
		Merchant merchantObj=new Merchant();
		merchantObj.setMerchantName(jSon.getString("firstName"));
		merchantObj.setMerchantEmail(jSon.getString("lastName"));
		merchantObj.setMobileNo(jSon.getString("mobileNo"));
		long pinCode=jSon.getInt("pincode");
		merchantObj.setMerchantAddress(new Address(jSon.getString("addressline1"),jSon.getString("addressline2"),jSon.getString("city"),jSon.getString("state"),pinCode,jSon.getString("country")));
		merchantObj=merchantService.registerMerchant(merchantObj,jSon.getString("password"),jSon.getString("type"));
	}
}
