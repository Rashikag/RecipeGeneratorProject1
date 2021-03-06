package com.springmvc.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="recipe")
public class Recipe {
	@Id
	@GeneratedValue
	@Column(name = "recipe_id")
	private int recipeId;
	@Column(name = "recipe_title")
	private String recipeTitle;
	@Column(name = "cuisine")
	private String cuisine;
	@Column(name = "cuisine_type")
	private String cuisineType;
	@Column(name = "details")
	private String details;
	@Column(name = "recipe_type")
	private String recipeType;
	@Column(name = "recipe_image")
	private String recipeImage;
    
	@Transient
	private List<String> ingredientNameList;
	


	public Recipe() {

	}
    
	

	public Recipe(int recipeId, String recipeTitle, String cuisine, String cuisineType, String details,
			String recipeType, String recipeImage) {
		super();
		this.recipeId = recipeId;
		this.recipeTitle = recipeTitle;
		this.cuisine = cuisine;
		this.cuisineType = cuisineType;
		this.details = details;
		this.recipeType = recipeType;
		this.recipeImage = recipeImage;
		
	}



	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public String getRecipeImage() {
		return recipeImage;
	}

	public void setRecipeImage(String recipeImage) {
		this.recipeImage = recipeImage;
	}
	public List<String> getIngredientNameList() {
		return ingredientNameList;
	}



	public void setIngredientNameList(List<String> ingredientNameList) {
		this.ingredientNameList = ingredientNameList;
	}


	



	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeTitle=" + recipeTitle + ", cuisine=" + cuisine
				+ ", cuisineType=" + cuisineType + ", details=" + details + ", recipeType=" + recipeType
				+ ", recipeImage=" + recipeImage + "]";
	}

	


}
