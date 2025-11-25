package com.jmp.movieflix.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	private double rating;

	@CreationTimestamp //salva a hora de criação
	@Column(name = "created_at")
	private LocalDate createdAt;

	@UpdateTimestamp //salva a hora de atualização
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	 @ManyToMany
	    @JoinTable(name = "movie_category",  
	  	joinColumns = @JoinColumn(name="movie_id"), 
		inverseJoinColumns = @JoinColumn(name="category_id")) 
	  private List<Category> categories;
		
	  @ManyToMany
	    @JoinTable(name = "movie_streaming",
		joinColumns = @JoinColumn(name="movie_id"), 
		inverseJoinColumns = @JoinColumn(name="streaming_id")) 
	  private List<Streaming> streamings;

}
