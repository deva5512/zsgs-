package com.flightticketreservation.dto;

public class Admin {
	private String name;
	private String userid;
	private String password;

	public Admin(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
