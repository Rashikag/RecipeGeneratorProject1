package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Ingredients {
//ngredient_name,Ingredient_type,Category
	@Id
	@GeneratedValue
	@Column(name="ingredient_id")
	private int ingredientId;
	@Column(name="ingredient_name")
	private String ingredientName;
	@Column(name="ingredient_type")
	private String ingredientType;
    @Column(name="category")
	private int category;
	
	public Ingredients()
	{
		super();
	}
	public Ingredients(int ingredientId, String ingredientName, String ingredientType, int category) {
		super();
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.ingredientType = ingredientType;
		this.category = category;
	}
	public int getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getIngredientType() {
		return ingredientType;
	}
	public void setIngredientType(String ingredientType) {
		this.ingredientType = ingredientType;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
