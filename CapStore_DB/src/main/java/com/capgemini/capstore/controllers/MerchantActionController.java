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

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Category;
import com.capgemini.capstore.beans.Image;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
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
	//add product
	@RequestMapping(value = "/addproduct")
	public void addproduct(@RequestBody String json) throws JSONException {
		JSONObject jSon=new JSONObject(json); 
		Product products=new Product();
		products.setProductName(jSon.getString("productName"));
		products.setProductDesc(jSon.getString("productDesc"));
		products.setProductSize(jSon.getInt("productSize"));
		products.setProductQuantity(jSon.getInt("productQuantity"));
		products.setProductPrice(jSon.getDouble("productPrice"));
		Image image=new Image();
		image.setImageUrl(jSon.getString("imageUrl"));
		products.setProductImage(image);
		products.setProductBrand(jSon.getString("productBrand"));
		products.setProductViews(jSon.getInt("productViews"));
		int merchantId=jSon.getInt("merchantId");
		Category category=new Category();
		category.setGroupCategoryId(jSon.getInt("groupCategoryId"));
		category.setCategoryName(jSon.getString("categoryName"));
		category.setCategoryDesc(jSon.getString("categoryDesc"));
		category.setProduct(products);
		products.setProductCategory(category);
		long time = System.currentTimeMillis();
		java.sql.Date productAddDate = new java.sql.Date(time);
		products.setProductAddDate(productAddDate);
		merchantService.addProduct(products,merchantId);

	}
	
	//remove product
	@RequestMapping(value = "/removeproduct")
	public void removeproduct(int productId) {
		merchantService.removeProduct(productId);
	}
	
	//display products of particular merchant inventory
	@RequestMapping(value = "/displayMerchantProducts")
	public List<Product> displayinventory(int merchantId) {
		List<Product> products=merchantService.displayMerchantProducts(merchantId);
		return products;

	}
	//display orders of particular merchant inventory
	@RequestMapping(value = "/checkMerchantInventoryOrders")
	public List<OrderDetails> checkMerchantInventoryOrders(int merchantId) {
		List<OrderDetails> orders=merchantService.checkOrderDetails(merchantId);
		return orders;

	}
}
