package com.cookBook.CookBook.RecipeMapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.cookBook.CookBook.Model.Recipe;
import com.cookBook.CookBook.RecipeDTO.RecipeDTO;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class RecipeMapper {
	
	@AfterMapping
	public static void RecipeDTOToRecipe(RecipeDTO dto,@MappingTarget Recipe recipe) {
		if(dto.getAbout()!=null) {
			recipe.setAbout(dto.getAbout());
			
		}
		if(dto.getImg()!=null) {
			recipe.setImg(dto.getImg());
		}
		if(dto.getIngredients()!=null) {
			recipe.setIngredients(dto.getIngredients());
		}
		if(dto.getRecipeName()!=null) {
			recipe.setRecipeName(dto.getRecipeName());
		}
		if(dto.getRecipeProcedure()!=null) {
			recipe.setRecipeProcedure(dto.getRecipeProcedure());
		}
		
	}

}
