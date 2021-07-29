package dev.asif.project.dao;

import java.util.List;

import dev.asif.project.model.Admin;

public interface AdminDAO {
	
	List<Admin> findAll();
	boolean addAdmin(Admin admin);
	Admin getAdminById(Long adminId);
	Admin getAdminByEmailAndPassword(String email, String password);
	boolean deleteAdmin(Long adminId);
	boolean updateAdmin(Admin admin);
	
}
