package com.springmvc.controller;



import java.util.ArrayList;
import java.util.HashMap;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;

import com.springmvc.dao.SearchControllerDao;
import com.springmvc.model.Recipe;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
	@InjectMocks
	SearchController searchController;
	@Mock
	SearchControllerDao searchControllerDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		// creates mock objects
	}

	@SuppressWarnings("unchecked")
	@Test
	public void showFilterPageTest() {
		ModelMap model = new ModelMap();
		ArrayList<String> ingredient = new ArrayList<>();
		ingredient.add("Milk");
		ingredient.add("Egg");
		Mockito.when(searchControllerDao.getIngredientNameList()).thenReturn(ingredient);
		String result = searchController.showFilterPage(model);
		assert (result == "home");
		assert (((HashMap<String, Object>) model.get("ingredientList")).size() != 0);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void showRecipeDetailsTestNullDetails() {
		ModelMap model = new ModelMap();
		Recipe r = new Recipe(1, "Rosgulla", "Indian", "Dessert", "abc", "image", "veg");
		ArrayList<Recipe> recipes = new ArrayList<>();
		recipes.add(r);
		Mockito.when(searchControllerDao.fetchRecipes(r)).thenReturn(recipes);
		String result = searchController.recipeDetails(r, model);
		assert (result == "recipe");
		assert (((HashMap<String, Object>) model.get("allRecipeDetail")).size() != 0);
	}

	@Test
	public void showRecipeDetalsTestNonNullDetails() {
		ModelMap model = new ModelMap();
		Recipe r = new Recipe(1, "Rosgulla", "Indian", "Dessert", "abc", "image", "veg");
		Mockito.when(searchControllerDao.fetchRecipes(r)).thenReturn(null);
		String result = searchController.recipeDetails(r, model);
		assert (result == "home");

	}

	@Test
	public void showRecipePageTest() {
		ModelMap model = new ModelMap();
		String result = searchController.showRecipePage(model);
		assert (result == "recipe");
	}
}
