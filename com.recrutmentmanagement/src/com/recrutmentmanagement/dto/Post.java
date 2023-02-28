package com.recrutmentmanagement.dto;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Post {

	private Hr hr;
	private String role;
	private int views;
	private String qualification;
	private LocalDate dateofpost;
	private List<Candidate> applied = new LinkedList<>();
	private double price;

	public Post(String qualification, String role, LocalDate date, Hr hr, double price) {
		this.qualification = qualification;
		this.role = role;
		this.dateofpost = date;
		this.hr = hr;
		this.price = price;
	}

	public String getQualification() {
		return qualification;
	}

	public LocalDate getDateofpost() {
		return dateofpost;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void setDateofpost(LocalDate dateofpost) {
		this.dateofpost = dateofpost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	public List<Candidate> getApplied() {
		return applied;
	}

	public void setApplied(List<Candidate> applied) {
		this.applied = applied;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

}
