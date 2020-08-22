package com.eshopping.models;

import com.eshopping.enums.ProductCategory;
import com.eshopping.enums.ProductType;

public class Product {

	private String name;
	private int quantity;
	private double price;
	private ProductType productType;
	private ProductCategory category;

	public Product(String name, int quantity, double rate, ProductType productType, ProductCategory category) {
		this.name = name;
		this.quantity = quantity;
		this.price = rate;
		this.productType = productType;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

}
