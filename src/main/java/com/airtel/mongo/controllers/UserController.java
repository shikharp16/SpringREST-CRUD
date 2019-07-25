package com.airtel.mongo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airtel.mongo.models.User;

@Controller
public class UserController {

	@RequestMapping("/")
	public String printHello() {
		return "index";
	}

	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("login", "userAttr", new User());
	}

}
