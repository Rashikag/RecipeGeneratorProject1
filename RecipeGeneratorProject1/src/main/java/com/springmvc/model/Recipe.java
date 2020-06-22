package com.springmvc.model;

public class Recipe {

	private int recipe_id;
	private String recipe_title;
	private String cuisine;
	private String cuisine_type;
	private String details;
	private String recipe_type;
	private String recipe_image;
	
	public Recipe() {
		super();
	}
	
	public Recipe(int recipe_id, String recipe_title, String cuisine, String cuisine_type, String details,
			String recipe_type, String recipe_image) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_title = recipe_title;
		this.cuisine = cuisine;
		this.cuisine_type = cuisine_type;
		this.details = details;
		this.recipe_type = recipe_type;
		this.recipe_image = recipe_image;
	}
	
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine_type() {
		return cuisine_type;
	}
	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getRecipe_type() {
		return recipe_type;
	}
	public void setRecipe_type(String recipe_type) {
		this.recipe_type = recipe_type;
	}
	public String getRecipe_image() {
		return recipe_image;
	}
	public void setRecipe_image(String recipe_image) {
		this.recipe_image = recipe_image;
	}
	
	
}
