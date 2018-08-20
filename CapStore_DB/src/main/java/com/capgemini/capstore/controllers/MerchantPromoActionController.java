package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.services.MerchantPromoServices;

@RestController
public class MerchantPromoActionController {
@Autowired
private MerchantPromoServices mpservices;
//merchant adds promos
@RequestMapping(value="/addMerchantPromo",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
public void addMerchantPromo(@RequestBody Promo promo) {
	mpservices.addPromo(promo);
}
@RequestMapping(value="/displayAllMerchantPromos",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public List<Promo> getAllPromos(){
	return mpservices.displayAllPromos();
}
@RequestMapping(value="/deleteMerchantPromo",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
public void deleteMerchantPromo(@RequestBody Promo promo) {
	mpservices.deletePromo(promo.getPromoId());

}
}
