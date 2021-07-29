package dev.asif.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.asif.project.dao.FeedbackDAO;
import dev.asif.project.dao.impl.FeedbackDAOImpl;
import dev.asif.project.model.Feedback;
import dev.asif.project.model.User;

@Controller
public class FeedbackController {

	FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

	@GetMapping("/feedback-list")
	public String feedbacksPage(Model model, HttpSession session) {
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null)
			return "redirect:/";
		
		List<Feedback> feedbackList = feedbackDAO.findAll();
		model.addAttribute("feedbacks", feedbackList);
		return "feedback/feedbacks";
	}

	@GetMapping("/add-feedback")
	public String addFeedbackForm(Model model, HttpSession session) {
		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("admin"))
			return "redirect:/feedback-list";

		User user = (User) session.getAttribute("user");
		Feedback feedback = new Feedback();
		feedback.setEmail(user.getEmail());
		feedback.setName(user.getName());
		feedback.setUserId(user.getUserId());
		model.addAttribute("feedback", feedback);
		return "feedback/add-feedback";
	}

	@PostMapping("/add-feedback")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackDAO.addFeedback(feedback);
		return "redirect:/feedback-list";
	}

	@GetMapping("/delete-feedback/{f-id}")
	public String deleteFeedback(@PathVariable("f-id") Long fId, HttpSession session) {

		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("admin"))
			return "redirect:/feedback-list";

		if (feedbackDAO.getFeedbackById(fId).getUserId() != ((long) session.getAttribute("userId")))
			return "redirect:/feedback-list";

		feedbackDAO.deleteFeedback(fId);
		return "redirect:/feedback-list";
	}

	@GetMapping("/update-feedback/{f-id}")
	public String updateFeedbackForm(@PathVariable("f-id") Long fId, Model model, HttpSession session) {

		String accountType = (String) session.getAttribute("accountType");

		if (accountType == null || accountType.equals("admin"))
			return "redirect:/feedback-list";

		if (feedbackDAO.getFeedbackById(fId).getUserId() != ((long) session.getAttribute("userId")))
			return "redirect:/feedback-list";

		model.addAttribute("feedback", feedbackDAO.getFeedbackById(fId));
		return "feedback/update-feedback";
	}

	@PostMapping("/update-feedback")
	public String updateFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackDAO.updateFeedback(feedback);
		return "redirect:/feedback-list";
	}

}
