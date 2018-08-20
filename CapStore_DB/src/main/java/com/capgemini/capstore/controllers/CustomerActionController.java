package com.capgemini.capstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.beans.Address;
import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.services.CustomerServices;

@RestController
public class CustomerActionController {

	@Autowired
	private CustomerServices customerServices;

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
		Feedback feedback=customerServices.addFeedback(feedbackObj);
		return feedback;
	}

	//to get product feedback
	@RequestMapping(value="/getFeedback",method=RequestMethod.POST)
	public List<Feedback> getFeedback(@RequestBody String pid) throws JSONException
	{
		JSONObject json=new JSONObject(pid);
		List<Feedback> feedbacks=customerServices.getFeedbacks(json.getInt("pid"));
		return feedbacks;

	}

	//add cart to customer object (only once)
	//  (http://localhost:4496/addCart?custId=1)
	@RequestMapping(value="/addCart",produces=MediaType.APPLICATION_JSON_VALUE)
	public void addCartToCustomer(int custId) {
		customerServices.addCart(custId);
	}

	//add product into the cart
	//  (http://localhost:4496/addToCart?prodId=1&custId=1)
	@RequestMapping(value="/addToCart",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addToCart(int prodId,int custId) {
		customerServices.addProductToCart(prodId,custId);
	}

	//remove product from the cart
	//  (http://localhost:4496/removeFromCart?prodId=1&custId=1)
	@RequestMapping(value="/removeFromCart",produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeFromCart(@RequestParam("prodId")int prodId,@RequestParam("custId")int custId) {
		customerServices.removeProductFromCart(prodId, custId) ;
	}
	//view all the products from the cart
	//  (http://localhost:4496/ViewCart?cartId=1)
	@RequestMapping(value="/ViewCart",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> viewCart(@RequestParam("cartId")int cartId) {
		return customerServices .viewCart(cartId) ;
	}

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
	//For Post Man
	/*@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
		public void updateCustomer(Customer customer,Principal principal)
		{
			mservices.updateCustomer(customer);
		}*/
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
	// Sorting the products based on given range

	@RequestMapping(value="/range", method=RequestMethod.GET)
	public List<Product> range(String searchedItem){		
		return customerServices.getProductInRange(searchedItem);
	}
    // Sorting the products in ascending order based on their price
	@RequestMapping(value="/ascprice", method=RequestMethod.GET)
	public List<Product> ascPrice(String searchedItem){
		return customerServices.getProductAscPrice(searchedItem);
	}
    //Sorting the products in descending order based on their price
	@RequestMapping(value="/descprice", method=RequestMethod.GET)
	public List<Product> descPrice(String searchedItem){
		return customerServices.getProductDescPrice(searchedItem);
	}
    // Sorting the products in descending order based on their views so that mostly viewed products come first
	@RequestMapping(value="/mostlyviewd", method=RequestMethod.GET)
	public List<Product> mostlyViewed(String searchedItem){
		return customerServices.getProductMostViewd(searchedItem);
	}
	//Sorting the products in descending order based on their ratings so that products with high rating comes first
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
	//Search for Products(by product name,product brand and category name)
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

	//controller to test through postman to generate invoice
	@RequestMapping(value="/getInvoice", method=RequestMethod.GET)
	public int getInvoice(int customerId,int productId, int orderAmount,int transactionId) {
		return customerServices.generateInvoice(customerId, productId, orderAmount,transactionId);	
	}
	
	//controller to call generate invoice
	@RequestMapping(value="/getInvoice/{customerId,productId,orderAmount,transactionId}", method=RequestMethod.GET)
	public int generateInvoice(@Param("customerId") int customerId, @Param("productId")int productId, @Param("orderAmount") int orderAmount,@Param("transactionId")int transactionId) {
		return customerServices.generateInvoice(customerId, productId, orderAmount,transactionId);	
	}
	
	//controller to test through postman to get transaction number
	@RequestMapping(value="/gettrans", method=RequestMethod.GET)
	public int gettransaction( int method) {
		return  customerServices.savetransaction(method);
	}
	
	
	//controller to call transaction number
	@RequestMapping(value="/gettrans/{method}", method=RequestMethod.GET)
	public int generatetransaction(@Param(value="method") int method) {
		return  customerServices.savetransaction(method);
	}
	
	
	//controller to call update CapStore_Revenue
	@RequestMapping(value="/gettrans/{amount,productId}", method=RequestMethod.GET)
	public boolean updateCapRevenue(@Param(value="amount") double amount,@Param(value="productId") int productId) {
		return  customerServices.updateCapRevenue(amount,productId);
	}
	
	
}
