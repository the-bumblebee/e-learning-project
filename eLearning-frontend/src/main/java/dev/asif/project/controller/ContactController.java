package dev.asif.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.asif.project.dao.ContactDAO;
import dev.asif.project.dao.impl.ContactDAOImpl;
import dev.asif.project.model.Contact;

@Controller
public class ContactController {
	
	ContactDAO contactDAO = new ContactDAOImpl();
	
	@GetMapping("/contact-list")
	public String contactsPage(Model model) {
		List<Contact> contactList = contactDAO.findAll();
		model.addAttribute("contacts", contactList);
		return "contacts";
	}
	
	@GetMapping("/add-contact")
	public String addContactForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "add-contact";
	}
	
	@PostMapping("/add-contact")
	public String addContact(@ModelAttribute("contact") Contact contact) {
		contactDAO.addContact(contact);
		return "redirect:/contact-list";
	}
	
	@GetMapping("/delete-contact/{contact-id}")
	public String deleteContact(@PathVariable("contact-id") Long contactId) {
		contactDAO.deleteContact(contactId);
		return "redirect:/contact-list";
	}
	
	@GetMapping("/update-contact/{contact-id}")
	public String updateContactForm(@PathVariable("contact-id") Long contactId, Model model) {
		model.addAttribute("contact", contactDAO.getContactById(contactId));
		return "update-contact";
	}
	
	@PostMapping("/update-contact")
	public String updateContact(@ModelAttribute("contact") Contact contact) {
		contactDAO.updateContact(contact);
		return "redirect:/contact-list";
	}

}
