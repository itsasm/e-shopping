package com.eshopping.contrrolers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.models.Product;
import com.eshopping.models.Receipt;
import com.eshopping.services.EShoppingService;
import com.eshopping.utilities.EShoppingUtil;

@RestController
public class EShoppingController {

	@Autowired
	private EShoppingService service;

	@PostMapping("/placeOrder")
	public Receipt placeOrder(@RequestBody(required = false) List<Product> order) {
		return service.processOrder(order);
	}
	
	@PostMapping("/placeOrder/receipt")
	public String generateReceip(@RequestBody(required = false) List<Product> order) {
		return EShoppingUtil.printReceipt(service.processOrder(order));
	}
}
