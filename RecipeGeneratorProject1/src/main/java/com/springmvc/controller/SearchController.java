package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dao.SearchControllerDao;

import com.springmvc.model.Recipe;

@Controller
@SessionAttributes("name")
public class SearchController {

	@Autowired
	SearchControllerDao searchControllerDao;

	/**
	 * add ingredient list to drop-down in home page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showFilterPage(ModelMap model) {
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);
		List<String> ingredientList = searchControllerDao.getIngredientNameList();
		model.addAttribute("ingredientList", ingredientList);
		return "home";
	}
    
	/**
	 * Redirects to recipe page if allRecipeDetails is added with recipes
	 * Redirects to home page if allRecipeDetails is null
	 * @param recipe
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String recipeDetails(Recipe recipe, ModelMap model) {
		model.addAttribute("recipe", recipe);
		List<Recipe> allRecipeDetail = searchControllerDao.fetchRecipes(recipe);
		if (allRecipeDetail == null || allRecipeDetail.isEmpty()) {
			model.put("errorMsg", "No results found! Try Again!");
			return showFilterPage(model);
		}
		model.addAttribute("allRecipeDetails", allRecipeDetail);
		return showRecipePage(model);
	}
	
    /**
     * passes model to the recipe page
     * @param model
     * @return
     */
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public String showRecipePage(ModelMap model) {
		return "recipe";
	}

}
