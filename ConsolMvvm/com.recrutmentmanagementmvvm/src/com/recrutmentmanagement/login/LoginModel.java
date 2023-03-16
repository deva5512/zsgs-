package com.recrutmentmanagement.login;

import java.util.List;
import java.util.Queue;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

import repository.RecrutmentDb;

public class LoginModel {

	private LoginView loginView;

	public LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void checkForAdmin(String name, String pass) {
		if (RecrutmentDb.getInstance().getAdmin().getName().equalsIgnoreCase(name.trim())
				&& RecrutmentDb.getInstance().getAdmin().getPassword().equalsIgnoreCase(pass.trim())) {

			loginView.adminVerified(name);
		} else {
			loginView.verificationFailed("Improper User name or Password");
		}
	}

	public List<Post> getPostHistory() {
		return RecrutmentDb.getInstance().getPost();
	}

	public Admin getAdmin() {
		return RecrutmentDb.getInstance().getAdmin();
	}

	public void changeAdminDetails(String name, String pass, long phno) {

		Admin admin = getAdmin();

		if (name != null) {
			admin.setName(name);
		} else if (pass != null) {
			admin.setPassword(pass);
		} else {
			admin.setMobileNumber(phno);
		}
	}

	public void registerCandidate(String name, String pass) {
		
		Candidate candidate = new Candidate(name, pass);

		if (RecrutmentDb.getInstance().containsCandidate(name, pass)) {
			loginView.verificationFailed("Try Some other User name or password ");
		} else {
			RecrutmentDb.getInstance().getCandidates().add(candidate);

			RecrutmentDb.getInstance().getAdmin().getNotification()
					.offer(name + " has created new Candidate Account ");

			candidate.getNotification().offer("Thanks for Creating Account " + name);

			loginView.candidateLogin(candidate);
		}

	}

	public void registerHr(String name, String pass, String organization) {
		
		Hr hr = new Hr(name, pass, organization);

		if (RecrutmentDb.getInstance().containsHr(name, pass)) {
			loginView.verificationFailed("Try Some other User name or password ");
		} else {
			RecrutmentDb.getInstance().getHrlist().add(hr);

			RecrutmentDb.getInstance().getAdmin().getNotification()
					.offer(name + " has created new Hr Account ");

			hr.getNotification().offer("Thanks for Creating Account " + name);

			loginView.hrLogin(hr);
		}

	}

	public void hrLoginCredential(String name, String pass) {
		if (RecrutmentDb.getInstance().containsHr(name, pass)) {

			Hr hr = RecrutmentDb.getInstance().getValidHr(name, pass);
			loginView.hrLogin(hr);

		} else {
			loginView.verificationFailed("Invalid user name or password ");
		}
	}

	public void userLoignCredential(String name, String pass) {
		if (RecrutmentDb.getInstance().containsCandidate(name, pass)) {

			Candidate candidate = RecrutmentDb.getInstance().getValidCandidate(name, pass);
			loginView.candidateLogin(candidate);

		} else {
			loginView.verificationFailed("Invalid user name or password ");
		}
	}

	public Queue<String> getNotification() {
		return getAdmin().getNotification();
	}
}
