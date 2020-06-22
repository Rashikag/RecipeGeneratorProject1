package com.springmvc.model;

public class Ingredients {
//ngredient_name,Ingredient_type,Category
	private int ingredient_id;
	private String ingredient_name;
	private String ingredient_type;
	private int category;
	
	public Ingredients()
	{
		super();
	}
	public Ingredients(int ingredient_id, String ingredient_name, String ingredient_type, int category) {
		super();
		this.ingredient_id = ingredient_id;
		this.ingredient_name = ingredient_name;
		this.ingredient_type = ingredient_type;
		this.category = category;
	}
	public int getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public String getIngredient_type() {
		return ingredient_type;
	}
	public void setIngredient_type(String ingredient_type) {
		this.ingredient_type = ingredient_type;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
