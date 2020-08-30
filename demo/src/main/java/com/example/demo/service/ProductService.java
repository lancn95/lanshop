package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(String id);

	Product save(Product product);

	Product update(Product product);

	void delete(Product product);

	List<Product> searchByNameLike(String name);
}
