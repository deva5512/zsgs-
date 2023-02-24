package com.carparking.loginview;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.carparking.dto.ClearanceThread;
import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;
import com.carparking.dto.Teleportable;
import com.carparking.usermanagement.UserView;

public class LoginView implements LoginViewCallBack, Teleportable {

	private Scanner scanner = new Scanner(System.in);
	private LoginViewControllerCall logincontroller;

	public LoginView() {
		this.logincontroller = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.caller();
	}

	@Override
	public void caller() {
		System.out.println("Welcome to VR Car Management ");

		ClearanceThread thread = new ClearanceThread();
		thread.start();

		entryFeatures();
		System.exit(0);
	}

	private void entryFeatures() {
		while (true) {
			System.out.println("\n1)Admin Login \n2)User \n3)Exit ");
			System.out.print("\nEnter your input : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			if (input == 1) {
				adminprocess();
			} else if (input == 2) {
				UserView user = new UserView();
				user.caller();
			} else if (input == 3) {
				break;
			} else {
				System.out.println("Improper input try again");
			}
		}
		System.out.println("Thank you ");
	}

	private void adminprocess() {
		System.out.print("\nEnter your user name :");
		String name = scanner.nextLine();

		System.out.print("\nEnter your Password :");
		String password = scanner.nextLine();

		logincontroller.checkAdminCredential(name, password);
	}

	@Override
	public void adminloginFailed(String error) {
		System.out.println("\n" + error);
	}

	@Override
	public void adminloginSuccess() {
		System.out.println("\n -> Welocme Admin <- ");

		while (true) {
			System.out.println(
					"\n1)History \n2)payment recieved \n3)All Vehicle details by slot \n4)Show Feedback \n5)Clear History \n6)Exit ");
			System.out.print("\nEnter your input : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			if (input == 1) {
				showHistory();
			} else if (input == 2) {
				showPaymentRecieved();
			} else if (input == 3) {
				showAllVehicleDetails();
			} else if (input == 4) {
				showFeedBack();
			} else if (input == 5) {
				clearHistory();
			} else if (input == 6) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}
		}

	}

	private void clearHistory() {
		logincontroller.clearHistory();
		System.out.println("\nHistory Cleared Successfully ");
	}

	private void showFeedBack() {
		List<FeedBack> feed = logincontroller.getfeedback();

		if (feed.isEmpty()) {
			System.out.println("\nCurrently No Feeds present  ");
		} else {
			Iterator<FeedBack> it = feed.iterator();

			while (it.hasNext()) {

				FeedBack f = it.next();

				System.out.println("\nFeedBack Given Date : " + f.getDate());
				System.out.println("\nFeedback : " + f.getFeedback());
			}

			feed.clear();
		}
	}

	private void showAllVehicleDetails() {
		List<ParkingUser> user = logincontroller.showCurrentVehicles();

		if (user.isEmpty()) {
			System.out.println("\nCurrently No Vehicle in slot ");
		} else {

			Iterator<ParkingUser> it = user.iterator();

			while (it.hasNext()) {
				ParkingUser parking = it.next();

				DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

				System.out.println("\n-------------------------------------");
				System.out.printf("%-20s : %d\n", "Slot Number ", parking.getSlot_number());
				System.out.printf("%-20s : %s\n", "Car Number", parking.getUser().getBikenumber());
				System.out.printf("%-20s : %d\n", "Mobile NUmber", parking.getUser().getPhno());
				System.out.printf("%-20s : %s\n", "Parking Date", parking.getUser().getParkingdate());
				System.out.printf("%-20s : %s\n", "Parking Time", format.format(parking.getUser().getParkingtime()));
				System.out.println("-------------------------------------");

			}
		}

	}

	private void showPaymentRecieved() {
		double payment = logincontroller.getpaymentRecieved();

		System.out.println("\nPayment recieved : " + payment);
	}

	private void showHistory() {
		List<ParkingUser> user = logincontroller.getHistory();

		if (user.isEmpty()) {
			System.out.println("\nCurrently No history ");
		} else {

			Iterator<ParkingUser> it = user.iterator();

			while (it.hasNext()) {
				ParkingUser parking = it.next();

				DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

				System.out.println("\n-------------------------------------");
				System.out.printf("%-20s : %d\n", "Slot Number ", parking.getSlot_number());
				System.out.printf("%-20s : %s\n", "Car Number", parking.getUser().getBikenumber());
				System.out.printf("%-20s : %d\n", "Mobile NUmber", parking.getUser().getPhno());
				System.out.printf("%-20s : %s\n", "Parking Date", parking.getUser().getParkingdate());
				System.out.printf("%-20s : %s\n", "Parking Time", format.format(parking.getUser().getParkingtime()));
				System.out.printf("%-20s : %s\n", "Left Date", parking.getUser().getLeavingdate());
				System.out.printf("%-20s : %s\n", "Left Time", format.format(parking.getUser().getLeavingtime()));
				System.out.println("-------------------------------------");

			}
		}
	}

}
