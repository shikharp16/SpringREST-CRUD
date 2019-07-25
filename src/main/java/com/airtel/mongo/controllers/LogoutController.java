package com.airtel.mongo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.airtel.mongo.models.User;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView user(HttpSession session) {

		if(session.getAttribute("username") != null) {
			session.invalidate();
		}
		return new ModelAndView("login", "userAttr", new User());
	}
}
