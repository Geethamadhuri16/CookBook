package com.cookBook.CookBook.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cookBook.CookBook.Model.Recipe;
import com.cookBook.CookBook.RecipeDTO.RecipeDTO;

public interface RecipeService {
	public ResponseEntity<String> addRecipe(Recipe r);
	public ResponseEntity<String> editRecipe(RecipeDTO dto,Long recipeId);
	public ResponseEntity<List<Recipe>> allRecipesOfUser(Long id);
	public ResponseEntity<List<Recipe>> searchRecipe(String query);
	

}
