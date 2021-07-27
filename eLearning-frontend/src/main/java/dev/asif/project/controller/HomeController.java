package dev.asif.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.asif.project.command.LoginCommand;

@Controller		// Requests are made available
public class HomeController {

//	@GetMapping("/")		// @RequestMapping  // Old annotation
//	public String indexPage() {
//		return "index";
//	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("message", "Welcome to eLearning Portal");		// Attribute name, Attribute value
//		List<String> names = Arrays.asList("Mohit", "Bharat", "Ankit", "Mohan");
//		model.addAttribute("names", names);
		model.addAttribute("command", new LoginCommand());
		return "index";
	}

}
