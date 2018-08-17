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
@Table(name="Product_Details")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private String productName;
	private String productDesc;
	private int productSize;
	private int productQuantity;
	@OneToOne(mappedBy="product",cascade=CascadeType.ALL)
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
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productDesc, int productSize, int productQuantity,
			Rating productRating, Merchant productMerchant, Date productAddDate, Date productDelDate,
			Category productCategory, double productPrice, int productViews, Image productImage,
			Discount productDiscount, String productBrand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productSize = productSize;
		this.productQuantity = productQuantity;
		this.productRating = productRating;
		this.productMerchant = productMerchant;
		this.productAddDate = productAddDate;
		this.productDelDate = productDelDate;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productViews = productViews;
		this.productImage = productImage;
		this.productDiscount = productDiscount;
		this.productBrand = productBrand;
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
