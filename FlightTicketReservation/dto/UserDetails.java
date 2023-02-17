package com.flightticketreservation.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDetails {

	private String name;
	private int age;
	private long ph_no;
	private char gender;
	private String email;
	private String password;
	private AccountDetails accountDetails;

	private Map<String, List<Integer>> bookedSeats = new HashMap<>();

	public UserDetails(String name, int age, long number, char gender, String mail, String password) {
		this.name = name;
		this.age = age;
		this.ph_no = number;
		this.gender = gender;
		this.email = mail;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Map<String, List<Integer>> getBookedSeats() {
		return bookedSeats;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	@Override
	public String toString() {

		System.out.println("User Name : " + name);
		System.out.println("User age : " + age);
		System.out.println("User Mobile Number : " + ph_no);
		System.out.println("User Gender : " + gender);
		System.out.println("User email id : " + email);
		System.out.println("User password : " + password);

		if (accountDetails != null) {
			System.out.println("Bank Name : " + accountDetails.getBank_name());
			System.out.println("Account number : " + accountDetails.getAccountnumber());
		} else {
			System.out.println("Bank Name : NA ");
			System.out.println("Account number : NA");
		}

		return "";
	}
}
