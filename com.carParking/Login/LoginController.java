package com.carparking.loginview;

import java.util.List;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

public class LoginController implements LoginViewControllerCall, LoginModelControllerCall {

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}

	@Override
	public void checkAdminCredential(String name, String password) {
		loginModel.checkAdminCredential(name, password);
	}

	@Override
	public void adminloginFailed(String error) {
		loginView.adminloginFailed(error);
	}

	@Override
	public void adminloginSuccess() {
		loginView.adminloginSuccess();
	}

	@Override
	public void clearHistory() {
		loginModel.clearHistory();
	}

	@Override
	public List<FeedBack> getfeedback() {
		return loginModel.getfeedback();
	}

	@Override
	public double getpaymentRecieved() {
		return loginModel.getPaymentRecieved();
	}

	@Override
	public List<ParkingUser> showCurrentVehicles() {
		return loginModel.showCurrentVehicles();
	}

	@Override
	public List<ParkingUser> getHistory() {
		return loginModel.getHistory();
	}

}
