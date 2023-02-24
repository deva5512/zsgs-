package com.carparking.payment;

import java.util.Scanner;

public class PaymentView {
	private Scanner scanner = new Scanner(System.in);

	private PaymentViewControllerCall paymentViewController;

	public PaymentView() {
		this.paymentViewController = new PaymentController();
	}

	public boolean caller(double amount) {
		return verification(amount);
	}

	private boolean verification(double cost) {

		System.out.println("Select a payment method : ");
		System.out.println("1)Gpay \n2)Phone Pay \n3)Cancel ");
		System.out.print("\nEnter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		if (input == 1 || input == 2) {

			System.out.println("\nAmount to be paid : " + cost);
			System.out.print("\nEnter the amount : ");
			double amount = scanner.nextDouble();
			scanner.nextLine();

			if (cost == amount) {
				paymentViewController.acceptPayment(amount);
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
