package com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dao.SearchControllerDao;
import com.springmvc.model.Ingredients;
import com.springmvc.model.Recipe;
import com.springmvc.model.RecipeListObject;

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
	public String showPage() {
		return "filter";
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
	/*@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(@RequestParam(value = "ingredientName") String ingredientName,
			@ModelAttribute("allRecipeDetail") RecipeListObject allRecipeDetails, ModelMap model) {
		ArrayList<String> ing=new ArrayList<String>();
		ing.add(ingredientName);
		RecipeListObject allRecipeDetail = searchControllerDao.showRecipeDetails(ing);
	//	int cSize = ingredientName.size();
	//	model.put("cSize", cSize);
		model.addAttribute("allRecipeDetails", allRecipeDetail);
		return "filter";
	}*/
}
	/*@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(@RequestParam String ingredientName,
			@ModelAttribute("allrecipeDetail") RecipeListObject allRecipeDetails, ModelMap model) {
		
		RecipeListObject allRecipeDetail= searchControllerDao.showRecipeDetails(ingredientName);
		model.addAttribute("allRecipeDetails", allRecipeDetail);
		return "filter";
	}
}*/
/*
 * @RequestParam(value="veg-non",required=false) String veg_non,
 * 
 * @RequestParam(value="cuisine",required=false) String cuisine,
 * 
 * @RequestParam(value="category",required=false) String category,
 */
