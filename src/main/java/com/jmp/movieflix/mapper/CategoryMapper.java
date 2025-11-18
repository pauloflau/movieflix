package com.jmp.movieflix.mapper;

import com.jmp.movieflix.dtos.CategoryRequest;
import com.jmp.movieflix.dtos.CategoryResponse;
import com.jmp.movieflix.entity.Category;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
	public static Category toCategory(CategoryRequest categoryRequest) {
	 	return Category
	 			.builder()
	 			.name(categoryRequest.name())
	 			.build();
	  }
		
	  public static CategoryResponse toCategoryResponse(Category category) {
		return CategoryResponse
				.builder()
				.id(category.getId())
				.name(category.getName())
				.build();
	  }
}
