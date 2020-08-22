package com.eshopping.enums;

public enum ProductCategory {

	BOOKS("books"), FOOD("food"), MEDICAL("medical"), OHTERS("others");

	private String category;

	private ProductCategory(String category) {
		this.category = category;
	}

	public String getCatagory() {
		return this.category;
	}
}
