package com.eshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eshopping.models.Product;
import com.eshopping.models.Receipt;
import com.eshopping.utilities.EShoppingUtil;

@Service
public class EShoppingService {

	private static Logger logger = LoggerFactory.getLogger(EShoppingService.class);

	public Receipt processOrder(List<Product> productList) {

		if (productList == null || productList.isEmpty())
			return null;

		Receipt receipt = new Receipt();
		processProducts(productList, receipt);

		return receipt;
	}

	private static void processProducts(List<Product> productList, Receipt receipt) {
		receipt.setProductList(new ArrayList<>());
		double totalSalesTax = 0;
		double totalBill = 0;
		for (Product product : productList) {
			double tax = EShoppingUtil.calculateTax(product);
			tax = EShoppingUtil.round(tax, 2);
			product.setSalesTax(tax);
			totalSalesTax += tax;
			totalBill += product.getPrice() + tax;
		}
		buildReceipt(receipt, productList, totalSalesTax, totalBill);
	}

	private static void buildReceipt(Receipt receipt, List<Product> productList, double totalSalesTax,
			double totalBill) {

		receipt.setProductList(productList);
		receipt.setSalesTax(totalSalesTax);
		receipt.setTotalAmount(EShoppingUtil.roundOff(totalBill, 2));

		logger.info("Building Receipt For " + receipt.getProductList().size() + " Products");

	}

}
