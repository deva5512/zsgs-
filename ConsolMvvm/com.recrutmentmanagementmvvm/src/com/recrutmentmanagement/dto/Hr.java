package com.recrutmentmanagement.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hr {
	private String name;
	private String password;
	private String company_name;

	private Queue<String> notification = new LinkedList<>();
	private List<Post> posted = new LinkedList<>();

	public Hr(String name2, String pass, String organization) {
		this.name = name2.trim();
		this.password = pass.trim();
		this.company_name = organization;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Queue<String> getNotification() {
		return notification;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public void setNotification(Queue<String> notification) {
		this.notification = notification;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public List<Post> getPosted() {
		return posted;
	}

	public void setPosted(List<Post> posted) {
		this.posted = posted;
	}
}
