package com.eshopping.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eshopping.enums.ProductCategory;
import com.eshopping.enums.ProductType;
import com.eshopping.enums.Taxes;
import com.eshopping.models.Product;

public class EShoppingUtil {

	private static Logger logger = LoggerFactory.getLogger(EShoppingUtil.class);

	public static double getBasicTaxe() {
		return Taxes.BASIC_TAX.getTaxeRate();
	}

	public static double getImportDuty() {
		return Taxes.IMPORT_DUTY.getTaxeRate();
	}

	public static double calculateTax(Product product) {
		double taxes = 0;
		if (product.getProductType() == ProductType.IMPORTED) {
			taxes += product.getQuantity() * product.getPrice() * (getImportDuty() / 100);
		}

		if (product.getCategory() == ProductCategory.OHTERS) {
			taxes += product.getQuantity() * product.getPrice() * (getBasicTaxe() / 100);
		}

		return taxes;
	}

	public static double round(double value, int places, boolean isImported) {
		double scale = Math.pow(10, places);
		double roundVal = Math.round(value * scale) / scale;
		return round(roundVal, isImported);
	}

	public static double round(double value, boolean isImported) {

		value = value * 100;
		if (!isImported) {
			double rem100 = value % 100;
			if (rem100 >= 25 && rem100 < 75) {
				value -= rem100;
				value += 50;
			} else if (rem100 >= 75) {
				value -= rem100;
				value += 100;
			}
		} else {
			double rem10 = value % 10;
			if (rem10 >= 3 && rem10 < 8) {
				value -= rem10;
				value += 5;
			} else if (rem10 >= 8) {
				value -= rem10;
				value += 10;
			}
		}

		return value / 100;
	}
}
