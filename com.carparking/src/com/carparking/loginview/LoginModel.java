package com.carparking.loginview;

import java.util.List;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

import repository.ParkingDb;

public class LoginModel implements LoginModelCallBack {

	private LoginModelControllerCall loginController;

	public LoginModel(LoginModelControllerCall loginController) {
		this.loginController = loginController;
	}

	@Override
	public void checkAdminCredential(String name, String password) {
		if (ParkingDb.getInstance().getAdmin().getName().equalsIgnoreCase(name.trim())
				&& ParkingDb.getInstance().getAdmin().getPassword().equalsIgnoreCase(password.trim())) {
			loginController.adminloginSuccess();
		} else {
			loginController.adminloginFailed("Improper user name or password ");
		}
	}

	@Override
	public void clearHistory() {
		ParkingDb.getInstance().getRecords().clear();
	}

	@Override
	public List<FeedBack> getfeedback() {
		return ParkingDb.getInstance().getFeedBack();
	}

	@Override
	public double getPaymentRecieved() {
		return ParkingDb.getInstance().getAmount();
	}

	@Override
	public List<ParkingUser> showCurrentVehicles() {
		return ParkingDb.getInstance().getUsers();
	}

	@Override
	public List<ParkingUser> getHistory() {
		return ParkingDb.getInstance().getRecords();
	}

}
