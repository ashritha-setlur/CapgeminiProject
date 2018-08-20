package com.capgemini.capstore.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.PaymentMethod;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.beans.Transaction;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.repo.AdminRepo;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.CartRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.FeedbackRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderDetailsRepo;
import com.capgemini.capstore.repo.ProductRepo;
import com.capgemini.capstore.repo.RatingRepo;
import com.capgemini.capstore.repo.TransactionRepo;
import com.capgemini.capstore.repo.WishlistRepo;

@Component(value="customerService")
public class CustomerServicesImpl implements CustomerServices {

	@Autowired
	FeedbackRepo feedbackRepo;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	private CartRepo cartRepo ;

	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Autowired
	private WishlistRepo wishlistRepo;

	@Autowired
	private RatingRepo ratingRepo;

	@Autowired
	private AuthenticationRepo aRepo;

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private MerchantRepo merchantRepo ;
	
    @Autowired
    TransactionRepo transactionrepo;
	
	private static int orderId1=100;

	@Override
	public Feedback addFeedback(Feedback feedBack) {
		feedbackRepo.save(feedBack);
		return feedBack;
	}

	@Override
	public List<Feedback> getFeedbacks(int pid) {
		List<Feedback> f=new ArrayList<>();
		f.add(feedbackRepo.getFeedbacksForProduct(pid));
		return f;
	}

	//add a cart to customer object
	@Override
	public void addCart(int custId) {
		Customer customer = customerRepo.getOne(custId);
		Cart cart = new Cart() ;
		cartRepo.save(cart) ;
		customer.setCart(cartRepo.getOne(cart.getCartId()));
		customerRepo.save(customer) ;
	}

	//add a product to the cart
	@Override
	public Product addProductToCart(int prodId, int custId) {
		Product product = productRepo.getOne(prodId) ;
		Customer customer = customerRepo.getOne(custId) ;
		Cart cart = cartRepo.getOne(customer.getCart().getCartId()) ;
		List<Product> products = cart.getProducts() ;
		products.add(product) ;
		cart.setProducts(products);
		cart.setQuantity(cart.getQuantity()+1);
		cartRepo.save(cart) ;
		return product ;
	}
	//remove a product from the cart
	@Override
	public Product removeProductFromCart(int prodId, int custId) {
		Product product = productRepo.getOne(prodId) ;
		Customer customer = customerRepo.getOne(custId) ;
		Cart cart = cartRepo.getOne(customer.getCart().getCartId()) ;
		List<Product> products = cart.getProducts() ;
		products.remove(product);
		cart.setProducts(products);
		cart.setQuantity(cart.getQuantity()-1);
		cartRepo.save(cart) ;
		return product ;
	}

	//display all the products from the cart
	@Override
	public List<Product> viewCart(int cartId) {
		return cartRepo.getOne(cartId).getProducts() ;
	}


	//returns invoice number and saves all the order_details information
	public int generateInvoice(int customerId, int productId, int orderAmount,int transactionId)
	{
		int orderId=orderId1++;
		Product product=orderDetailsRepo.findProductByProductId(productId);
		Customer customer=orderDetailsRepo.findCustomerByCustomerId(customerId);
		Transaction transaction=orderDetailsRepo.findtransactionBytransactionId(transactionId);
		OrderDetails order=new OrderDetails();
		order.setOrderId(orderId);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setTransaction(transaction);
		order.setDeliveryStatus("confirmed");
		order.setOrderAmount(orderAmount);
		java.sql.Date orderDate = new java.sql.Date(new java.util.Date().getTime());
		order.setOrderDate(orderDate);
		java.sql.Date deliveryDate = this.addDays(orderDate, 5);
		order.setDeliveryDate(deliveryDate);
		orderDetailsRepo.save(order);
		return orderId;	
	}
	//method to save sql date required for generate invoice method
	private Date addDays(Date orderDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(orderDate);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
	}

	//updating revenue of capstore and merchant
	public boolean updateCapRevenue(double amount, int productId)
	{
		Product product=orderDetailsRepo.findProductByProductId(productId);
		Merchant merchant=product.getProductMerchant();
		double totalPrice=product.getProductPrice();
		double percent=merchant.getMerchantRevPercent();
		double capstoreShare=(percent/100)*totalPrice;
		double merchantShare=totalPrice-capstoreShare;
		adminRepo.addCapstoreRevenue(capstoreShare);
		merchantRepo.addMerchantRevenue(merchant.getMerchantId(),merchant.getMerchantRevenue()+merchantShare);
		return true;	
	}
	
	//returns transaction number to calling method
	public int savetransaction(int paymentMethod)
	{
		Transaction transaction = new Transaction();
		java.sql.Date transDate = new java.sql.Date(new java.util.Date().getTime());
		transaction.setTransDate(transDate);
		if(paymentMethod==1)
		{
			transaction.setPaymentMethod(new PaymentMethod(1,0));
		}else
		{
			transaction.setPaymentMethod(new PaymentMethod(0,1));
		}
		
		transactionrepo.save(transaction);
		
		System.out.println(transaction.getTransactionId());
		return transaction.getTransactionId();		
	}
	
	//OrderedItemsDisplay
	@Override
	public List<OrderDetails> displayCustomerOrderedItems(int id) {
		List<OrderDetails> listOfproducts = orderDetailsRepo.findByCustomerId(id);
		return listOfproducts;
	}

	//wishlist display
	@Override
	public Wishlist display(int custid) {
		Customer customer = customerRepo.getOne(custid);
		return wishlistRepo.getOne(customer.getWishlist().getWishlistId());
	}

	//status delivery
	@Override
	public String getDeliveryStatus(int orderId) {
		OrderDetails oDetails = orderDetailsRepo.getOne(orderId);
		String status = oDetails.getDeliveryStatus();
		return status;
	}
	//update his profile information
	@Override
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}
    //sorting products
	@Override
	public List<Product> getProductInRange(String searchedItem) {
		List<Product> result = productRepo.getProductsWithinRange(searchedItem);
		if(result==null)
		{
			System.out.println("products are unavaliable between the price 100 and 1000");
		}
		return result;
		//return dao.getProductsWithinRange(searchedItem);
	}
	@Override
	public List<Product> getProductAscPrice(String searchedItem) {

		return productRepo.getProductAscPrice(searchedItem);
	}
	@Override
	public List<Product> getProductDescPrice(String searchedItem) {

		return productRepo.getProductDescPrice(searchedItem);
	}
	@Override
	public List<Product> getProductMostViewd(String searchedItem) {

		return productRepo.getProductMostlyViewed(searchedItem);
	}
	@Override
	public List<Product> getProductRating(String searchedItem) {

		return productRepo.getBestProducts(searchedItem);
	}
    //delivery status
	@Override
	public void orderStatus(int orderId, int num){
		if(num==1){
			OrderDetails order1 =orderDetailsRepo.findOrderByOrderId(orderId);
			order1.setDeliveryStatus("Delivered");
			orderDetailsRepo.save(order1);
			System.out.println("delivered");
		}
		else if(num==2){
			OrderDetails order1 =orderDetailsRepo.findOrderByOrderId(orderId);
			order1.setDeliveryStatus("Returned");
			orderDetailsRepo.save(order1);
			System.out.println("returned");
		}
	}
	//placing order
	@Override
	public boolean placeOrder(int custId, int cartId, int prodId) {

		Customer customer=customerRepo.getOne(custId);
		Cart cart= cartRepo.getOne(customer.getCart().getCartId());
		Product product=productRepo.getOne(prodId);
		if(product.getProductQuantity()>=cart.getQuantity())
			return true;
		else			
			return false;
	}

	@Override
	public Rating addRating(Rating rating) {
		ratingRepo.save(rating);
		return null;

	}
	@Override
	public Customer registerCustomer(Customer customer,Authentication passwrd) {

		Customer customer1;
		customerRepo.save(customer);
		customer1=customerRepo.getCustomerId(customer.getMobileNo());
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password=passwrd.getPassword();
		Authentication auth=new Authentication(customer1.getId(),customer1.getMobileNo(),password,"USER_CUSTOMER",2);
		aRepo.save(auth);
		return customer;
	}

	//Searching product by Brand
	@Override
	public ArrayList<Product> searchByProductBrand(String product) {
		ArrayList<Product> product1=new ArrayList<Product>();
		product1=productRepo.findProductBrand(product);
		if(product1==null)
		{
			product1=searchByProductName(product);
		}
		return product1;
	}

	//Searching product by Name
	@Override
	public ArrayList<Product> searchByProductName(String product)  {
		ArrayList<Product> product1=new ArrayList<Product>();
		product1=productRepo.findProductName(product);
		return product1;
	}
	@Override
	public Customer retrieveShipmentDetails(int customerId) {
		//Service layer function which retrieves the details of customer
		return customerRepo.getShipmentDetails(customerId);		
	}
}

