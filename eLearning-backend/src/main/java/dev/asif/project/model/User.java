package dev.asif.project.model;

import java.time.LocalDate;

//InputStream uploadPhoto
//FileInputStream -> InputStream

public class User {
	
	private Long userId;
	private String name;
	private String password;
	private Long phoneNo;
	private String email;
	private String address;
	private LocalDate regDate;
//	private byte[] uploadPhoto;
	private String uploadPhoto;
	
	public User() {
		super();
	}
	
	public User(Long userId, String name, Long phoneNo, String email, String address, LocalDate regDate, String password,
			String uploadPhoto) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.regDate = regDate;
		this.uploadPhoto = uploadPhoto;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public String getUploadPhoto() {
		return uploadPhoto;
	}
	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", email=" + email + ", address=" + address + ", regDate=" + regDate + ", uploadPhoto=" + uploadPhoto
				+ "]";
	}
	
}
