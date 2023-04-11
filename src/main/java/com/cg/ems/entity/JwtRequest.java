package com.cg.ems.entity;

public class JwtRequest {

	private String userName;
	private String userPassword;
	
	
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
