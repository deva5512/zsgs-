package com.flightticketreservation.login;

import java.util.List;
import java.util.Map;

class LoginController implements LoginModelControllerCallBack, LoginViewControllerCallBack {

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		loginModel = new LoginModel(this);
	}

	@Override
	public void checkLogin(String username, String password) {
		loginModel.checkLoginOnline(username, password);
	}

	@Override
	public void userLoginSuccess(String username) {
		loginView.userLoginSuccess(username);
	}

	@Override
	public void userLoginFailed(String error) {
		loginView.userLoginFailed(error);
	}

	@Override
	public void adminLoginSuccess() {
		loginView.adminLoginSuccess();
	}

	@Override
	public void changeAdminPassword(String password) {
		loginModel.changeAdminPassword(password);
	}

	@Override
	public void changeAdminName(String name) {
		loginModel.changeAdminName(name);
	}

	@Override
	public void newUserSignIn(String name, int age, long number, char gender, String mail, String password) {
		loginModel.newUserSignIn(name, age, number, gender, mail, password);
	}

	@Override
	public void userSignInFailed(String error) {
		loginView.userSignInFailed(error);
	}

	@Override
	public void userSignInSuccess() {
		loginView.userSignInSuccess();
	}

	@Override
	public void changeUserName(String name) {
		loginModel.changeUserName(name);
	}

	@Override
	public void changepassword(String password) {
		loginModel.changepassword(password);
	}

	@Override
	public void viewBookedTickets() {
		loginModel.viewBookedTickets();
	}

	@Override
	public void bookedTickets(Map<String, List<Integer>> bookedSeats) {
		loginView.bookedTickets(bookedSeats);
	}

	@Override
	public Map<String, Double> getpaymentDetails() {
		return loginModel.getpaymentDetails();
	}

}
