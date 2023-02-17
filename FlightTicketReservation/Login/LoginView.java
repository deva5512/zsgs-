package com.flightticketreservation.login;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.flightticketreservation.craftAdding.FlightManagementView;
import com.flightticketreservation.dto.Teleportable;
import com.flightticketreservation.ticketmanagement.TicketManagementView;

public class LoginView implements LoginViewCallBack, Teleportable, AdminProcess, UserTicketBooking {

	private Scanner scanner = new Scanner(System.in);

	private LoginViewControllerCallBack loginController;

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		Teleportable loginView = new LoginView();
//		System.out.println((int) (999 + Math.random() * 999));
		loginView.caller();
	}

	@Override
	public void caller() {
		System.out.println(" -> Welcome to Dream airlines <- ");
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("\n1) Log in \n2) Sign up \n3) Exit");
		System.out.print("Enter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				System.out.print("\nEnter Your name : ");
				String username = scanner.nextLine();
				System.out.print("Enter your password : ");
				String password = scanner.nextLine();

				loginController.checkLogin(username, password);

			} else if (input == 2) {
				newUserSignIn();
			} else if (input == 3) {
				System.out.println("\n______________ Thank you ______________");
			} else {
				System.out.println("\nWrong input please try again \n");
				checkForLogin();
			}
			System.exit(0);
		}

	}

	private void newUserSignIn() {
		System.out.println("  ->  New user sign Up  <-  ");
		System.out.print("\nEnter user name : ");
		String name = scanner.nextLine();

		System.out.print("\nEnter your age : ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\nEnter contact Number : ");
		long number = scanner.nextLong();
		scanner.nextLine();

		System.out.print("\nEnter your Gender : ");
		char gender = scanner.next().charAt(0);
		scanner.nextLine();

		System.out.print("\nEnter mail id : ");
		String mail = scanner.nextLine();

		System.out.print("\nEnter password : ");
		String password = scanner.nextLine();

		System.out.print("\nConfirm password : ");
		String confirmpassword = scanner.nextLine();

		if (password.equals(confirmpassword)) {

			loginController.newUserSignIn(name, age, number, gender, mail, password);

		} else {
			System.out.println("\nTry to enter same Password ");
			checkForLogin();
		}
	}

	@Override
	public void adminLoginSuccess() {
		System.out.println(" -> Welcome admin <- ");
		adminProcess();
	}

	@Override
	public void adminProcess() {
		System.out.println(
				"\n1)Change admin name \n2)Change admin password \n3)Aircraft modification \n4)Payment Recieved \n5) Exit");
		System.out.print("\nEnter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				System.out.print("Enter the new Admin name : ");
				String name = scanner.nextLine();
				loginController.changeAdminName(name);

				adminProcess();

			} else if (input == 2) {
				System.out.print("Enter the new password : ");
				String password = scanner.nextLine();
				loginController.changeAdminPassword(password);

				adminProcess();

			} else if (input == 3) {
				Teleportable adminFlightView = new FlightManagementView(this);
				adminFlightView.caller();
			} else if (input == 4) {
				checkPaymentRecieved();
			} else if (input == 5) {
				checkForLogin();
			} else {
				System.out.println("\nWrong input please try again \n");
				adminProcess();
			}
			break;
		}
	}

	private void checkPaymentRecieved() {
		Map<String, Double> paymentsOfFlights = loginController.getpaymentDetails();
		if (paymentsOfFlights.isEmpty()) {
			System.out.println("\nCurrently no user has booked Tickets ");
		} else {

			for (Map.Entry<String, Double> payments : paymentsOfFlights.entrySet()) {
				System.out.println("Flight number " + payments.getKey() + " -> " + payments.getValue());
			}
		}
		adminProcess();
	}

	@Override
	public void userLoginFailed(String error) {
		System.out.println("\n" + error);
		checkForLogin();
	}

	@Override
	public void userLoginSuccess(String username) {
		System.out.println("\n -> Welcome " + username + " <- ");
		userProcess();
	}

	@Override
	public void userProcess() {
		System.out.println(
				"\n1)Change user name \n2)change user password \n3)Ticket Management \n4)View Booked Tickets \n5)Exit");

		System.out.print("\nEnter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {

				System.out.print("Enter new user name : ");
				String name = scanner.nextLine();

				loginController.changeUserName(name);

				userProcess();

			} else if (input == 2) {
				System.out.print("Enter new password : ");
				String password = scanner.nextLine();

				loginController.changepassword(password);

				userProcess();
			} else if (input == 3) {
				Teleportable ticketManagement = new TicketManagementView(this);
				ticketManagement.caller();
			} else if (input == 4) {

				loginController.viewBookedTickets();

			} else if (input == 5) {
				checkForLogin();
			} else {
				System.out.println("\nWrong input please try again ");
				userProcess();
			}
			break;
		}
	}

	@Override
	public void userSignInSuccess() {
		System.out.println("\nThanks for signing in ");
		checkForLogin();
	}

	@Override
	public void userSignInFailed(String error) {

		System.out.println("\n" + error);
		checkForLogin();
	}

	@Override
	public void bookedTickets(Map<String, List<Integer>> bookedSeats) {
		if (bookedSeats.isEmpty()) {
			System.out.println("\nCurrently no tickets has been reserved ");
		} else {
			for (Map.Entry<String, List<Integer>> key : bookedSeats.entrySet()) {
				System.out.println("\n Flight number : " + key.getKey());

				List<Integer> tickets = key.getValue();
				for (int i = 0; i < tickets.size(); i++) {
					System.out.println((i + 1) + " -> " + tickets.get(i));
				}

			}
		}
		userProcess();
	}

}
