package com.eshopping.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshopping.enums.ProductType;
import com.eshopping.models.Product;
import com.eshopping.models.Receipt;
import com.eshopping.utilities.EShoppingUtil;

@Service
public class EShoppingService {

	boolean isImported = false;

	public Receipt generateReceipt(List<Product> productList) {
		if (productList == null || productList.isEmpty())
			return null;

		Receipt receipt = new Receipt();
		double salesTax = 0;
		double totalPrices = 0;
		for (Product product : productList) {
			if (product.getProductType() == ProductType.IMPORTED)
				isImported = true;

			salesTax += EShoppingUtil.calculateTax(product);
			totalPrices += product.getPrice();
		}

		if (isImported) {
			salesTax = EShoppingUtil.round(salesTax, 2, isImported);
			receipt.setSalesTax(salesTax);
			totalPrices += salesTax;
		} else {
			receipt.setSalesTax(EShoppingUtil.round(salesTax, 2, isImported));
		}
		receipt.setTotalAmount(totalPrices);

		return receipt;
	}

}
