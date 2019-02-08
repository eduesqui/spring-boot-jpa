package com.eduesqui.springbootjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduesqui.springbootjpa.model.service.IUserBo;

@Controller
public class UserController {
	
	@Autowired
	private IUserBo userBo;
	
	@RequestMapping(value="findUsers", method=RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("title", "Users");
		model.addAttribute("users", userBo.findAll());
		return "findUsers";
		
	}

}
