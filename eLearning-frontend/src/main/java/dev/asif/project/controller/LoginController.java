package dev.asif.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dev.asif.project.command.LoginCommand;
import dev.asif.project.dao.AdminDAO;
import dev.asif.project.dao.UserDAO;
import dev.asif.project.dao.impl.AdminDAOImpl;
import dev.asif.project.dao.impl.UserDAOImpl;
import dev.asif.project.model.Admin;
import dev.asif.project.model.User;

@Controller
@SessionAttributes("error")
public class LoginController {

	@PostMapping("/login")
	public String loginValidation(@ModelAttribute("command") LoginCommand command, HttpSession session) {

		Admin admin = null;
		User user = null;

		if (command.getAccountType().equals("admin")) {
			AdminDAO adminDAO = new AdminDAOImpl();
			admin = adminDAO.getAdminByEmailAndPassword(command.getEmail(), command.getPassword());

			if (admin != null) {
				admin.setPassword(null);
				session.setAttribute("accountType", command.getAccountType());
				session.setAttribute("user", admin);
				session.setAttribute("userId", admin.getAdminId());
				return "redirect:/admin/dashboard";
			} else {
				session.setAttribute("error", "Login credentials are incorrect!");
				return "redirect:/";
			}

		} else if (command.getAccountType().equals("user")) {
			UserDAO userDAO = new UserDAOImpl();
			user = userDAO.getUserByEmailAndPassword(command.getEmail(), command.getPassword());

			if (user != null) {
				user.setPassword(null);
				session.setAttribute("accountType", command.getAccountType());
				session.setAttribute("user", user);
				session.setAttribute("userId", user.getUserId());
				return "redirect:/user/dashboard";
			} else {
				session.setAttribute("error", "Login credentials are incorrect!");
				return "redirect:/";
			}
			
		}

		return "redirect:/";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
