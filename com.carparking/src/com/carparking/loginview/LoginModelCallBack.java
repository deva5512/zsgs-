package com.carparking.loginview;

import java.util.List;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

public interface LoginModelCallBack {

	void checkAdminCredential(String name, String password);

	void clearHistory();

	List<FeedBack> getfeedback();

	double getPaymentRecieved();

	List<ParkingUser> showCurrentVehicles();

	List<ParkingUser> getHistory();

}
