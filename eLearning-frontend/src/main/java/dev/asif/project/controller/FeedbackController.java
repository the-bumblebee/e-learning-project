package dev.asif.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.asif.project.dao.FeedbackDAO;
import dev.asif.project.dao.impl.FeedbackDAOImpl;
import dev.asif.project.model.Feedback;

@Controller
public class FeedbackController {
	
	FeedbackDAO feedbackDAO = new FeedbackDAOImpl();
	
	@GetMapping("/feedback-list")
	public String feedbacksPage(Model model) {
		List<Feedback> feedbackList = feedbackDAO.findAll();
		model.addAttribute("feedbacks", feedbackList);
		return "feedbacks";
	}
	
	@GetMapping("/add-feedback")
	public String addFeedbackForm(Model model) {
		model.addAttribute("feedback", new Feedback());
		return "add-feedback";
	}
	
	@PostMapping("/add-feedback")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackDAO.addFeedback(feedback);
		return "redirect:/feedback-list";
	}
	
	@GetMapping("/delete-feedback/{f-id}")
	public String deleteFeedback(@PathVariable("f-id") Long fId) {
		feedbackDAO.deleteFeedback(fId);
		return "redirect:/feedback-list";
	}
	
	@GetMapping("/update-feedback/{f-id}")
	public String updateFeedbackForm(@PathVariable("f-id") Long fId, Model model) {
		model.addAttribute("feedback", feedbackDAO.getFeedbackById(fId));
		return "update-feedback";
	}
	
	@PostMapping("/update-feedback")
	public String updateFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackDAO.updateFeedback(feedback);
		return "redirect:/feedback-list";
	}

}
