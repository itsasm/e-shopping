package com.eshopping.models;

import java.util.List;
import java.util.Map;

public class Receipt {

	private Map<String, List<Product>> productList;
	private double salesTax;
	private double totalAmount;

	public Map<String, List<Product>> getProductList() {
		return productList;
	}

	public void setProductList(Map<String, List<Product>> productList) {
		this.productList = productList;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
