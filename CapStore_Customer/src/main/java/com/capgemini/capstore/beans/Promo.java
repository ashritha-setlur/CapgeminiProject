package com.capgemini.capstore.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Promo")
public class Promo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int promoId;
	private String promoType;
	private String promoName;
	private String promoDesc;
	private int promoQuantity;
	private Date startDate;
	private Date endDate;

	//Constructors
	public Promo() {
		super();
	}


	public Promo(int promoId) {
		super();
		this.promoId = promoId;
	}


	public Promo(int promoId, String promoType, String promoName, String promoDesc) {
		super();
		this.promoId = promoId;
		this.promoType = promoType;
		this.promoName = promoName;
		this.promoDesc = promoDesc;
	}


	//Getters and Setters
	public int getPromoId() {
		return promoId;
	}


	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}


	public String getPromoType() {
		return promoType;
	}


	public void setPromoType(String promoType) {
		this.promoType = promoType;
	}


	public String getPromoName() {
		return promoName;
	}


	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}


	public String getPromoDesc() {
		return promoDesc;
	}


	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}


	public int getPromoQuantity() {
		return promoQuantity;
	}


	public void setPromoQuantity(int promoQuantity) {
		this.promoQuantity = promoQuantity;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
