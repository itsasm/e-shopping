package com.eshopping.enums;

public enum ProductType {

	DOMESTIC("domestic"), IMPORTED("imported");

	private String type;

	ProductType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
