package com.jmp.movieflix.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
}
