package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(@RequestParam(value = "ingredientName") List<String> ingredientName,
			@ModelAttribute("allrecipeDetails") List<Recipe> allRecipeDetails, ModelMap model) {
		List<String> ingredientDetails=new ArrayList<String>();
		ingredientDetails.addAll(ingredientName);
		System.out.println(ingredientDetails);
		List<Recipe> allRecipeDetail = searchControllerDao.showRecipeDetails(ingredientDetails);
	//	int cSize = ingredientName.size();
	//	model.put("cSize", cSize);
		model.addAttribute("allRecipeDetails", allRecipeDetail);
		return "filter";
	}
}
	/*@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String recipeDetails(@RequestParam(value = "category") String category,
			@ModelAttribute("allrecipeDetail") List<Recipe> allRecipeDetails, ModelMap model) {
		allRecipeDetails = searchControllerDao.showRecipeDetails(category);
		model.addAttribute("allRecipeDetails", allRecipeDetails);
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
