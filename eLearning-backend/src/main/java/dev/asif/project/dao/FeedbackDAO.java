package dev.asif.project.dao;

import java.util.List;

import dev.asif.project.model.Feedback;

public interface FeedbackDAO {

	List<Feedback> findAll();
	boolean addFeedback(Feedback feedback);
	Feedback getFeedbackById(Long fId);
	boolean deleteFeedback(Long fId);
	boolean updateFeedback(Feedback feedback);
	
}
