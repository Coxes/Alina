package com.coxes.alina.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coxes.alina.service.UserService;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String home() {
		userService.findAll();
		System.out.println(userService);
		return "/index";
	}
}
