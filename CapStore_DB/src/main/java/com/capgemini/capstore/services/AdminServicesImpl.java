package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.repo.AdminRepo;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.CustomerRepo;
import com.capgemini.capstore.repo.DiscountRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderDetailsRepo;
import com.capgemini.capstore.repo.ProductRepo;
import com.capgemini.capstore.repo.PromoRepo;
import com.capgemini.capstore.repo.RatingRepo;

@Component(value="adminService")
public class AdminServicesImpl implements AdminServices {

	Map<Integer,Double> merchant_Avg_list = new HashMap<Integer, Double>();
	Map<Integer,Double> product_Avg_list = new HashMap<Integer, Double>();

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private MerchantRepo merchantRepo ;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AuthenticationRepo aRepo;
	@Autowired
	private RatingRepo ratingRepo;
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Autowired
	private DiscountRepo discountRepo;
	@Autowired
	private PromoRepo promoRepo;


	//Method to add Merchant Details
	@Override
	public int addMerchant(Merchant merchant) {
		merchantRepo.save(merchant);
		return  merchant.getMerchantId();
	}

	//Method to get Single Merchant Details
	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = merchantRepo.getOne(merchantId);
		return merchant;
	}

	//Method to display the customer details
	@Override
	public  List<Customer> displayAllCustomers() {
		return customerRepo.findAll();	
	}

	//Method to display the Merchant details
	@Override
	public List<Merchant> displayAllMerchants() {
		return merchantRepo.findAll();
	}

	//Method to display the product details
	@Override
	public List<Product> displayAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public void setMinOrderAmount(double amount) {
		adminRepo.setMinOrderAmount(amount) ;
	}

	@Override
	public void addThirdPartyMerchant(int merchantId)  {
		aRepo.saveThirdPartyMerchant(merchantId);
	}

	@Override
	public void rejectThirdPartyMerchant(int merchantId) {
		aRepo.rejectThirdPartyMerchant(merchantId);
	}


	@Override
	public void deleteThirdPartyMerchant(int merchantId) {
		merchantRepo.deleteById(merchantId);
		aRepo.deleteById(merchantId);
	}

	@Override
	public List<Merchant> viewThirdPartyMerchantRequest() {
		return merchantRepo.getRequestedThirdPartyMerchant();
	}

	@Override
	public List<Merchant> viewThirdPartyMerchant() {
		return merchantRepo.getThirdPartyMerchant();
	}

	//Returns the average rating of a merchant
	@Override
	public double setAvgRatingOfMerchant(int mId) {
		List<Product> id = ratingRepo.getProductListforMerchant(mId);
		System.out.println("List ids are:"+id);
		List<Integer> product_id_list = new ArrayList<Integer>();
		Iterator<Product> it = id.iterator();
		while(it.hasNext()) {
			int i=it.next().getProductId();
			product_id_list.add(i);
		}
		double sum = 0;
		for (int i : product_id_list) {
			double avgRating = setAvgRatingOfProduct(i);
			product_Avg_list.put(i, avgRating);
			sum = sum + avgRating;
		}
		double avgRating = sum / product_id_list.size();
		return avgRating;
	}
	//Returns the average rating of a product
	@Override
	public double setAvgRatingOfProduct(int pId) {

		List<Double> product_rating_list = ratingRepo.getRatingList(pId);
		Double sum=0.0;
		for (Double i : product_rating_list) {	
			sum+=i;
		}
		Double avgRating = sum / product_rating_list.size();
		return avgRating;
	}

	//Returns a list which contains average rating of all the products of a merchant
	public Map<Integer, Double> AvgOfProducts_List(int mId) {
		List<Product> id = ratingRepo.getProductListforMerchant(mId);
		List<Integer> product_id_list = new ArrayList<Integer>();
		Iterator<Product> it = id.iterator();
		while(it.hasNext()) {
			int i=it.next().getProductId();
			product_id_list.add(i);
		}
		for (int i : product_id_list) {
			double avgRating = setAvgRatingOfProduct(i);
			product_Avg_list.put(i, avgRating);
		}
		return product_Avg_list;
	}

	@Override
	public int addDiscount(Discount discount) {
		discountRepo.save(discount);
		return discount.getDiscountId();
	}
	@Override
	public List<Discount> displayAllDiscounts() {
		return discountRepo.findAll();
	}
	@Override
	public void deleteDiscount(int discountId) {
		discountRepo.deleteById(discountId);
	}
	@Override
	public int addPromo(Promo promo) {
		promoRepo.save(promo);
		return promo.getPromoId();
	}
	@Override
	public List<Promo> displayAllPromos() {
		return promoRepo.findAll();
	}
	@Override
	public void deletePromo(int promoId) {
		promoRepo.deleteById(promoId);	
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
}

