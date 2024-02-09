package com.cookBook.CookBook.Model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType
	.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "recipeOwner", nullable = false)
	private User recipeOwner;
	
	@ElementCollection
	private List<String> ingredients;
	
	private String recipeProcedure;
	 
	private String recipeName;
	
	@OneToMany
	private List<Comment> comments;
	
	private String about;
	
	private String img;
	
	
	

}
