package com.capgemini.capstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	
	@Controller
	public class URIController {
		
		@RequestMapping(value="/")
		public String getHomePage()
		{
			return "merchant_home";
		}
		@RequestMapping(value="/merchant_add_product")
		public String getAddProduct()
		{
			return "merchant_add_product";
		}
		@RequestMapping(value="/merchant_change_password")
		public String getChangePassword()
		{
			return "merchant_change_password";
		}
		@RequestMapping(value="/merchant_check_order_details")
		public String getOrderDetails()
		{
			return "merchant_check_order_details";
		}
		@RequestMapping(value="/merchant_delete_product")
		public String getDeleteProduct()
		{
			return "merchant_delete_product";
		}
		@RequestMapping(value="/merchant_discounts")
		public String getDiscounts()
		{
			return "merchant_discounts";
		}
		@RequestMapping(value="/merchant_display_products")
		public String getDisplayProducts()
		{
			return "merchant_display_products";
		}
		@RequestMapping(value="/merchant_promos")
		public String getPromos()
		{
			return "merchant_promos";
		}
		@RequestMapping(value="/merchant_update_product")
		public String getUpdateProduct()
		{
			return "merchant_update_product";
		}
}
