package com.capgemini.capstore.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_Details")
public class OrderDetails {

	@Id
	private int orderId;
	@OneToOne(cascade=CascadeType.ALL)
	private Product product;
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transaction")
	private Transaction transaction;
	private Date deliveryDate;
	private Date orderDate;
	private String deliveryStatus;
	@OneToOne(cascade=CascadeType.ALL)
	private Promo promo;
	private double orderAmount;

	//Constructors
	public OrderDetails(int orderId) {
		super();
		this.orderId = orderId;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int orderId, Product product, Customer customer, Transaction transaction,
			Date deliveryDate, Date orderDate, String deliveryStatus, Promo promo, double orderAmount) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.customer = customer;
		this.transaction = transaction;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate;
		this.deliveryStatus = deliveryStatus;
		this.promo = promo;
		this.orderAmount = orderAmount;
	}

	//Getters and Setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Promo getPromo() {
		return promo;
	}
	public void setPromo(Promo promo) {
		this.promo = promo;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
}
