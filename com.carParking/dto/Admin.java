package com.carparking.dto;

public class Admin {
	private String name;
	private String password;
	private double hourly_price;

	public Admin(String string, String string2, int price) {
		this.name = string;
		this.password = string2;
		this.hourly_price = price;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public double getHourly_price() {
		return hourly_price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHourly_price(double hourly_price) {
		this.hourly_price = hourly_price;
	}
}
