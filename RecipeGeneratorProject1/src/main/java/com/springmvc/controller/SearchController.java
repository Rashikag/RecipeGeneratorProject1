package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dao.SearchControllerDao;
import com.springmvc.model.Recipe;

@Controller
@SessionAttributes("name")
public class SearchController {
    
	@Autowired
	SearchControllerDao searchControllerDao;
	
	@RequestMapping(value="/recipe",method=RequestMethod.GET)
	public String showLoginPage(){
		return "recipe";
	}
	@RequestMapping(value="/recipe",method=RequestMethod.POST)
	public String recipeDetails(@RequestParam String recipeTitle,@ModelAttribute("recipeDetail") Recipe detail,ModelMap model){
		detail=searchControllerDao.validateRecipeName(recipeTitle); 
			model.addAttribute("recipeDetails", detail);
			return "recipe";
			
	}
	
	/*
	 @RequestMapping(value="/filter",method=RequestMethod.POST)
	public String recipeDetails(@RequestParam(value="ingredientType") List<String> ingredientType,
	  @RequestParam(value="veg-non",required=false) String veg-non,
	  @RequestParam(value="cuisine",required=false) String cuisine,
	  @RequestParam(value="category",required=false) String category,
	  @ModelAttribute("AllrecipeDetail") Recipe allDetails,ModelMap model){
		allDetails=searchControllerDao.showRecipeDetails(ingredientType,veg-non,cuisine,category); 
			model.addAttribute("recipeDetails", detail);
			return "filter";
	 */
}
