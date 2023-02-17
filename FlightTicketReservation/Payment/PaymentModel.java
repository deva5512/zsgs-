package com.flightticketreservation.payment;

import com.flightticketreservation.dto.AccountDetails;
import com.flightticketreservation.login.LoginModel;
import com.flightticketreservation.ticketmanagement.TickteManagementModel;

public class PaymentModel {

	public PaymentModel() {

	}

	public void addpaymenttoAccount(double amount, AccountDetails account) {
		TickteManagementModel.flight.setPayment_recieved(TickteManagementModel.flight.getPayment_recieved() + amount);
		LoginModel.current_user.setAccountDetails(account);
	}

}
