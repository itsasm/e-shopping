package com.eshopping.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eshopping.enums.ProductCategory;
import com.eshopping.enums.ProductType;
import com.eshopping.enums.Taxes;
import com.eshopping.models.Product;
import com.eshopping.models.Receipt;
import com.eshopping.services.EShoppingService;

public class EShoppingUtil {

	private static Logger logger = LoggerFactory.getLogger(EShoppingService.class);

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

		if (product.getCategory() == ProductCategory.OTHERS) {
			taxes += product.getQuantity() * product.getPrice() * (getBasicTaxe() / 100);
		}

		return taxes;
	}

	public static double roundOff(double value, int places) {
		double scale = Math.pow(10, places);
		double roundVal = Math.round(value * scale) / scale;
		return roundVal;
	}

	public static double round(double value, int places) {
		double scale = Math.pow(10, places);
		double roundVal = Math.round(value * scale) / scale;
		return round(roundVal);
	}

	public static double round(double value) {
		value = value * 100;
		double rem10 = value % 10;
		if (rem10 < 3) {
			value -= rem10;
		} else if (rem10 >= 3 && rem10 < 8) {
			value -= rem10;
			value += 5;
		} else if (rem10 >= 8) {
			value -= rem10;
			value += 10;
		}
		return value / 100;
	}

	public static String printReceipt(Receipt receipt) {
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n---------------------- Receipt -------------------\n");
		sb.append("\n\n    Quantity	Product		Price(Inc Tax)");
		for (Product pruduct : receipt.getProductList()) {
			sb.append("\n	" + pruduct.getQuantity() + "	" + pruduct.getName() + "		"
					+ roundOff(pruduct.getQuantity() * (pruduct.getPrice() + pruduct.getSalesTax()), 2));
		}

		sb.append("\n\n		Sales Tax	: " + receipt.getSalesTax());
		sb.append("\n		Total Bill 	: " + receipt.getTotalAmount());
		sb.append("\n\n---------------------- Receipt -------------------\n");

		logger.info(sb.toString());
		return sb.toString();

	}
}
