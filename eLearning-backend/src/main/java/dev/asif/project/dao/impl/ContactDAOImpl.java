package dev.asif.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.asif.project.dao.ContactDAO;
import dev.asif.project.model.Contact;
import dev.asif.project.util.DBUtil;

public class ContactDAOImpl implements ContactDAO {
	
	Connection conn = DBUtil.getConnection();

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<Contact>();
		
		String sql = "select * from contact";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Long userId = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long phoneNo = rs.getLong("phone_no");
				String message = rs.getString("message");
				Long contactId = rs.getLong("contact_id");
				
				Contact contact = new Contact(userId, name, email, phoneNo, message, contactId);
				contacts.add(contact);
			}
			
			return contacts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addContact(Contact contact) {
		
		String sql = "insert into contact values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, contact.getUserId());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getPhoneNo());
			ps.setString(5, contact.getMessage());
			ps.setLong(6, contact.getContactId());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Contact getContactById(Long contactId) {
		
		String sql = "select * from contact where contact_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, contactId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Long userId = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long phoneNo = rs.getLong("phone_no");
				String message = rs.getString("message");
				
				Contact contact = new Contact(userId, name, email, phoneNo, message, contactId);
				
				return contact;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteContact(Long contactId) {

		String sql = "delete from contact where contact_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, contactId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateContact(Contact contact) {

		String sql = "update contact set user_id=?, name=?, email=?, phone_no=?, message=? where contact_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, contact.getUserId());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getPhoneNo());
			ps.setString(5, contact.getMessage());
			
			ps.setLong(6, contact.getContactId());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}

}
