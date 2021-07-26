package dev.asif.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.asif.project.dao.FeedbackDAO;
import dev.asif.project.model.Feedback;
import dev.asif.project.util.DBUtil;

public class FeedbackDAOImpl implements FeedbackDAO {
	
	Connection conn = DBUtil.getConnection();

	@Override
	public List<Feedback> findAll() {

		List<Feedback> feedbacks = new ArrayList<Feedback>();
		
		String sql = "select * from feedback";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				long userId = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long fId = rs.getLong("f_id");
				String feedbackString = rs.getString("feedback");
				Feedback feedback = new Feedback(userId, name, email, fId, feedbackString);
				feedbacks.add(feedback);
			}
			return feedbacks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		
		String sql = "insert into feedback values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, feedback.getUserId());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setLong(4, feedback.getfId());
			ps.setString(5, feedback.getFeedback());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Feedback getFeedbackById(Long fId) {
		
		String sql = "select * from feedback where f_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, fId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				long userId = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String feedbackString = rs.getString("feedback");
				Feedback feedback = new Feedback(userId, name, email, fId, feedbackString);
				
				return feedback;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteFeedback(Long fId) {

		String sql = "delete from feedback where f_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, fId);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateFeedback(Feedback feedback) {

		String sql = "update feedback set user_id=?, name=?, email=?, feedback=? where f_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, feedback.getUserId());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setString(4, feedback.getFeedback());
			ps.setLong(5, feedback.getfId());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
