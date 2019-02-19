package com.eduesqui.springbootjpa.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduesqui.springbootjpa.model.entitys.UserEntity;
import com.eduesqui.springbootjpa.model.service.IUserBo;

@Controller
@SessionAttributes("userEntity")
public class UserController {
	
	@Autowired
	private IUserBo userBo;
	
	@RequestMapping(value="findUsers", method=RequestMethod.GET)
	public String showUsers(Model model) {
		model.addAttribute("title", "Users");
		model.addAttribute("users", userBo.findAll());
		return "findUsers";
		
	}
	


	
	@RequestMapping(value = "/createUser")
	public String createUser(Map<String, Object> model) {

		UserEntity userEntity = new UserEntity();
		model.put("userEntity", userEntity);
		model.put("title", "Create user");
		return "createUser";
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@Valid UserEntity userEntity, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("title", "Create user");
			return "createUser";
		}

		if (userEntity.getName().equals("admin")) {
			model.addAttribute("title", "Create user");
			model.addAttribute("error", "No puede ser administrador");
			return "createUser";
		}
		
		userBo.save(userEntity);
		status.setComplete();
		return "redirect:findUsers";
	}
	
	@RequestMapping (value="/createUser/{id}" )
	public String  editUser(@PathVariable (value="id")Long id,  Map<String, Object> model) {
		if(id>0) {
			model.put("userEntity", userBo.findOne(id));
			model.put("title", "Create user");
			return "createUser";
		}else {
			return "redirect:findUsers";
		}
	}
}
