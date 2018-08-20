package com.capgemini.capstore.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product_Details")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private String productName;
	private String productDesc;
	private int productSize;
	private int productQuantity;
	@ManyToOne(cascade=CascadeType.ALL)
	private Rating productRating;
	@OneToOne(cascade=CascadeType.ALL)
	private Merchant productMerchant;
	private Date productAddDate;
	private Date productDelDate;
	@OneToOne(cascade=CascadeType.ALL)
	private Category productCategory;
	private double productPrice;
	private int productViews;
	@OneToOne(cascade=CascadeType.ALL)
	private Image productImage;
	@OneToOne(cascade=CascadeType.ALL)
	private Discount productDiscount;
	private String productBrand;

	//Constructors
	public Product() {
		super();
	}

	public Product(int productId) {
		super();
		this.productId = productId;
	}

	//Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Rating getProductRating() {
		return productRating;
	}

	public void setProductRating(Rating productRating) {
		this.productRating = productRating;
	}

	public Merchant getProductMerchant() {
		return productMerchant;
	}

	public void setProductMerchant(Merchant productMerchant) {
		this.productMerchant = productMerchant;
	}

	public Date getProductAddDate() {
		return productAddDate;
	}

	public void setProductAddDate(Date productAddDate) {
		this.productAddDate = productAddDate;
	}

	public Date getProductDelDate() {
		return productDelDate;
	}

	public void setProductDelDate(Date productDelDate) {
		this.productDelDate = productDelDate;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductViews() {
		return productViews;
	}

	public void setProductViews(int productViews) {
		this.productViews = productViews;
	}

	public Image getProductImage() {
		return productImage;
	}

	public void setProductImage(Image productImage) {
		this.productImage = productImage;
	}

	public Discount getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Discount productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
}
