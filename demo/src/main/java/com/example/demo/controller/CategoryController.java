package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.CategoryForm;
import com.example.demo.service.CategoryService;
import com.example.demo.entities.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value = "/category-search/{pageNumber}", method = RequestMethod.GET)
	public String search(@RequestParam("name") String name, Model model, HttpServletRequest request,
			@PathVariable int pageNumber) {
		// fill admin name sign in
		//String adminname = principal.getName();
		//model.addAttribute("name", adminname);

		if (name.isEmpty()) {
			return "redirect:/admin/category";
		}

		List<Category> categories = categoryService.searchByNameLike(name);
		if (categories == null || categories.size() < 0) {
			return "redirect:/admin/category";
		}
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("categorylist");
		int pageSize = 3;
		pages = new PagedListHolder<>(categories);
		pages.setPageSize(pageSize);

		final int goToPage = pageNumber - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}

		request.getSession().setAttribute("categorylist", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - categories.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/admin/category/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("categories", pages);

		return "admin/categories";
	}

	// category list pagination begin
		@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
		private String listCate(HttpServletRequest request) {
			request.getSession().setAttribute("categorylist", null);

			return "redirect:/admin/category/page/1";
		}

		@RequestMapping(value = "/admin/category/page/{pageNumber}", method = RequestMethod.GET)
		private String listCategory(HttpServletRequest request, @PathVariable int pageNumber, Model model
				) {
			// fill admin name sign in
			//String adminname = principal.getName();
			//model.addAttribute("name", adminname);
			
			// pagination
			PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("categorylist");
			int pageSize = 3;
			List<Category> list = categoryService.findAll();
			if (pages == null) {
				pages = new PagedListHolder<>(list);
				pages.setPageSize(pageSize);
			} else {
				final int goToPage = pageNumber - 1;
				if (goToPage <= pages.getPageCount() && goToPage >= 0) {
					pages.setPage(goToPage);
				}
			}

			request.getSession().setAttribute("categorylist", pages);
			int current = pages.getPage() + 1;
			int begin = Math.max(1, current - list.size());
			int end = Math.min(begin + 5, pages.getPageCount());
			int totalPageCount = pages.getPageCount();
			String baseUrl = "/admin/category/page/";

			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			model.addAttribute("totalPageCount", totalPageCount);
			model.addAttribute("baseUrl", baseUrl);
			model.addAttribute("categories", pages);
			return "admin/categories";
		}
		// category list pagination end

	@RequestMapping(value = "/admin/category-save", method = RequestMethod.GET)
	public String fillInCategory(Model model) {
		CategoryForm categoryForm = new CategoryForm();

		model.addAttribute("categoryForm", categoryForm);
		return "admin/category_save";
	}

	@RequestMapping(value = "/admin/category-save", method = RequestMethod.POST)
	public String createNew(@ModelAttribute CategoryForm categoryForm, RedirectAttributes redirect) {
		if(categoryForm == null) {
			return "admin/category_save";
		}
		categoryService.create(categoryForm);
		redirect.addFlashAttribute("Message", "Saved category successfully!");
		return "redirect:/admin/category";
	}
}
