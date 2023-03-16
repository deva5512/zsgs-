package com.recrutmentmanagement.dto;

import java.util.LinkedList;
import java.util.Queue;

public class Candidate {

	private String name;
	private String password;
	private Resume resume;
	private boolean resume_status;

	private Queue<String> notification = new LinkedList<>();
	private Queue<String> application = new LinkedList<>();

	public Candidate(String name2, String pass) {
		this.name = name2.trim();
		this.password = pass.trim();
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Resume getResume() {
		return resume;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Queue<String> getNotification() {
		return notification;
	}

	public void setNotification(Queue<String> notification) {
		this.notification = notification;
	}

	public Queue<String> getApplication() {
		return application;
	}

	public void setApplication(Queue<String> application) {
		this.application = application;
	}

	public boolean isResume_status() {
		return resume_status;
	}

	public void setResume_status(boolean resume_status) {
		this.resume_status = resume_status;
	}
}
