package com.example.demo.service;

import java.text.ParseException;
import java.util.List;

import com.example.demo.entities.Category;
import com.example.demo.form.CategoryForm;

public interface CategoryService {
	List<Category> findAll();

	Category findById(int id);

	void save(Category category);

	void update(Category category);

	void delete(Category category);

	List<Category> searchByNameLike(String name);
	
	void create(CategoryForm categoryForm);
}
