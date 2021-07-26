package dev.asif.project.dao;

import java.util.List;

import dev.asif.project.model.Contact;

public interface ContactDAO {

	List<Contact> findAll();
	boolean addContact(Contact contact);
	Contact getContactById(Long contactId);
	boolean deleteContact(Long contactId);
	boolean updateContact(Contact contact);
	
}
