package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.dao.LoginControllerDao;

@Controller
@SessionAttributes("name")
public class LoginController  {
	

	@Autowired
	LoginControllerDao loginControllerDao;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,@RequestParam String password,ModelMap model){
		if(!loginControllerDao.validateLogin(name, password)) {
			model.put("errorMessage","Invalid Credentials! Please Sign Up!");
			return "login";
		}
		model.put("name",name);
		return "redirect:/filter";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)//produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestParam String username,@RequestParam String password,@RequestParam String gmail){
		loginControllerDao.insertUser(username,password,gmail);
	    return "login";
	}
}
