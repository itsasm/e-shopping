package com.eshopping.models;

import com.eshopping.enums.ProductCategory;
import com.eshopping.enums.ProductType;

public class Product {

	private int quantity;
	private String name;
	private double price;
	private ProductType productType;
	private ProductCategory category;
	private double salesTax;

	public Product() {}

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

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + ", productType=" + productType
				+ ", category=" + category + ", salesTax=" + salesTax + "]";
	}

}
