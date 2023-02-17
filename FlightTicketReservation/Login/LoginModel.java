package com.flightticketreservation.login;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.flightticketreservation.dto.Flight;
import com.flightticketreservation.dto.UserDetails;

import repository.AirwayDB;

public class LoginModel implements LoginModelCallBack {

	private LoginModelControllerCallBack loginController;

	public static UserDetails current_user;

	public LoginModel(LoginController loginController) {
		this.loginController = loginController;
	}

	@Override
	public void checkLoginOnline(String username, String password) {
		if (username.equalsIgnoreCase("admin") || (AirwayDB.getInstance().getAdmin() != null
				&& AirwayDB.getInstance().getAdmin().getName().equals(username))) {
			checkAdminLoginCredential(username, password);
		} else {
			current_user = AirwayDB.getInstance().checkUserPassword(username, password);

			if (current_user != null) {
				loginController.userLoginSuccess(username);
			} else {
				loginController.userLoginFailed("Invalid user name");
			}
		}
	}

	private void checkAdminLoginCredential(String username, String password) {
		if (AirwayDB.getInstance().checkAdminPassword(username, password)) {
			loginController.adminLoginSuccess();
		} else {
			loginController.userLoginFailed("Invalid user name");
		}
	}

	@Override
	public void changeAdminPassword(String password) {
		AirwayDB.getInstance().setAdminPasswor(password);
	}

	@Override
	public void changeAdminName(String name) {
		AirwayDB.getInstance().setAdminName(name);
	}

	@Override
	public void newUserSignIn(String name, int age, long number, char gender, String mail, String password) {
		if (AirwayDB.getInstance().containsUserNumber(number)) {
			loginController.userSignInFailed("User number alredy exist ");
		} else {

			UserDetails user = new UserDetails(name, age, number, gender, mail, password);
			AirwayDB.getInstance().adduser(user);

			loginController.userSignInSuccess();
		}
	}

	@Override
	public void changepassword(String password) {
		current_user.setPassword(password);
	}

	@Override
	public void changeUserName(String name) {
		current_user.setName(name);
	}

	@Override
	public void viewBookedTickets() {
		loginController.bookedTickets(current_user.getBookedSeats());
	}

	@Override
	public Map<String, Double> getpaymentDetails() {
		Map<String, Double> payment = new HashMap<>();

		Iterator<Flight> it = AirwayDB.getInstance().getFlights().iterator();

		while (it.hasNext()) {

			Flight flight = it.next();

			if (flight.getPayment_recieved() != 0) {
				payment.put(flight.getFlightInstance().getFlight_no(), flight.getPayment_recieved());
			}
		}
		
		return payment;

	}

}
