package dev.asif.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.asif.project.command.LoginCommand;

@Controller		// Requests are made available
public class HomeController {
	
	@GetMapping("/")
	public String indexPage(Model model, HttpSession session) {
		
		// If session attribute "account-type" and "user" present, redirect to appropriate "dashboard";
		String accountType = (String) session.getAttribute("accountType");
		
		if (accountType != null) {
			
			if (accountType.equals("admin")) {
				return "redirect:/admin/dashboard";
			} else if (accountType.equals("user")) {
				return "redirect:/user/dashboard";
			}
			
		}
		
		
		model.addAttribute("message", "E Learning Portal");	
		model.addAttribute("command", new LoginCommand());
		
		String error = (String) session.getAttribute("error");
		if (error != null) {
			session.removeAttribute("error");
			model.addAttribute("error", error);
		}
		
		return "index";
	}

}
