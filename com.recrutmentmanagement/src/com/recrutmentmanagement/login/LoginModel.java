package com.recrutmentmanagement.login;

import java.util.List;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

import repository.RecrutmentDb;

public class LoginModel implements LoginModelCallBack {

	private LoginModelControllerCall logincontroller;

	public LoginModel(LoginModelControllerCall loginController2) {
		this.logincontroller = loginController2;
	}

	@Override
	public void checkForAdmin(String name, String pass) {
		if (RecrutmentDb.getInstance().getAdmin().getName().equalsIgnoreCase(name.trim())
				&& RecrutmentDb.getInstance().getAdmin().getPassword().equalsIgnoreCase(pass.trim())) {

			logincontroller.adminVerified(name);
		} else {
			logincontroller.verificationFailed("Improper User name or Password");
		}
	}

	@Override
	public List<Post> getPostHistory() {
		return RecrutmentDb.getInstance().getPost();
	}

	@Override
	public Admin getAdmin() {
		return RecrutmentDb.getInstance().getAdmin();
	}

	@Override
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

	@Override
	public void registerCandidate(Candidate candidate) {

		if (RecrutmentDb.getInstance().containsCandidate(candidate.getName(), candidate.getPassword())) {
			logincontroller.verificationFailed("Try Some other User name or password ");
		} else {
			RecrutmentDb.getInstance().getCandidates().add(candidate);

			RecrutmentDb.getInstance().getAdmin().getNotification()
					.offer(candidate.getName() + " has created new Candidate Account ");

			candidate.getNotification().offer("Thanks for Creating Account " + candidate.getName());

			logincontroller.candidateLogin(candidate);
		}

	}

	@Override
	public void registerHr(Hr hr) {

		if (RecrutmentDb.getInstance().containsHr(hr.getName(), hr.getPassword())) {
			logincontroller.verificationFailed("Try Some other User name or password ");
		} else {
			RecrutmentDb.getInstance().getHrlist().add(hr);

			RecrutmentDb.getInstance().getAdmin().getNotification()
					.offer(hr.getName() + " has created new Hr Account ");

			hr.getNotification().offer("Thanks for Creating Account " + hr.getName());

			logincontroller.hrLogin(hr);
		}

	}

	@Override
	public void hrLoginCredential(String name, String pass) {
		if (RecrutmentDb.getInstance().containsHr(name, pass)) {

			Hr hr = RecrutmentDb.getInstance().getValidHr(name, pass);
			logincontroller.hrLogin(hr);

		} else {
			logincontroller.verificationFailed("Invalid user name or password ");
		}
	}

	@Override
	public void userLoignCredential(String name, String pass) {
		if (RecrutmentDb.getInstance().containsCandidate(name, pass)) {

			Candidate candidate = RecrutmentDb.getInstance().getValidCandidate(name, pass);
			logincontroller.candidateLogin(candidate);

		} else {
			logincontroller.verificationFailed("Invalid user name or password ");
		}
	}
}
