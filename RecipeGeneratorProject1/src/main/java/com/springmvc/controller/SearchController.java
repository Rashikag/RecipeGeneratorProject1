package com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dao.SearchControllerDao;
import com.springmvc.model.Ingredients;
import com.springmvc.model.Recipe;


@Controller
@SessionAttributes("name")
public class SearchController {

	@Autowired
	SearchControllerDao searchControllerDao;

	@RequestMapping(value = "/recipe", method = RequestMethod.GET)
	public String showLoginPage() {
		return "recipe";
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public String recipeDetails(@RequestParam String recipeTitle, @ModelAttribute("recipeDetail") Recipe detail,
			ModelMap model) {
		detail = searchControllerDao.validateRecipeName(recipeTitle);
		model.addAttribute("recipeDetails", detail);
		return "recipe";

	}
    
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String showPage(Model model) {
		//todo-addingredientlist
			Recipe recipe=new Recipe();
			model.addAttribute("recipe", recipe);
			List<String> ingredientList=searchControllerDao.getIngredientNameList();
			model.addAttribute("ingredientList", ingredientList);
		return "filter";
	}
	

	
	@RequestMapping(value = "/recipef", method = RequestMethod.POST)
	public String showRecipePage(ModelMap model) {
		return "recipef";
	}
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(Recipe recipe, ModelMap model) {
		model.addAttribute("recipe",recipe);
		List<Recipe> allRecipeDetail = searchControllerDao.fetchRecipes(recipe);
		if(allRecipeDetail==null || allRecipeDetail.isEmpty()) {
			return "filter";
		}
		model.addAttribute("allRecipeDetails", allRecipeDetail);//todo	
		return showRecipePage(model);
	}
	
	
}
	