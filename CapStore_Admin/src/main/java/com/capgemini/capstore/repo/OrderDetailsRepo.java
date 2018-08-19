package com.capgemini.capstore.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.capstore.beans.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {
	@Query("select o from OrderDetails o where o.deliveryStatus='Returned'")
	List<OrderDetails> viewReturnedProduct();
	@Query("select o.orderId,o.product,o.customer,o.deliveryDate,o.orderDate,o.orderAmount from OrderDetails o where o.orderId=?1")
	OrderDetails getOrderDetails(int orderId);
	@Modifying
    @Transactional
    @Query("update OrderDetails o set o.deliveryStatus='Refunded' where o.orderId=:id")
	void updateDeliveryStatus(@Param("id")int orderId);
}
