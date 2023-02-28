package com.carparking.payment;

public class PaymentController implements PaymentViewControllerCall {

	private PaymentModel paymentModel;

	public PaymentController() {
		this.paymentModel = new PaymentModel();

	}

	@Override
	public void acceptPayment(double amount) {
		paymentModel.addpaymenttoAccount(amount);
	}

}
