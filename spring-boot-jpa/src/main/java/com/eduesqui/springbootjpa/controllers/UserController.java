package com.eduesqui.springbootjpa.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduesqui.springbootjpa.model.entitys.UserEntity;
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
	
	@RequestMapping(value="createUser", method=RequestMethod.GET)
	public String createUser(Map<String, Object> model) {
		model.put("title", "Create User");
		UserEntity user = new UserEntity();
		model.put("user", user);
	
		return "createUser";
		
	}
	
	
	
	@RequestMapping(value="saveUser", method=RequestMethod.POST)
	public String createUser(UserEntity user) {
		userBo.save(user);
		return "redirect:findUsers";
		
	}

}
