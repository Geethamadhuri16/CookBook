package com.cookBook.CookBook.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cookBook.CookBook.Model.Recipe;
import com.cookBook.CookBook.Model.User;
import com.cookBook.CookBook.RecipeDTO.RecipeDTO;
import com.cookBook.CookBook.RecipeMapper.RecipeMapper;
import com.cookBook.CookBook.Repo.RecipeRepo;
import com.cookBook.CookBook.Repo.UserRepo;
import com.cookBook.CookBook.Service.RecipeService;


@Service
public class RecipeServiceImp implements RecipeService{
	
	@Autowired
	private RecipeRepo repo;
	
	@Autowired
    private UserRepo urepo;

	@Override
	public ResponseEntity<String> addRecipe(Recipe r) {
		try {
			repo.save(r);
			return new  ResponseEntity<>("added recipe Successfully",HttpStatus.OK);
		}catch(Exception e) {
			return new  ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<String> editRecipe(RecipeDTO dto,Long id) {
		try {
			Recipe r=repo.findById(id).orElse(null);
			if(r==null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			RecipeMapper.RecipeDTOToRecipe(dto, r);
			repo.save(r);
			return new ResponseEntity<>("Updated recipe post", HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>("Failed to update blog post", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}

	@Override
	public ResponseEntity<List<Recipe>> allRecipesOfUser(Long id) {
		try {
			User u=urepo.findById(id).orElse(null);
			List<Recipe> recipes=repo.findByRecipeOwner(u);
			if(recipes==null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(recipes, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<Recipe>> searchRecipe(String query) {
		try {
			List<Recipe> matchingRecipes = repo.findByRecipeNameContainingOrIngredientsContaining(query, query);
			if(matchingRecipes!=null) {
				return ResponseEntity.ok(matchingRecipes);
			}else {
				return new ResponseEntity(null,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
	
	
	
	

}
