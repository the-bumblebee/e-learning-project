package dev.asif.project.controller;

import java.time.LocalDate;

import dev.asif.project.dao.UserDAO;
import dev.asif.project.dao.impl.UserDAOImpl;
import dev.asif.project.model.User;

public class UserController {
	
	public static void main(String[] args) {
		
		UserDAO dao = new UserDAOImpl();
		User user = new User(108L, "name", 23423425L, "email.com", "address", LocalDate.of(2021, 1, 21), "passowrd", "img1");
		
		dao.addUser(user);

		
	}
	
}
