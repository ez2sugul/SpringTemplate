package com.woniper.spring.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -7948360071399248554L;
	
	private long id;
	private String password;
	private String lastLogin;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", lastLogin="
				+ lastLogin + "]";
	}
	
}
