package com.capgemini.capstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.services.CustomerServices;

@Controller
@RestController
public class CustomerActionController {

	@Autowired
	private CustomerServices customerServices;

	//getting delivery status
	@RequestMapping(value="/getDeliveryStatus", method=RequestMethod.GET)
	public String getDeliveryStatus(int orderId) {
		return customerServices.getDeliveryStatus(orderId);
	}
	//customer can update his profile
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public void updateCustomer(@RequestBody Customer customer)
	{
		customerServices.updateCustomer(customer);
	}

	//customer can display his wishlist
	@RequestMapping(value="/display" , method=RequestMethod.GET)
	public Wishlist display (int custid) {
		return customerServices.display(custid);
	}

	// customer can display customer ordered items
	@RequestMapping(value="/displayCustomerOrderedItems", method=RequestMethod.GET)
	public List<OrderDetails> displayCustomerOrderedItems(int id){
		return customerServices.displayCustomerOrderedItems(id);
	}

	@RequestMapping(value="/range", method=RequestMethod.GET)
	public List<Product> range(String searchedItem){		
		return customerServices.getProductInRange(searchedItem);
	}

	@RequestMapping(value="/ascprice", method=RequestMethod.GET)
	public List<Product> ascPrice(String searchedItem){
		return customerServices.getProductAscPrice(searchedItem);
	}

	@RequestMapping(value="/descprice", method=RequestMethod.GET)
	public List<Product> descPrice(String searchedItem){
		return customerServices.getProductDescPrice(searchedItem);
	}

	@RequestMapping(value="/mostlyviewd", method=RequestMethod.GET)
	public List<Product> mostlyViewed(String searchedItem){
		return customerServices.getProductMostViewd(searchedItem);
	}
	@RequestMapping(value="/productrating",  method=RequestMethod.GET)
	public List<Product> topRating(String searchedItem){		
		return customerServices.getProductRating(searchedItem);
	}
	@RequestMapping(value="/deliveryStatus",method=RequestMethod.GET)
	public void orderStatus(int orderId,int num){
		customerServices.orderStatus(orderId,num);
	}
	@RequestMapping(value="/Order",method=RequestMethod.GET)
	public boolean placeOrder(int custId, int cartId, int prodId){
		return customerServices.placeOrder(custId,cartId,prodId);
	}
	// Register Customer
	@RequestMapping(method=RequestMethod.POST,value={"/customerRegister"},produces=MediaType.APPLICATION_JSON_VALUE)
	public String registerAction(@RequestBody String json) throws JSONException {
		Customer customerObj=new Customer();
		Authentication auth=new Authentication();
		JSONObject jSon=new JSONObject(json);
		customerObj.setFirstName(jSon.getString("firstName"));
		customerObj.setLastName(jSon.getString("lastName"));
		customerObj.setGender(jSon.getString("gender"));
		customerObj.setEmail(jSon.getString("customerEmail"));
		customerObj.setMobileNo(jSon.getString("mobileNo"));
		long pinCode=jSon.getInt("pincode");
		customerObj.setAddress(new Address(jSon.getString("addressline1"),jSon.getString("addressline2"),jSon.getString("city"),jSon.getString("state"),pinCode,jSon.getString("country")));
		customerServices.registerCustomer(customerObj,auth);
		return "success";
	}

	//Search for Products(by product name,product brand)
	@RequestMapping(method=RequestMethod.POST, value={"/searchAction"},produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Product> search(@RequestBody String jSon) throws JSONException{
		JSONObject json=new JSONObject(jSon);
		ArrayList<Product> productObj=new ArrayList<Product>(); 
		productObj=customerServices.searchByProductBrand(json.getString("key"));
		return productObj;
	}

	@RequestMapping(value="/getShipmentDetails")
	public Customer getDetails(int customerId) {		
		return customerServices.retrieveShipmentDetails(customerId);		 
	}

	@RequestMapping(value="/validatePromo" ,method=RequestMethod.GET)
	public void promovalidate(int orderId, String promo){
		customerServices.applyCoupon(orderId,promo);
	}

	
	
	//controller to test through postman to generate invoice
	@RequestMapping(value="/getInvoice", method=RequestMethod.GET)
	public int getInvoice(int customerId,int productId, int orderAmount,int transactionId,int promoId) {
		return customerServices.generateInvoice(customerId, productId, orderAmount,transactionId,promoId);	
	}
	
	//controller to call generate invoice
	@RequestMapping(value="/getInvoice/{customerId,productId,orderAmount,transactionId}", method=RequestMethod.GET)
	public int generateInvoice(@Param("customerId") int customerId, @Param("productId")int productId, @Param("orderAmount") int orderAmount,@Param("promoId")int transactionId,@Param("transactionId")int promoId) {
		return customerServices.generateInvoice(customerId, productId, orderAmount,transactionId,promoId);	
	}
	
	@RequestMapping(value="/applydiscount", method=RequestMethod.GET)
	public Cart applydiscount(int cartId){
		return customerServices.applyDiscount(cartId);
	}
}
