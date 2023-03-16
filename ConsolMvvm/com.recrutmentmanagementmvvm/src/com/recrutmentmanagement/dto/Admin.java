package com.recrutmentmanagement.dto;

import java.util.LinkedList;
import java.util.Queue;

public class Admin {
	private String name;
	private String password;
	private long mobileNumber;
	private double postprice = 10000;

	private Queue<String> notification = new LinkedList<>();

	public Admin(String name, String pass, long number) {
		this.name = name.trim();
		this.password = pass.trim();
		this.mobileNumber = number;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public void setPassword(String password) {
		this.password = password.trim();
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Queue<String> getNotification() {
		return notification;
	}

	public void setNotification(Queue<String> notification) {
		this.notification = notification;
	}

	public double getPostprice() {
		return postprice;
	}

	public void setPostprice(double postprice) {
		this.postprice = postprice;
	}

}
