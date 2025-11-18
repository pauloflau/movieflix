package com.jmp.movieflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmp.movieflix.entity.Category;
import com.jmp.movieflix.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
	
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
}
