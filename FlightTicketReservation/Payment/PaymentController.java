package com.flightticketreservation.payment;

import com.flightticketreservation.dto.AccountDetails;

public class PaymentController implements PaymentViewControllerCall {

	private PaymentModel paymentModel;

	public PaymentController() {
		this.paymentModel = new PaymentModel();

	}

	@Override
	public void acceptPayment(double amount, AccountDetails account) {
		paymentModel.addpaymenttoAccount(amount, account);
	}

}
