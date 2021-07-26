package dev.asif.project.dao;

import java.util.List;

import dev.asif.project.model.User;

public interface UserDAO {
	
	List<User> findAll();
	boolean addUser(User user);
	User getUserById(Long userId);
	boolean deleteUser(Long userId);
	boolean updateUser(User user);
}
