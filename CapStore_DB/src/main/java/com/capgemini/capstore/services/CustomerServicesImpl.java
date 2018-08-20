package com.capgemini.capstore.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Cart;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.beans.Rating;
import com.capgemini.capstore.beans.Transaction;
import com.capgemini.capstore.beans.Wishlist;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.CartRepo;
import com.capgemini.capstore.repo.CouponsRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.DiscountDAO;
import com.capgemini.capstore.repo.FeedbackRepo;
import com.capgemini.capstore.repo.OrderDAO;
import com.capgemini.capstore.repo.OrderDetailsRepo;
import com.capgemini.capstore.repo.ProductRepo;
import com.capgemini.capstore.repo.RatingRepo;
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
	 CouponsRepo couponsdao;
	
	@Autowired
	OrderDAO orderdao;
	
	@Autowired
	 DiscountDAO discountDAO;

	private static int orderId=100;

	@Override
	public Feedback addFeedback(Feedback feedBack) {
		feedbackRepo.save(feedBack);
		return feedBack;
	}

	@Override
	public List<String> getFeedbacks(int pid) {
		List<String> product_feedback_list = feedbackRepo.getFeedbackList(pid);
		
		return  product_feedback_list ;
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



	public int generateInvoice(int customerId, int productId, int orderAmount,int transactionId)
	{
		Product product=orderDetailsRepo.findProductByProductId(productId);
		Customer customer=orderDetailsRepo.findCustomerByCustomerId(customerId);
		@SuppressWarnings("unused")
		Transaction trans=orderDetailsRepo.findtransactionBytransactionId(transactionId);
		OrderDetails order=new OrderDetails();
		order.setOrderId(orderId++);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setDeliveryStatus("confirmed");
		@SuppressWarnings("unused")
		long millis=System.currentTimeMillis();
		java.sql.Date orderDate = new java.sql.Date(new java.util.Date().getTime());
		order.setDeliveryDate(orderDate);
		java.sql.Date deliveryDate = this.addDays(orderDate, 5);
		order.setDeliveryDate(deliveryDate);
		orderDetailsRepo.save(order);
		return orderId++;	
	}

	private Date addDays(Date orderDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(orderDate);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
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
	
	@Override
	public double coupon( int orderid,String promoName) {
		Promo promo = couponsdao.findBypromoId(promoName);
		OrderDetails order= orderdao.getOrderDetails(orderid);
		if(promo!=null)
		{
			LocalDate localdate = LocalDate.now();
			Date date1= Date.valueOf(localdate);
			if(promo.getStartDate().before(date1)&&promo.getEndDate().after(date1)&&order.getOrderAmount()>promo.getPromoQuantity())
			{
				order.setOrderAmount(order.getOrderAmount()-promo.getPromoQuantity());
				
				orderdao.save(order);
				System.out.println("promo added sucessfully");
			}
		}
		else
		{
			System.out.println("Invalid code");
		}
		return 0;
	}
	
	

	@Override
	public Cart discount(int cartId) {
		Cart products= discountDAO.findByDiscountId(cartId);
		System.out.println(products);
		List<Product> productlist= products.getProducts();
		for(Product product:productlist)
		{
			String discount = product.getProductDiscount().getDiscountDesc();
			int discount1= Integer.parseInt(discount);
			float discountprice = (float) (0.01*discount1);
   		double price =  product.getProductPrice();
   		String finalprice= Double.toString(price-(price*discountprice));
   		product.getProductDiscount().setDiscountDesc(finalprice);
		}

		discountDAO.save(products);
		return products;
	}
	
}

