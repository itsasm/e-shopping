package com.eshopping.enums;

public enum Taxes {

	BASIC_TAX(10.00), IMPORT_DUTY(5.0);

	private double taxeRate;

	private Taxes(double taxeRate) {
		this.taxeRate = taxeRate;
	}

	public double getTaxeRate() {
		return taxeRate;
	}

}
