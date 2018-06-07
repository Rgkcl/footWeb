package com.food.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("reg")
	public String showReg() {
		return "reg";
	}

}
