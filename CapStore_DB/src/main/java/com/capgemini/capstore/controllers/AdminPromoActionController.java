package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.services.AdminPromoServices;

@RestController
public class AdminPromoActionController {
@Autowired
private AdminPromoServices apservices;
//admin adds promos
@RequestMapping(value="/addAdminPromo",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public void addAdminPromo(@RequestBody Promo promo) {
	apservices.addPromo(promo);
}
@RequestMapping(value="/getAllPromos",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public List<Promo> getAllPromos(){
	return apservices.displayAllPromos();
}
@RequestMapping(value="/deleteAdminPromo",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteAdminPromo(@RequestBody Promo promo) {
	apservices.deletePromo(promo.getPromoId());

}
}
