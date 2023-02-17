package com.flightticketreservation.payment;

import java.util.Scanner;

import com.flightticketreservation.dto.AccountDetails;

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

		System.out.print("\nEnter Bank Name : ");
		String name = scanner.nextLine();

		System.out.print("\nEnter the card number : ");
		long number = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("\nTotal amount : "+cost);

		System.out.print("\nEnter the amount : ");
		double amount = scanner.nextDouble();
		scanner.nextLine();

		AccountDetails account = new AccountDetails(name, number);

		if (cost == amount && otpVerify()) {
			paymentViewController.acceptPayment(amount, account);
			return true;
		} else if (cost == amount) {
			System.out.println("Please enter the correct otp and try again ");
		} else {
			System.out.println("Improper Amount Please enter the correct amount ");
		}
		return false;
	}

	private boolean otpVerify() {

		System.out.println("Enter the otp ");
		int otp = (int) (999 + Math.random() * 999);
		System.out.println(otp);
		int user_otp = scanner.nextInt();
		scanner.nextLine();

		if (otp == user_otp) {
			return true;
		}
		return false;
	}

}
