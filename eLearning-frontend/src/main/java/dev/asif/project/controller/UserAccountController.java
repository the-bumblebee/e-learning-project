package dev.asif.project.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dev.asif.project.dao.UserDAO;
import dev.asif.project.dao.impl.UserDAOImpl;
import dev.asif.project.model.User;

@Controller
public class UserAccountController {
	
	UserDAO userDAO = new UserDAOImpl();
	
	@GetMapping("/user/dashboard")
	public String userDashboard(HttpSession session) {
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null) {
			return "redirect:/";
		} else if (accountType.equals("admin")) {
			return "redirect:/admin/dashboard";
		}

		return "user_account/dashboard";
	}
	
	@GetMapping("/user/profile")
	public String userProfilePage(HttpSession session, Model model) {
		long userId = (long) session.getAttribute("userId");
		model.addAttribute("user", userDAO.getUserById(userId));
		return "user_account/profile";
	}
	
	@GetMapping("/user/update")
	public String userUpdatePage(HttpSession session, Model model) {
		
		long userId = (long) session.getAttribute("userId");
		User user = userDAO.getUserById(userId);
		model.addAttribute("user", user);
		return "user_account/update";

	}
	
	@PostMapping("/user/update")
	public String uerUpdate(@ModelAttribute("user") User user, @RequestParam("reg-date") String regDate,
			@RequestParam("upload-photo") MultipartFile file, HttpSession session) {

		byte[] fileBytes = null;

		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String base64UploadPhoto;

		if (fileBytes == null || fileBytes.length == 0) {
			base64UploadPhoto = userDAO.getUserById(user.getUserId()).getUploadPhoto();
		} else {
			base64UploadPhoto = Base64Utils.encodeToString(fileBytes);
		}

		user.setUploadPhoto(base64UploadPhoto);
		LocalDate date = LocalDate.parse(regDate);
		user.setRegDate(date);

		userDAO.updateUser(user);
		
		user.setPassword(null);
		session.setAttribute("user", user);

		return "redirect:/user/profile";
		
	}

}
