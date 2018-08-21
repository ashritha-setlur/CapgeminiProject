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
@Table(name="Merchant_Details")
public class Merchant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int merchantId;
	private String merchantName;
	private String merchantEmail;
	private String mobileNo;
	@OneToOne(cascade=CascadeType.ALL)
	private Address merchantAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Inventory merchantInventory;
	private double merchantRevPercent;
	private Date dateOfReg;
	private Date dateOfDel;
	private double merchantRevenue;	

	//Constructors

	public Merchant(int merchantId) {
		super();
		this.merchantId = merchantId;
	}
	public Merchant(int merchantId, String merchantName, String merchantEmail, String mobileNo, Address merchantAddress,
			Inventory merchantInventory, double merchantRevPercent, Date dateOfReg, Date dateOfDel, 	double merchantRevenue) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.merchantEmail = merchantEmail;
		this.mobileNo = mobileNo;
		this.merchantAddress = merchantAddress;
		this.merchantInventory = merchantInventory;
		this.merchantRevPercent = merchantRevPercent;
		this.dateOfReg = dateOfReg;
		this.dateOfDel = dateOfDel;

		this.merchantRevenue = merchantRevenue;
	}
	public Merchant() {
		super();
	}
	//Getters and Setters
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merhantName) {
		this.merchantName = merhantName;
	}
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Address getMerchantAddress() {
		return merchantAddress;
	}
	public void setMerchantAddress(Address merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	public Inventory getMerchantInventory() {
		return merchantInventory;
	}
	public void setMerchantInventory(Inventory merchantInventory) {
		this.merchantInventory = merchantInventory;
	}
	public double getMerchantRevPercent() {
		return merchantRevPercent;
	}
	public void setMerchantRevPercent(double merchantRevPercent) {
		this.merchantRevPercent = merchantRevPercent;
	}
	public Date getDateOfReg() {
		return dateOfReg;
	}
	public void setDateOfReg(Date dateOfReg) {
		this.dateOfReg = dateOfReg;
	}
	public Date getDateOfDel() {
		return dateOfDel;
	}
	public void setDateOfDel(Date dateOfDel) {
		this.dateOfDel = dateOfDel;
	}
	public double getMerchantRevenue() {
		return merchantRevenue;
	}
	public void setMerchantRevenue(double merchantRevenue) {
		this.merchantRevenue = merchantRevenue;
	}
}
