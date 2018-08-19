package com.capgemini.capstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.repo.ShipmentRepo;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepo repo;
	
	public ShipmentServiceImpl(ShipmentRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Customer retrieveShipmentDetails(int customerId) {
		//Service layer function which retrieves the details of customer
		return repo.getShipmentDetails(customerId);		
	}

}
