package dev.asif.project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
	public String usersPage(Model model) {

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
			@RequestParam("upload-photo") MultipartFile file) {

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

		return "redirect:/user-list"; // Redirects to list of users
	}

	@GetMapping("/delete-user/{user-id}")
	public String deleteUser(@PathVariable("user-id") Long userId) {
		userDAO.deleteUser(userId);
		return "redirect:/user-list";
	}

	@GetMapping("/update-user/{user-id}")
	public String updateUserForm(@PathVariable("user-id") Long userId, Model model) {
		User user = userDAO.getUserById(userId);
		model.addAttribute("user", user);
		return "user/update-user";
	}

	@PostMapping("/update-user")
	public String updateUser(@ModelAttribute("user") User user, @RequestParam("reg-date") String regDate,
			@RequestParam("upload-photo") MultipartFile file) {
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

		return "redirect:/user-list"; // Redirects to list of users
	}

}
