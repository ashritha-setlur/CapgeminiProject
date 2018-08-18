package com.capgemini.capstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.services.SortService;


@RestController
public class SortingController {

	@Autowired
	SortService sortservice;
	
	@RequestMapping(value="/range", method=RequestMethod.GET)
	public List<Product> range(String searchedItem)
	{
		
		return sortservice.getProductInRange(searchedItem);
	}
	
	@RequestMapping(value="/ascprice", method=RequestMethod.GET)
	public List<Product> ascPrice(String searchedItem)
	{
		return sortservice.getProductAscPrice(searchedItem);
	}
	
	@RequestMapping(value="/descprice", method=RequestMethod.GET)
	public List<Product> descPrice(String searchedItem)
	{
		return sortservice.getProductDescPrice(searchedItem);
	}
	
	@RequestMapping(value="/mostlyviewd", method=RequestMethod.GET)
	public List<Product> mostlyViewed(String searchedItem)
	{
		return sortservice.getProductMostViewd(searchedItem);
	}
	@RequestMapping(value="/productrating",  method=RequestMethod.GET)
	public List<Product> topRating(String searchedItem)
	{
		return sortservice.getProductRating(searchedItem);
	}
}
