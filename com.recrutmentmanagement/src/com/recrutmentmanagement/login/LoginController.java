package com.recrutmentmanagement.login;

import java.util.List;
import java.util.Queue;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

public class LoginController implements LoginViewControllerCall, LoginModelControllerCall {

	private LoginViewCallBack loginview;

	private LoginModelCallBack loginmodel;

	public LoginController(LoginViewCallBack loginView2) {
		this.loginview = loginView2;
		this.loginmodel = new LoginModel(this);
	}

	@Override
	public void checkForAdmin(String name, String pass) {
		loginmodel.checkForAdmin(name, pass);
	}

	@Override
	public void verificationFailed(String error) {
		loginview.verificationFailed(error);
	}

	@Override
	public void adminVerified(String name) {
		loginview.adminVerified(name);
	}

	@Override
	public List<Post> viewPaymentHistory() {
		return loginmodel.getPostHistory();
	}

	@Override
	public Admin getAdmin() {
		return loginmodel.getAdmin();
	}

	@Override
	public void changeAdminDetails(String name, String pass, long phno) {
		loginmodel.changeAdminDetails(name, pass, phno);
	}

	@Override
	public Queue<String> getNotinfication() {
		return getAdmin().getNotification();
	}

	@Override
	public void registerCandidate(String name, String pass) {
		Candidate candidate = new Candidate(name, pass);

		loginmodel.registerCandidate(candidate);
	}

	@Override
	public void registerHr(String name, String pass, String organization) {
		Hr hr = new Hr(name, pass, organization);

		loginmodel.registerHr(hr);
	}

	@Override
	public void hrLogin(Hr hr) {
		loginview.hrLogin(hr);
	}

	@Override
	public void candidateLogin(Candidate candidate) {
		loginview.candidateLogin(candidate);
	}

	@Override
	public void hrLoginCredential(String name, String pass) {
		loginmodel.hrLoginCredential(name, pass);
	}

	@Override
	public void userLoignCredential(String name, String pass) {
		loginmodel.userLoignCredential(name, pass);
	}
}
