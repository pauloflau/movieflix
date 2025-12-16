package com.jmp.movieflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.movieflix.dtos.CategoryRequest;
import com.jmp.movieflix.dtos.CategoryResponse;
import com.jmp.movieflix.entity.Category;
import com.jmp.movieflix.mapper.CategoryMapper;
import com.jmp.movieflix.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoryService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id).orElse(null);
		if(category!=null) {
			return ResponseEntity.ok(CategoryMapper.toCategoryResponse(category));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CategoryResponse> save(@RequestBody @Valid CategoryRequest request) {
		Category newCategory = CategoryMapper.toCategory(request);
		Category saveCategory = categoryService.save(newCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(saveCategory));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryResponse>> getAllCategories(){
		List<CategoryResponse> categories = categoryService.findAll()
			.stream()
			.map(category -> CategoryMapper.toCategoryResponse(category))
			.toList();	
		return ResponseEntity.ok(categories);
	}
}
