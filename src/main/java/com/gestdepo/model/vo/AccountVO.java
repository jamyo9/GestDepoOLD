package com.gestdepo.model.vo;

public abstract class AccountVO {
	
	private String userName;
	private String password;
	private String email;
	
	public AccountVO() {
		this.setUserName("userName");
		this.setEmail("Email");
		this.setPassword("pwd");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
