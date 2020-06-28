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
		return "filter";
	}
	

	@RequestMapping(value = "/testform", method = RequestMethod.GET)
	public String getForm(Model model) {
		Ingredients ingredients = new Ingredients();
		model.addAttribute("ingredient", ingredients);
		ArrayList<String> dairyList = new ArrayList<>(Arrays.asList("Egg", "Milk", "Cheese"));
		ArrayList<String> vegList = new ArrayList<>(Arrays.asList("Potato","Tomato"));
		ArrayList<String> fruitList = new ArrayList<>(Arrays.asList("Apple","Mango"));
		ArrayList<String> grainList=new ArrayList<>(Arrays.asList("Chickpeas","Rice","Bread"));
		ArrayList<String> proteinList=new ArrayList<>(Arrays.asList("Chicken","Fish"));
		ArrayList<String> packList=new ArrayList<>(Arrays.asList("Noodles","Pasta"));
		model.addAttribute("dairyList", dairyList);
		model.addAttribute("vegList", vegList);
		model.addAttribute("fruitList", fruitList);
		model.addAttribute("grainList", grainList);
		model.addAttribute("proteinList", proteinList);
		model.addAttribute("packList", packList);
		return "testform";
	}
	
	@RequestMapping(value = "/testform", method = RequestMethod.POST)
	public String fetchRecipe(Ingredients ingredients, ModelMap model) {
		model.addAttribute("ingredient", ingredients);
		List<String> ingredientName = new ArrayList<>();
		ingredientName.add(ingredients.getIngredientName());
		List<Recipe> allRecipeDetail = searchControllerDao.showRecipeDetails(ingredientName);
		model.addAttribute("allRecipeDetails", allRecipeDetail);
		return "testform";
	
	}
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(Recipe recipe, ModelMap model) {
		model.addAttribute("recipe",recipe);
		List<Recipe> allRecipeDetail = searchControllerDao.fetchRecipes(recipe);
		model.addAttribute("allRecipeDetails", allRecipeDetail.get(0));	
		return "recipef";
	}
	
	
}
	