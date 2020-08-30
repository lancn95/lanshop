package com.example.demo.form;

import javax.persistence.Transient;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

public class ProductForm {
	private String id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private boolean enabled;
	private boolean instock;
	private String mainImage;
	private String secondImage;
	private String thirdImage;
	private String fouthImage;
	private int category_id;

	public ProductForm() {

	}

	public ProductForm(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.discount = product.getDiscount();
		this.enabled = product.isEnabled();
		this.instock = product.isInStock();
		this.price = product.getPrice();
		this.mainImage = product.getMainImage();
		this.secondImage = product.getSecondImage();
		this.thirdImage = product.getThirdImage();
		this.fouthImage = product.getFouthImage();
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isInstock() {
		return instock;
	}

	public void setInstock(boolean instock) {
		this.instock = instock;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	@Transient
	public String getMainImagePath() {
		if (mainImage == null)
			return null;

		return "/product-images/" + id + "/" + mainImage;
	}

	@Transient
	public String getSecondImagePath() {
		if (mainImage == null)
			return null;

		return "/product-images/" + id + "/" + secondImage;
	}

	@Transient
	public String getThirdImagePath() {
		if (mainImage == null)
			return null;

		return "/product-images/" + id + "/" + thirdImage;
	}

	@Transient
	public String getFouthImagePath() {
		if (mainImage == null)
			return null;

		return "/product-images/" + id + "/" + fouthImage;
	}
}
