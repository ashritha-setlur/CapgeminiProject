package com.capgemini.capstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.capstore.beans.Feedback;
import com.capgemini.capstore.beans.Merchant;
import com.capgemini.capstore.repo.FeedbackRepo;
import com.capgemini.capstore.repo.MerchantRepo;
@Component
public class MerchantServicesImpl implements MerchantServices {

	@Autowired
	private MerchantRepo mrepo;
	@Autowired
	FeedbackRepo repo;

	@Override
	public int addMerchant(Merchant merchant) {
		 mrepo.save(merchant);
		return  merchant.getMerchantId();
	}

	@Override
	public Merchant displaySingleMerchant(int merchantId) {
		Merchant merchant = mrepo.getOne(merchantId);
		return merchant;
	}

	@Override
	public List<Merchant> displayAllMerchants() {
		return mrepo.findAll();
	}

	@Override
	public void deleteMerchant(int merchantId) {
		mrepo.deleteById(merchantId);
	}
	
	
	
	
	
	@Override
	public Feedback addFeedback(Feedback feedBack) {
		repo.save(feedBack);
		return feedBack;
	}

	@Override
	public List<Feedback> getFeedbacks(int pid) {
		List<Feedback> f=new ArrayList<>();
		f.add(repo.getFeedbacksForProduct(pid));
		return f;
	}
	

}
