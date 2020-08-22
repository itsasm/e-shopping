package com.eshopping;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eshopping.enums.ProductCategory;
import com.eshopping.enums.ProductType;
import com.eshopping.models.Product;
import com.eshopping.models.Receipt;
import com.eshopping.services.EShoppingService;

@SpringBootTest
class EShoppingApplicationTests {

	@Autowired
	private EShoppingService service;

	@Test
	public void testCaseNull() {
		Receipt actual = service.generateReceipt(null);
		Assertions.assertNull(actual);
	}

	@Test
	public void testCaseDomesticProducts() {

		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Book", 1, 12.49, ProductType.DOMESTIC, ProductCategory.BOOKS));
		productList.add(new Product("Music CD", 1, 16.49, ProductType.DOMESTIC, ProductCategory.OHTERS));
		productList.add(new Product("Chocolate", 1, 0.85, ProductType.DOMESTIC, ProductCategory.FOOD));

		Receipt actual = service.generateReceipt(productList);
		Assertions.assertEquals(1.50, actual.getSalesTax());
		Assertions.assertEquals(29.83, actual.getTotalAmount());
	}

	@Test
	public void testCaseImportedProducts() {

		List<Product> productList = new ArrayList<>();
		productList.add(new Product("Chocolate Box", 1, 10.00, ProductType.IMPORTED, ProductCategory.FOOD));
		productList.add(new Product("Perfume", 1, 47.50, ProductType.IMPORTED, ProductCategory.OHTERS));

		Receipt actual = service.generateReceipt(productList);
		Assertions.assertEquals(7.65, actual.getSalesTax());
		Assertions.assertEquals(65.15, actual.getTotalAmount());
	}

}
