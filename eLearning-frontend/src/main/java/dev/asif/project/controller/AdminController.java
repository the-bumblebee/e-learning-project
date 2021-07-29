package dev.asif.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.asif.project.dao.AdminDAO;
import dev.asif.project.dao.impl.AdminDAOImpl;
import dev.asif.project.model.Admin;

@Controller
public class AdminController {
	
	AdminDAO adminDAO = new AdminDAOImpl();
	
	@GetMapping("/admin-list")
	public String adminsPage(Model model, HttpSession session) {
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("user"))
			return "redirect:/";
		
		List<Admin> adminList = adminDAO.findAll();
		model.addAttribute("admins", adminList);
		return "admins";
	}

}
