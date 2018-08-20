package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.OrderDetails;

@Repository
public interface OrderDAO extends JpaRepository<OrderDetails, Integer>{

	@Query("Select o from OrderDetails o where o.orderId=?1")
	public OrderDetails getOrderDetails(int oid);
}
