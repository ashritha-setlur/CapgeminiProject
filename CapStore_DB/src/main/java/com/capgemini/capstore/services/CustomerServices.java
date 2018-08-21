package com.capgemini.capstore.services;

import java.util.List;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.beans.Wishlist;

public interface CustomerServices {

	public Feedback addFeedback(Feedback feedBack);
	public List<String> getFeedbacks(int id);
	public void addCart(int custId) ;
	public Product addProductToCart(int prodId,int custId) ;
	public Product removeProductFromCart(int prodId,int custId) ;
	public List<Product> viewCart(int cartId) ;
	public String getDeliveryStatus(int orderId);
	public void updateCustomer(Customer customer); 
	public Wishlist display (int custid);
	public List<OrderDetails> displayCustomerOrderedItems(int id);
	public List<Product> getProductInRange(String searchedItem);
	public List<Product> getProductAscPrice(String searchedItem);
	public List<Product> getProductDescPrice(String searchedItem);
	public List<Product> getProductMostViewd(String searchedItem);
	public List<Product> getProductRating(String searchedItem);
	public boolean placeOrder(int custId,int cartId,int prodId) ;
	public Rating addRating(Rating rating);
	public Customer registerCustomer(Customer customer, Authentication passwrd);
	public List<Product> searchByProductBrand(String product);
	public List<Product> searchByProductName(String product);
	public Customer retrieveShipmentDetails(int customerId);
	public void applyCoupon( int orderid,String promoName);
	public Cart applyDiscount(int cartId);
	public int saveTransaction(int paymentMethod);
	public Product getProduct(int productId);
}
