package com.cookBook.CookBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cookBook.CookBook.Model.Recipe;
import com.cookBook.CookBook.RecipeDTO.RecipeDTO;
import com.cookBook.CookBook.ServiceImp.RecipeServiceImp;

@RestController
public class RecipeController {
	@Autowired
    private RecipeServiceImp recipeService;

    @PostMapping("/addRecipe")
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @PostMapping("/editRecipe")
    public ResponseEntity<String> editRecipe(@RequestBody RecipeDTO recipeDTO, Long id) {
        return recipeService.editRecipe(recipeDTO, id);
    }

}
