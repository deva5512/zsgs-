package com.flightticketreservation.dto;

public class PassengerDetails {
	private String name;
	private int age;
	private long phno;
	private char gender;
	private String classs;

	public PassengerDetails(String name2, int age2, long phno2, char gender2, String classs) {
		this.name = name2;
		this.age = age2;
		this.phno = phno2;
		this.gender = gender2;
		this.setClass(classs);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getClasss() {
		return classs;
	}

	public void setClass(String classs) {
		this.classs = classs;
	}

}
