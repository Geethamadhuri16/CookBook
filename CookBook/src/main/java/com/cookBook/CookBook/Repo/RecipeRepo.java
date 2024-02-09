package com.cookBook.CookBook.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookBook.CookBook.Model.Recipe;
import com.cookBook.CookBook.Model.User;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
	public List<Recipe> findByRecipeOwner(User u);
	public List<Recipe> findByRecipeNameContainingOrIngredientsContaining(String query,String query1);

}
