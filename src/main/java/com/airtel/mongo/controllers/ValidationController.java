package com.airtel.mongo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airtel.mongo.models.User;

@Controller
public class ValidationController {
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userAttr") @Valid User user, BindingResult result, ModelMap model,
			HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("ERROR");
			return new ModelAndView("login");
		}
		else if (!user.getUsername().equalsIgnoreCase("admin") || !user.getPassword().equals("admin")) {
			model.addAttribute("msg", "Bad Credentials");

			return new ModelAndView("login");
			// connectivity to db here
		} else {
			session.setAttribute("username", user.getUsername());
			model.addAttribute("username", user.getUsername());
			return new ModelAndView("admin");
		}
	}

}
