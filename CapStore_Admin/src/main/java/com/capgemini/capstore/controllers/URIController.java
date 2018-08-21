package com.capgemini.capstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URIController {
	@RequestMapping(value="/")
	public String getHomePage()
	{
		return "admin_home";
		
	}
	@RequestMapping(value="/admin_add_category")
	public String getaddCategoryPage()
	{
		return "admin_add_category";
		
	}
	@RequestMapping(value="/admin_add_merchant")
	public String getaddMerchantPage()
	{
		return "admin_add_merchant";
		
	}
	@RequestMapping(value="/admin_all_customers")
	public String getCustomersPage()
	{
		return "admin_all_customers";
		
	}
	@RequestMapping(value="/admin_all_merchants")
	public String getMerchantPage()
	{
		return "admin_all_merchants";
		
	}
	
	@RequestMapping(value="/admin_all_products")
	public String getProductPage()
	{
		return "admin_all_products";
		
	}
	@RequestMapping(value="/admin_delete_category")
	public String getDeleteCategory()
	{
		return "admin_delete_category";
		
	}
	@RequestMapping(value="/admin_delete_merchant")
	public String getdeleteMerchantPage()
	{
		return "admin_delete_merchant";
		
	}
	@RequestMapping(value="/admin_order_confirmed")
	public String getOrderConfirmationPage()
	{
		return "admin_order_confirmed";
		
	}
	@RequestMapping(value="/admin_order_deliver")
	public String getOrderDeliverPage()
	{
		return "admin_order_deliver";
		
	}
	@RequestMapping(value="/admin_order_returned")
	public String getOrderReturPage()
	{
		return "admin_order_returned";
		
	}
	@RequestMapping(value="/admin_remove_products")
	public String getRemoveProductPage()
	{
		return "admin_remove_products";
		
	}
	
	

}
