package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.form.ProductForm;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		List<Product> listProduct = productRepository.findAll();
		return listProduct;
	}

	@Override
	public Product findById(String id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);

	}

	@Override
	public List<Product> searchByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {

		return productRepository.save(product);
	}

}
