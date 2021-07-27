package dev.asif.project.command;

public class LoginCommand {
	
	private String email;
	private String password;
	private String accountType;
	
	public LoginCommand() { }
	
	public LoginCommand(String email, String password, String accountType) {
		super();
		this.email = email;
		this.password = password;
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
