package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.form.ProductForm;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	public String listProduct() {
		return "admin/products";
	}

	@RequestMapping(value = "/admin/product-save", method = RequestMethod.GET)
	public String fillProduct(Model model) {
		ProductForm productForm = new ProductForm();
		// get categories
		List<Category> categories = categoryService.findAll();

		model.addAttribute("productForm", productForm);
		model.addAttribute("categories", categories);
		return "admin/product_save";
	}
	
	@RequestMapping(value = "/admin/product-save", method = RequestMethod.POST)
	public String saveProdcut(@ModelAttribute ProductForm productForm, RedirectAttributes redirect) {
		
		Product product = new Product(productForm);

		productService.save(product);
		return "admin/product_save";
	}
}
