package com.rajib.test.vo;


public class UserDetailsVo {
	private String username;
	private String password;
	private String id;
	
	public UserDetailsVo(){}
	
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
	public UserDetailsVo(String username, String password, String id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserDetailsVo [username=" + username + ", password=" + password
				+ ", id=" + id + "]";
	}
	
}
