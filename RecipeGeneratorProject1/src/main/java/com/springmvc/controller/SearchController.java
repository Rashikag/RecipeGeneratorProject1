package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String recipeDetails(@RequestParam String recipeTitle,ModelMap model){
		String detail=searchControllerDao.validateRecipeName(recipeTitle); 
			model.put("recipeDetails", detail);
			return "recipe";
			
	}
}
