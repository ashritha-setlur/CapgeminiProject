package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Authentication;
import com.capgemini.capstore.beans.Discount;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Promo;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.DiscountRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderDetailsRepo;
import com.capgemini.capstore.repo.PromoRepo;

@Component(value="merchantService")
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private AuthenticationRepo aRepo;
	@Autowired
	private MerchantRepo merchantRepo;
	@Autowired
	private DiscountRepo discountRepo;
	@Autowired
	private PromoRepo promoRepo;
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	@Override
	//Register Merchant
	public Merchant registerMerchant(Merchant merchant, String password, String type) {
		Merchant merchant1;

		merchantRepo.save(merchant);

		merchant1=merchantRepo.getMerchantId(merchant.getMobileNo());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Authentication auth=new Authentication(merchant1.getMerchantId(),merchant1.getMobileNo(),encoder.encode(password),"USER_MERCHANT",2);
		if(type.equals("direct"))
			auth.setUserAccess("USER_DIRECTMERCHANT");
		else
			auth.setUserAccess("USER_THIRDPARTYMERCHANT");
		aRepo.save(auth);
		return merchant;
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

	@Override
	public OrderDetails deliveringProducts(int orderId) {
		OrderDetails orderDetails=orderDetailsRepo.deliveringProducts(orderId);
		if(orderDetails!=null) {
			Merchant merchant = merchantRepo.getOne(orderDetails.getProduct().getProductMerchant().getMerchantId());
			List<Product> products = merchant.getMerchantInventory().getProducts();
			int index = products.indexOf(orderDetails.getProduct());
			products.get(index).setProductQuantity(products.get(index).getProductQuantity()-1);
			orderDetails.setDeliveryStatus("Dispatched");
		}
		orderDetailsRepo.save(orderDetails);
		return orderDetails;
	}
}
