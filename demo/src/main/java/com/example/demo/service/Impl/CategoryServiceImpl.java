package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Category;
import com.example.demo.form.CategoryForm;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.GetTimeUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();

		return categories;
	}

	@Override
	public Category findById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);

		return category;
	}

	@Override
	public void save(Category category) {

		categoryRepository.save(category);

	}

	@Override
	public void update(Category category) {
		categoryRepository.save(category);

	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);

	}

	@Override
	public List<Category> searchByNameLike(String name) {
		List<Category> categories = categoryRepository.searchByNameLike(name);

		return categories;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void create(CategoryForm categoryForm) {
		Category category = new Category();
		
		category.setCreatedDate(GetTimeUtil.getCurrentTime());
		category.setName(categoryForm.getName());
		categoryRepository.save(category);

	}
}
