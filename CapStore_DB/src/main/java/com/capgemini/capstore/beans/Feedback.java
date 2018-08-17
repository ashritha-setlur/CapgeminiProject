package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
	@OneToOne
	private Customer customer;
	private String typeOfFeedback;
	private String feedbackDesc;
	@OneToOne
	private Product product;

	//Constructors
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int feedbackId) {
		super();
		this.feedbackId = feedbackId;
	}

	public Feedback(int feedbackId, Customer customer, String typeOfFeedback, String feedbackDesc) {
		super();
		this.feedbackId = feedbackId;
		this.customer = customer;
		this.typeOfFeedback = typeOfFeedback;
		this.feedbackDesc = feedbackDesc;
	}

	//Getters and Setters
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getTypeOfFeedback() {
		return typeOfFeedback;
	}
	public void setTypeOfFeedback(String typeOfFeedback) {
		this.typeOfFeedback = typeOfFeedback;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackDesc() {
		return feedbackDesc;
	}
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}
}
