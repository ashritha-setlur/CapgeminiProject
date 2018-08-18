package com.capgemini.capstore.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Authentication")
public class Authentication {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authId;
	private String mobileNo;
	private String password;
	private String userAccess;
	private int verification;

	//Constructor
	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authentication(String mobileNo, String password, String userAccess, int verification) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
		this.userAccess = userAccess;
		this.verification = verification;
	}

	//Getters and Setters
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserAccess() {
		return userAccess;
	}
	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}
	public int getVerfication() {
		return verification;
	}
	public void setVerfication(int verification) {
		this.verification = verification;
	}
}
