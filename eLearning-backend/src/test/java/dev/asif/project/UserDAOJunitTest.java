package dev.asif.project;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import dev.asif.project.dao.UserDAO;
import dev.asif.project.dao.impl.UserDAOImpl;
import dev.asif.project.model.User;

class UserDAOJunitTest {
	
	static UserDAO dao = null;

	@BeforeAll
	public static void init() {
		dao = new UserDAOImpl();
	}
	
	@AfterAll
	public static void destroy() {
		dao.deleteUser(107L);
		dao = null;
	}
	
	@Test
//	@Order(4)
	void test_get_all_users_success() {
		List<User> users = dao.findAll();
		
		int expected = 5;
		int actual = users.size();
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	@Order(5)
	void test_get_username_from_all_success(){
		List<User> users = dao.findAll();
		
		String expected = "Rahul";
		String actual = users.get(1).getName();
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	@Order(1)
	void test_add_user_success() {
		User user = new User(107L, "Anoop", 9495687990L, "anoop@gmail.com", "Kolkata", LocalDate.of(2021, 3, 26), "anoop", "img1.jpg");
		assertTrue(dao.addUser(user));
	}
	
//	@Test
//	@Order(2)
	void test_update_user_success() {
		User user = dao.getUserById(107L);
		user.setAddress("Delhi");
		dao.updateUser(user);
		
		String expected = "Delhi";
		String actual = dao.getUserById(107L).getAddress();
		
		assertEquals(expected, actual);
	}
	
//	@Test
//	@Order(3)
//	void test_delete_user_success() {
//		assertTrue(dao.deleteUser(107L));
//	}
	


}
