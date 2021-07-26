package dev.asif.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import dev.asif.project.dao.UserDAO;
import dev.asif.project.model.User;
import dev.asif.project.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from user";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long userId = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phoneNo = rs.getLong("phone_no");
				String address = rs.getString("address");
				LocalDate regDate = rs.getDate("reg_date").toLocalDate();
				String password = rs.getString("password");
				String uploadPhoto = rs.getString("upload_photo");

				User user = new User(userId, name, phoneNo, email, address, regDate, password, uploadPhoto);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {

		String sql = "insert into user values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setLong(3, user.getPhoneNo());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getAddress());
			ps.setDate(6, Date.valueOf(user.getRegDate())); // Date used here is java.sql.Date and not java.util.Date
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getUploadPhoto());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User getUserById(Long userId) {

		String sql = "select * from user where user_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phoneNo = rs.getLong("phone_no");
				String address = rs.getString("address");
				LocalDate regDate = rs.getDate("reg_date").toLocalDate();
				String password = rs.getString("password");
				String uploadPhoto = rs.getString("upload_photo");

				User user = new User(userId, name, phoneNo, email, address, regDate, password, uploadPhoto);

				return user;
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean deleteUser(Long userId) {

		String sql = "delete from user where user_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateUser(User user) {

		String sql = "update user set name=?, phone_no=?, email=?, address=?, reg_date=?, password=?, upload_photo=? where user_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setLong(2, user.getPhoneNo());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setDate(5, Date.valueOf(user.getRegDate()));
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getUploadPhoto());
			ps.setLong(8, user.getUserId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
