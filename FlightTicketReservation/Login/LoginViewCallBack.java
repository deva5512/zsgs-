package com.flightticketreservation.login;

import java.util.List;
import java.util.Map;

interface LoginViewCallBack {

	void adminLoginSuccess();

	void userLoginFailed(String error);

	void userLoginSuccess(String username);

	void userSignInSuccess();

	void userSignInFailed(String error);

	void bookedTickets(Map<String, List<Integer>> bookedSeats);

}
