package com.eduesqui.springbootjpa.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

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
	
//	@RequestMapping(value="/createUser", method=RequestMethod.GET)
//	public String createUser(Map<String, Object> model) {
//		UserEntity user = new UserEntity();
//		model.put("title", "Create User");
//		model.put("user", user);
//	
//		return "createUser";
//		
//	}
//	
//	
//	
//	@RequestMapping(value="/createUser", method=RequestMethod.POST)
//	public String saveUser(@Valid UserEntity user,  BindingResult result,Map<String, Object> model) {
//		if (result.hasErrors()) {
//			
//			model.put("title", "Create User");
//			model.put("user", user);
//			
//			
//			return "createUser";
//		}
//		userBo.save(user);
//		return "redirect:findUsers";
//		
//	}

	
	@RequestMapping(value = "/createUser")
	public String crear(Map<String, Object> model) {

		UserEntity userEntity = new UserEntity();
		model.put("userEntity", userEntity);
		model.put("title", "Create user");
		return "createUser";
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String guardar(@Valid UserEntity userEntity, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Create user");
			model.addAttribute("userEntity", userEntity);
			return "createUser";
		}

		userBo.save(userEntity);
//		return "redirect:findUsers";
		status.setComplete();
		return "redirect:findUsers";
	}
}
