package payment;

import repsitory.ParkingDb;

public class PaymentModel {
	
	public PaymentModel() {

	}

	public void addpaymenttoAccount(double amount) {
		ParkingDb.getInstance().setAmount(amount + ParkingDb.getInstance().getAmount());
	}
}
