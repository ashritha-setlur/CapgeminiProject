package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.capstore.beans.OrderDetails;
@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Integer>
{
  @Query(value="select o from OrderDetails o where o.id=?1")
  public OrderDetails deliveringProducts(int orderId);

}
