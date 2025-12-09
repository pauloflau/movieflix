package com.jmp.movieflix.mapper;

import java.util.List;

import com.jmp.movieflix.dtos.CategoryResponse;
import com.jmp.movieflix.dtos.MovieRequest;
import com.jmp.movieflix.dtos.MovieResponse;
import com.jmp.movieflix.dtos.StreamingResponse;
import com.jmp.movieflix.entity.Category;
import com.jmp.movieflix.entity.Movie;
import com.jmp.movieflix.entity.Streaming;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {
	public static Movie toMovie(MovieRequest movieRequest) {
		
		List<Category> categories = movieRequest.categories().stream()
				.map(categoryId -> Category.builder().id(categoryId).build())
				.toList();

		List<Streaming> streamings = movieRequest.streamings().stream()
				.map(streamingId -> Streaming.builder().id(streamingId).build())
				.toList();
		
	 	return Movie.builder()
	 			.title(movieRequest.title())
	 			.description(movieRequest.description())
				.releaseDate(movieRequest.releaseDate())
				.rating(movieRequest.rating())
				.categories(categories)
				.streamings(streamings)
	 			.build();
	  }
		
	  public static MovieResponse toMovieResponse(Movie movie) {
		List<CategoryResponse>categories = movie.getCategories().stream()
			.map(category -> CategoryMapper.toCategoryResponse(category))
			.toList();
		
		List<StreamingResponse> streamings = movie.getStreamings().stream()
			.map(streaming -> StreamingMapper.toStreamingResponse(streaming))
			.toList();
				  
		return MovieResponse.builder()
				.id(movie.getId())
				.title(movie.getTitle())
	 			.description(movie.getDescription())
				.releaseDate(movie.getReleaseDate())
				.rating(movie.getRating())
				.categories(categories)
				.streamings(streamings)
				.build();
	  }
}
