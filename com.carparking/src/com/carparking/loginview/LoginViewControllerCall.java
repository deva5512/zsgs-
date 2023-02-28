package com.carparking.loginview;

import java.util.List;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

public interface LoginViewControllerCall {

	void checkAdminCredential(String name, String password);

	void clearHistory();

	List<FeedBack> getfeedback();

	double getpaymentRecieved();

	List<ParkingUser> showCurrentVehicles();

	List<ParkingUser> getHistory();

}
