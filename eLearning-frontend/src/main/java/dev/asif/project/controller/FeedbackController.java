package dev.asif.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
