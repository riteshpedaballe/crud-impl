package com.crud.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.ProductDao;
import com.crud.models.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	public Product getProductsById(Long id) {
		Optional<Product> result = productDao.findById(id);
		if (result.isPresent())
			return result.get();
		System.out.println("No product exists with Id:" + id);
		return new Product();
	}

	public Product insertProduct(Product product) {
		try {
			return productDao.save(product);
		} catch (Exception e) {
			System.out.println("Inserting new product:" + product.toString() + " failed with error" + e.getMessage());
		}
		return null;

	}

	public Product updateProduct(Long id, Product updatedProduct) {
		Product product = null;
		try {
			product = getProductsById(id);
			if(product == null)
				throw new NoSuchElementException();
			product = updateProductDetails(product, updatedProduct);
			return productDao.save(product);
		} catch (Exception e) {
			System.out.println("Updating product:" + id + " failed with error" + e.getMessage());
		}
		return null;

	}

	private Product updateProductDetails(Product product, Product updatedProduct) {
		if(updatedProduct.getCode() != null)
			product.setCode(updatedProduct.getCode());
		
		if(updatedProduct.getName() != null)
			product.setName(updatedProduct.getName());
		
		if(updatedProduct.getPrice() != null)
			product.setPrice(updatedProduct.getPrice());
		
		if(updatedProduct.getType() != null)
			product.setType(updatedProduct.getType());
		
		return product;
	}

	public boolean deleteProduct(Long id) {
		try {
			productDao.deleteById(id);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("Delete operation with Product ID: " + id + " failed with exception: " + e.getMessage());
			return Boolean.FALSE;
		}
	}
}
