package dev.asif.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.asif.project.command.LoginCommand;

@Controller
public class LoginController {

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("command") LoginCommand command, Model model) {
		model.addAttribute("command", command);
		if (command.getEmail().equals("asif")) {
			return "login";
		} else {
			model.addAttribute("error", "Login credentials are incorrect!");
			return "index";
		}
	}
	
}
