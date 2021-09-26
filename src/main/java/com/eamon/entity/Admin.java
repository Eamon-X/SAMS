package com.eamon.entity;

public class Admin {
	private String account;
	private String password;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin(String Account,String Password) {
		// TODO Auto-generated constructor stub
		 this.account = Account;
		 this.password = Password;
		 
	}
}
