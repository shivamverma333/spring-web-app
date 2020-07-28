package com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedin");
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/";
		
	}
	

}
