package dev.asif.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.asif.project.dao.AdminDAO;
import dev.asif.project.model.Admin;
import dev.asif.project.util.DBUtil;

public class AdminDAOImpl implements AdminDAO {
	
	Connection conn = DBUtil.getConnection();

	@Override
	public List<Admin> findAll() {

		List<Admin> admins = new ArrayList<Admin>();
		
		String sql = "select * from admin";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long adminId = rs.getLong("admin_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				Admin admin = new Admin(adminId, name, email, password);
				admins.add(admin);
			}
			
			return admins;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {

		String sql = "insert into admin values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, admin.getAdminId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getPassword());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Admin getAdminById(Long adminId) {

		String sql = "select * from admin where admin_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, adminId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				Admin admin = new Admin(adminId, name, email, password);
				return admin;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Admin getAdminByEmailAndPassword(String email, String password) {

		String sql = "select * from admin where email = ? and password = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				long adminId = rs.getLong("admin_id");
				String name = rs.getString("name");
				
				Admin admin = new Admin(adminId, name, email, password);
				return admin;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteAdmin(Long adminId) {

		String sql = "delete from admin where admin_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, adminId);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateAdmin(Admin admin) {

		String sql = "update admin set name=?, email=?, password=? where admin_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			
			ps.setLong(4, admin.getAdminId());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
