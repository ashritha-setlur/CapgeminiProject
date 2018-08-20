package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.services.AdminServices;

@Controller
@RestController
public class AdminPromoActionController {
	@Autowired
	AdminServices adminServices;

	//admin adds promos
	@RequestMapping(value="/addAdminPromo",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addAdminPromo(@RequestBody Promo promo) {
		adminServices.addPromo(promo);
	}
	@RequestMapping(value="/getAllPromos",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Promo> getAllPromos(){
		return adminServices.displayAllPromos();
	}
	@RequestMapping(value="/deleteAdminPromo",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdminPromo(@RequestBody Promo promo) {
		adminServices.deletePromo(promo.getPromoId());
	}
}
