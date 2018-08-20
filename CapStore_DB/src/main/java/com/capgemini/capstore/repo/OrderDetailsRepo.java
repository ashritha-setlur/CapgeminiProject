package com.capgemini.capstore.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.capstore.beans.Customer;
import com.capgemini.capstore.beans.OrderDetails;
import com.capgemini.capstore.beans.Product;
import com.capgemini.capstore.beans.Transaction;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer>, CrudRepository<OrderDetails, Integer> {

	@Query("select c from Customer c where c.id=?1")
	public Customer findCustomerByCustomerId(int customerId);
	@Query("select p from Product p where p.productId=?1")
	public Product findProductByProductId(int productId);
	@Query("select t from Transaction t where t.transactionId=?1")
	public Transaction findtransactionBytransactionId(int transactionId);
	@Query("select o from OrderDetails o where o.customer.id=?1")
	public List<OrderDetails> findByCustomerId(int id);
	@Query("select o.deliveryStatus from OrderDetails o where o.orderId=?1")
	public void orderStatus(int orderId);
	@Query("select o from OrderDetails o where o.orderId = ?1")
	public OrderDetails findOrderByOrderId(int orderId);
	@Query("select o from OrderDetails o where o.deliveryStatus='Returned'")
	List<OrderDetails> viewReturnedProduct();
	@Query("select o.orderId,o.product,o.customer,o.deliveryDate,o.orderDate,o.orderAmount from OrderDetails o where o.orderId=?1")
	OrderDetails getOrderDetails(int orderId);
	@Modifying
	@Transactional
	@Query("update OrderDetails o set o.deliveryStatus='Refunded' where o.orderId=:id")
	void updateDeliveryStatus(@Param("id")int orderId);
	@Query(value="select o from OrderDetails o where o.id=?1")
	public OrderDetails deliveringProducts(int orderId);
}
