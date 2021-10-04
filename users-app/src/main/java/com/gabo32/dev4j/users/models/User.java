package com.gabo32.dev4j.users.models;

public class User {

	private String username;
	private String password;
	private String nickName;
	
	public User() {
		
	}
	
	public User(String nickName, String username, String password) {
		this.username = username;
		this.password = password;
		this.nickName = nickName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
