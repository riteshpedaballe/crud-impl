package com.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.models.Product;
import com.crud.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	private static final String FAILURE = "FAILURE";
	private static final String SUCCESS = "SUCCESS";
	@Autowired
	ProductService productService;
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable(name = "productId") Long id ) {
		return productService.getProductsById(id);
	}

	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}
	
	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable(name = "productId") Long id, @RequestBody Product updatedProduct) {
		return productService.updateProduct(id, updatedProduct);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable(name = "productId") Long id) {
		if(productService.deleteProduct(id)){
			return SUCCESS;
		}
		return FAILURE;
	}

	
}
