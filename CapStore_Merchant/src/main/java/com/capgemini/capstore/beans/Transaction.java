package com.capgemini.capstore.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@OneToOne(cascade=CascadeType.ALL)
	private PaymentMethod paymentMethod;
	private Date transDate;
	@OneToOne(mappedBy="transaction")
	private OrderDetails order;

	//Constructors
	public Transaction(int transactionId, PaymentMethod paymentMethod, Date transDate, OrderDetails order) {
		super();
		this.transactionId = transactionId;
		this.paymentMethod = paymentMethod;
		this.transDate = transDate;
		this.order = order;
	}

	public Transaction(int transactionId) {
		super();
		this.transactionId = transactionId;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}


}
