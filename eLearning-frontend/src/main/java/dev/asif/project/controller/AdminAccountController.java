package dev.asif.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAccountController {

	@GetMapping("/admin/dashboard")
	public String adminDashboard(HttpSession session) {
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null) {
			return "redirect:/";
		} else if (accountType.equals("user")) {
			return "redirect:/user/dashboard";
		}

		return "admin_account/dashboard";
	}
	
	@GetMapping("/admin/profile")
	public String adminProfilePage() {
		return "admin_account/profile";
	}
	
}
