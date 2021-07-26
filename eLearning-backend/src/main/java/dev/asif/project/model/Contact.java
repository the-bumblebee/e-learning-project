package dev.asif.project.model;

public class Contact {
	
	private Long userId;
	private String name;
	private String email;
	private Long phoneNo;
	private String message;
	private Long contactId;
	
	
	
	public Contact() {
		super();
	}

	public Contact(Long userId, String name, String email, Long phoneNo, String message, Long contactId) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.message = message;
		this.contactId = contactId;
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

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "Contact [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", message=" + message + ", contactId=" + contactId + "]";
	}

}
