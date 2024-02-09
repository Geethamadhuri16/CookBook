package com.cookBook.CookBook.RecipeDTO;

import java.util.List;

public class RecipeDTO {
	private List<String> ingredients;
	private String recipeProcedure;
	private String recipeName;
    private String about;	
	private String img;
	public RecipeDTO(List<String> ingredients, String recipeProcedure, String recipeName, String about, String img) {
		this.ingredients = ingredients;
		this.recipeProcedure = recipeProcedure;
		this.recipeName = recipeName;
		this.about = about;
		this.img = img;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public String getRecipeProcedure() {
		return recipeProcedure;
	}
	public void setRecipeProcedure(String recipeProcedure) {
		this.recipeProcedure = recipeProcedure;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

}
