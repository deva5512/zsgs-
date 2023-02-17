package com.flightticketreservation.login;

import java.util.List;
import java.util.Map;

interface LoginModelControllerCallBack {

	void userLoginSuccess(String username);

	void userLoginFailed(String error);

	void adminLoginSuccess();

	void userSignInFailed(String error);

	void userSignInSuccess();

	void bookedTickets(Map<String, List<Integer>> bookedSeats);

}
