package com.capgemini.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.repo.AdminRepo;
import com.capgemini.capstore.repo.AuthenticationRepo;
import com.capgemini.capstore.repo.MerchantRepo;
import com.capgemini.capstore.repo.OrderDetailsRepo;
@Service
public class CapStoreAdminServicesImplementation implements CapStoreAdminServices {
	@Autowired
    public MerchantRepo merchantRepo;
	@Autowired
    public AuthenticationRepo aRepo;
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
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

	@Override
	public List<OrderDetails> viewReturnedProduct() {
		return orderDetailsRepo.viewReturnedProduct();
	}

	@Override
	public List<OrderDetails> acceptReturnedProduct(int orderId) {
		Merchant m=orderDetailsRepo.getOne(orderId).getProduct().getProductMerchant();
		   double productPrice=orderDetailsRepo.getOne(orderId).getOrderAmount();
		   double merchantRevenuePercentage=m.getMerchantRevPercent();
		   double adminPrice=(merchantRevenuePercentage/100)*productPrice;
		   double merchantPrice=productPrice-adminPrice;
		   adminRepo.updateMerchantRevenue(m.getMerchantId(),merchantPrice);
		   adminRepo.updateAdminRevenue(adminPrice);
		   orderDetailsRepo.updateDeliveryStatus(orderId);
		   return viewReturnedProduct();
		
	}
}
