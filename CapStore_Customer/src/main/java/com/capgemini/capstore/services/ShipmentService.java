package com.capgemini.capstore.services;

import com.capgemini.capstore.beans.Customer;

public interface ShipmentService {
	public Customer retrieveShipmentDetails(int customerId);
}
