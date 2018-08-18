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
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String mobileNo;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Date dateOfBirth;
	private Date dateOfReg;
	private Date dateOfDel;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	@OneToOne(cascade=CascadeType.ALL)
	private Wishlist wishlist;

	//Constructors
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id) {
		super();
		this.id = id;
	}

	public Customer(int id, String mobileNo, String firstName, String lastName, String email, String gender,
			Date dateOfBirth, Date dateOfReg, Date dateOfDel, Address address, Cart cart, Wishlist wishlist) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateOfReg = dateOfReg;
		this.dateOfDel = dateOfDel;
		this.address = address;
		this.cart = cart;
		this.wishlist = wishlist;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Wishlist getWishlist() {
		return wishlist;
	}
	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
}
