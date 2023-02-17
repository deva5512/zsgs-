package com.flightticketreservation.login;

import java.util.Map;

interface LoginViewControllerCallBack {

	void checkLogin(String username, String password);

	void changeAdminPassword(String password);

	void changeAdminName(String name);

	void newUserSignIn(String name, int age, long number, char gender, String mail, String password);

	void changeUserName(String name);

	void changepassword(String password);

	void viewBookedTickets();

	Map<String, Double> getpaymentDetails();

}
