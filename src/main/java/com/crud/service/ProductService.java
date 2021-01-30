package com.crud.service;

import com.crud.models.Product;

public interface ProductService {
	
	public Product getProductsById(Long id) ;

	public Product insertProduct(Product product);

	public Product updateProduct(Long id, Product product);

	public boolean deleteProduct(Long id);
}
