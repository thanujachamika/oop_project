package com.nops.model;

public class UserModel {
	private int userId;
	private String userName;
	private String password;
	private String accountType;
	
	public UserModel() {
		
	}
	public UserModel(int userId, String userName, String password, String accountType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.accountType = accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
