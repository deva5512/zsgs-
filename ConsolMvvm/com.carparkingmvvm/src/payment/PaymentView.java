package payment;

import java.util.Scanner;

import dto.GetInput;

public class PaymentView {
	private Scanner scanner = new Scanner(System.in);

	private PaymentModel PaymentModel;

	public PaymentView() {
		this.PaymentModel = new PaymentModel();
	}

	public boolean caller(double amount) {
		return verification(amount);
	}

	private boolean verification(double cost) {

		System.out.println("Select a payment method : ");
		System.out.println("1)Gpay \n2)Phone Pay \n3)Cancel ");
		int input = GetInput.getInt();

		if (input == 1 || input == 2) {

			System.out.println("\nAmount to be paid : " + cost);
			double amount = 0;

			while (true) {
				try {
					System.out.print("\nEnter the amount : ");
					amount = scanner.nextDouble();
					scanner.nextLine();
					break;
				} catch (Exception e) {
					scanner.nextLine();
					System.out.println("\nInvalid input ");
				}
			}

			if (cost == amount) {
				PaymentModel.addpaymenttoAccount(amount);
				return true;
			} else {
				System.out.println("Improper Amount Please enter the correct amount ");
			}
		} else if (input != 3) {
			System.out.println("\nImproper input ");
		} else {
			System.out.println("\nPayment Cancelled Try again");
		}

		return false;
	}
}
