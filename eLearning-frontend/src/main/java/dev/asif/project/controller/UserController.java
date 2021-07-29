package dev.asif.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dev.asif.project.dao.UserDAO;
import dev.asif.project.dao.impl.UserDAOImpl;
import dev.asif.project.model.User;

@Controller
public class UserController {

//	@Autowired
//	UserDAO userDAO;		// Cannot be used as backend is not a Spring Core application

	UserDAO userDAO = new UserDAOImpl();

	@GetMapping("/user-list")
	public String usersPage(Model model, HttpSession session) {
		
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("user"))
			return "redirect:/";

		List<User> userList = userDAO.findAll();
		model.addAttribute("users", userList);
		return "user/users";

	}

	@GetMapping("/add-user")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user/add-user";
	}

	@PostMapping("/add-user")
	public String addUser(@ModelAttribute("user") User user, @RequestParam("reg-date") String regDate,
			@RequestParam("upload-photo") MultipartFile file, HttpSession session) {

		byte[] fileBytes = null;

		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String base64UploadPhoto = Base64Utils.encodeToString(fileBytes);

		user.setUploadPhoto(base64UploadPhoto);
		LocalDate date = LocalDate.parse(regDate);
		user.setRegDate(date);

		userDAO.addUser(user);
		
		session.setAttribute("error", "Account created! Please Login!");

		return "redirect:/"; // Redirects to list of users
	}

	@GetMapping("/delete-user/{user-id}")
	public String deleteUser(@PathVariable("user-id") Long userId, HttpSession session) {
		
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("user"))
			return "redirect:/";
		
		userDAO.deleteUser(userId);
		return "redirect:/user-list";
	}

}
