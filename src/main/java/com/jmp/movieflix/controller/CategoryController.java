package com.jmp.movieflix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.movieflix.entity.Category;
import com.jmp.movieflix.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryService.delete(id);
	}
	
	@GetMapping("/{id}")
	public Category findById(@PathVariable Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping
	public Category save(@RequestBody Category category) {
		return categoryService.save(category);
	}
	
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.findAll();
	}
}
