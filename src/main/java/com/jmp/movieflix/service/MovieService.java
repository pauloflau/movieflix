package com.jmp.movieflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmp.movieflix.entity.Category;
import com.jmp.movieflix.entity.Movie;
import com.jmp.movieflix.entity.Streaming;
import com.jmp.movieflix.repositories.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;
	private final CategoryService categoryService;
	private final StreamingService streamingService;

	public Movie save(Movie movie) {
		movie.setCategories(this.findCategories(movie.getCategories()));
		movie.setStreamings(this.findStreamings(movie.getStreamings()));
		return movieRepository.save(movie);
	}

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Optional<Movie> findById(Long id) {
		return movieRepository.findById(id);
	}

	public Optional<Movie> update(Long movieId, Movie updateMovie) {
		Optional<Movie> optMovie = movieRepository.findById(movieId);

		if (optMovie.isPresent()) {
			Movie movie = optMovie.get();
			movie.setTitle(updateMovie.getTitle());
			movie.setDescription(updateMovie.getDescription());
			movie.setReleaseDate(updateMovie.getReleaseDate());
			movie.setRating(updateMovie.getRating());

			List<Category> categories = this.findCategories(updateMovie.getCategories());
			List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

			movie.getCategories().clear();
			movie.getCategories().addAll(categories);
			
			movie.getStreamings().clear();
			movie.getStreamings().addAll(streamings);
			
			movieRepository.save(movie);
			
			return Optional.of(movie);
		}

		return Optional.empty();
	}

	public List<Movie> findByCategory(Long categoriaId) {
		return movieRepository.findByCategoriesIn(List.of(Category.builder().id(categoriaId).build()));
	}
	
	public boolean delete(Long id) {
		Optional<Movie> movieOpt = movieRepository.findById(id);
		if (movieOpt.isPresent()) {
	        movieRepository.deleteById(id);
	        return true;
		}
		return false;
	}
	
	private List<Category> findCategories(List<Category> categories) {
		List<Category> categoriesFound = new ArrayList<>();
		for (Category category : categories) {
			categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
		}
		return categoriesFound;
	}

	private List<Streaming> findStreamings(List<Streaming> streamings) {
		List<Streaming> streamingsFound = new ArrayList<>();
		for (Streaming streaming : streamings) {
			streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add);
		}
		return streamingsFound;
	}
	
}
