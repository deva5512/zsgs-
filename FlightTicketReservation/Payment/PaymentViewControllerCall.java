package com.flightticketreservation.payment;

import com.flightticketreservation.dto.AccountDetails;

public interface PaymentViewControllerCall {

	void acceptPayment(double amount , AccountDetails account);

}
