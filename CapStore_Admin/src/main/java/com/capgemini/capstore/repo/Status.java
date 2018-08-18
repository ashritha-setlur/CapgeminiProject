package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.OrderDetails;


@Repository
public interface Status extends JpaRepository<OrderDetails,Integer>, CrudRepository<OrderDetails,Integer>
{
	/*@Query("select orderId from OrderDetails")
	public int getId(int orderId);*/
	
	@Query("select o.deliveryStatus from OrderDetails o where o.orderId=?1")
	public void orderStatus(int orderId);
	
	@Query("select o from OrderDetails o where o.orderId = ?1")
	public OrderDetails findOrderByOrderId(int orderId);
}
