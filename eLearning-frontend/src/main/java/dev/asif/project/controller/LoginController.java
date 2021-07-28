package dev.asif.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.asif.project.command.LoginCommand;

@Controller
@SessionAttributes("error")
public class LoginController {

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("command") LoginCommand command, Model model, HttpSession session) {
		model.addAttribute("command", command);
		if (command.getEmail().equals("asif")) {
			return "login";
		} else {
//			model.addAttribute("error", "Login credentials are incorrect!");
			session.setAttribute("error", "Login credentials are incorrect!");
			return "redirect:/";
		}
	}
	
}
