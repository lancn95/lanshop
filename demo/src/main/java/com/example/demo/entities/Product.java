package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.form.ProductForm;

@Entity
@Table(name = "product")
public class Product extends CommonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code")
	private String id;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "discount")
	private double discount;

	@Column(name = "instock")
	private boolean inStock;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "mainImage", nullable = false, length = 45)
	private String mainImage;

	@Column(name = "secondImage", nullable = false, length = 45)
	private String secondImage;

	@Column(name = "thirdImage", nullable = false, length = 45)
	private String thirdImage;

	@Column(name = "fouthImage", nullable = false, length = 45)
	private String fouthImage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_id", nullable = false, foreignKey = @ForeignKey(name = "PRODUCT_CATE_FK"))
	private Category category;

	public Product() {
	}

	public Product(ProductForm productForm) {
		this.id = productForm.getId();
		this.name = productForm.getName();
		this.mainImage = productForm.getMainImage();
		this.secondImage = productForm.getSecondImage();
		this.thirdImage = productForm.getThirdImage();
		this.fouthImage = productForm.getFouthImage();
		this.description = productForm.getDescription();
		this.price = productForm.getPrice();
		this.discount = productForm.getDiscount();
		this.enabled = productForm.isEnabled();
		this.inStock = productForm.isInstock();
		this.category.setId(productForm.getCategory_id());

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSecondImage() {
		return secondImage;
	}

	public void setSecondImage(String secondImage) {
		this.secondImage = secondImage;
	}

	public String getThirdImage() {
		return thirdImage;
	}

	public void setThirdImage(String thirdImage) {
		this.thirdImage = thirdImage;
	}

	public String getFouthImage() {
		return fouthImage;
	}

	public void setFouthImage(String fouthImage) {
		this.fouthImage = fouthImage;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
