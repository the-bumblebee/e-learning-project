package dev.asif.project.model;

public class Feedback {
	
	private Long userId;
	private String name;
	private String email;
	private Long fId;
	private String feedback;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Feedback(Long userId, String name, String email, Long fId, String feedback) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.fId = fId;
		this.feedback = feedback;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getfId() {
		return fId;
	}
	
	public void setfId(Long fId) {
		this.fId = fId;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [userId=" + userId + ", name=" + name + ", email=" + email + ", fId=" + fId + ", feedback="
				+ feedback + "]";
	}
	
}
