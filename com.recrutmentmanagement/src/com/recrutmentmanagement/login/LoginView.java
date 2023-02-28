package com.recrutmentmanagement.login;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.GetInput;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;
import com.recrutmentmanagement.dto.Teleportable;

import candidateprocess.CandidateView;
import hrprocess.HrView;

public class LoginView implements LoginViewCallBack {

	private LoginViewControllerCall logincontroller;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		this.logincontroller = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.caller();
	}

	private void caller() {
		System.out.println("Welcome to Brute Job Portal ");

		while (true) {
			System.out.println("\n1)Admin Login \n2)User Signup \n3)Exit");
			int input = GetInput.getInt();

			if (input == 1) {
				adminLogin();
			} else if (input == 2) {
				userSignup();
			} else if (input == 3) {
				break;
			} else {
				System.out.println("Improper input ");
			}

		}
		System.out.println("\n\tThank you ");
	}

	private void userSignup() {
		while (true) {
			System.out.println("\n -> User Sign Up");

			System.out.println("\n1)Log in \n2)New user registration \n3)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				userLogin();
			} else if (input == 2) {
				newUserRegistration();
			} else if (input == 3) {
				break;
			} else {
				System.out.println("Improper input ");
			}

		}

	}

	private void userLogin() {
		System.out.println("\n -> User Login <- ");

		System.out.println("\n1)Hr Login \n2)Candidate Login ");
		int input = GetInput.getInt();

		boolean hr = false;

		if (input != 1 && input != 2) {
			System.out.println("\nImproper input ");
			return;
		} else if (input == 1) {
			hr = true;
		}

		System.out.print("\nEnter your name : ");
		String name = scanner.nextLine();

		System.out.print("\nEnter your password : ");
		String pass = scanner.nextLine();

		if (hr) {
			logincontroller.hrLoginCredential(name, pass);
		} else {
			logincontroller.userLoignCredential(name, pass);
		}

	}

	private void newUserRegistration() {
		System.out.println("\n -> New User Registration <- ");

		System.out.println("\n1)Hr registration \n2)Candidate registration ");
		int input = GetInput.getInt();

		boolean hr = false;

		if (input != 1 && input != 2) {
			System.out.println("\nImproper input ");
			return;
		} else if (input == 1) {
			hr = true;
		}

		System.out.print("\nEnter your name : ");
		String name = scanner.nextLine();

		System.out.print("\nEnter your password : ");
		String pass = scanner.nextLine();

		if (hr) {
			System.out.print("\nEnter your Organization name : ");
			String organization = scanner.nextLine();

			logincontroller.registerHr(name, pass, organization);

		} else {
			logincontroller.registerCandidate(name, pass);
		}

	}

	private void adminLogin() {
		System.out.println("\n -> Admin Login <- ");

		System.out.print("\nEnter your admin name : ");
		String name = scanner.nextLine();

		System.out.println("\nEnter your password : ");
		String pass = scanner.nextLine();

		logincontroller.checkForAdmin(name, pass);
	}

	@Override
	public void verificationFailed(String error) {
		System.out.println("\n" + error);
	}

	@Override
	public void adminVerified(String name) {
		System.out.println("\n -> Welcome " + name + " <-");

		Queue<String> notification = logincontroller.getNotinfication();

		while (true) {

			if (!notification.isEmpty()) {
				System.out.println("\nYou have " + notification.size() + " new notification ");
			}

			System.out.println(
					"\n1)View notification \n2)View Admin info \n3)Modify Admin info \n4)View Post History \n5)Go Back ");

			int input = GetInput.getInt();

			if (input == 1) {
				viewNotification(notification);
			} else if (input == 2) {
				viewAdminInfo();
			} else if (input == 3) {
				mofifyAdminInfo();
			} else if (input == 4) {
				viewPaymentHistory();
			} else if (input == 5) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}

		}
	}

	private void viewNotification(Queue<String> notification) {

		if (notification.isEmpty()) {
			System.out.println("\nNo notification is available right now ! ");
			return;
		}

		int num = 1;

		System.out.println("\n -> Notification <- \n");

		while (!notification.isEmpty()) {
			System.out.println(num++ + ") " + notification.poll());
		}
		System.out.println();

	}

	private void viewPaymentHistory() {
		List<Post> post = logincontroller.viewPaymentHistory();

		if (post.isEmpty()) {
			System.out.println("No post is available right now !");
			return;
		}

		Iterator<Post> it = post.iterator();

		System.out.println("\nPayment History\n");

		while (it.hasNext()) {
			Post details = it.next();

			System.out
					.println("Hr name : " + details.getHr().getName() + "         Amount paid : " + details.getPrice());
		}
		System.out.println();

	}

	private void mofifyAdminInfo() {

		System.out
				.println("\n1)Modify Admin Name \n2)Modify Admion Passwod \n3)Mofify Admin Mobile number \n4)Go Back");

		int input = GetInput.getInt();

		if (input == 1) {
			System.out.print("\nEnter your new Admin name : ");
			String name = scanner.nextLine();

			logincontroller.changeAdminDetails(name, null, 0);

			System.out.println("\nName changed Successfully ");

		} else if (input == 2) {
			System.out.print("\nEnter your new password : ");
			String pass = scanner.nextLine();

			logincontroller.changeAdminDetails(null, pass, 0);

			System.out.println("\nPassword changed Successfully ");

		} else if (input == 3) {
			System.out.print("\nEnter your new Mobile Number : ");
			long phno = scanner.nextLong();
			scanner.nextLine();

			logincontroller.changeAdminDetails(null, null, phno);

			System.out.println("\nNumber changed Successfully ");

		} else if (input != 4) {
			System.out.println("\nImproper input ");
		}

	}

	private void viewAdminInfo() {
		Admin admin = logincontroller.getAdmin();

		System.out.println("+----------------------------------------+");
		System.out.printf("| %-15s : %-20s |\n", "Admin Name", admin.getName());
		System.out.printf("| %-15s : %-20s |\n", "Password", admin.getPassword());
		System.out.printf("| %-15s : %-20d |\n", "Mobile Number", admin.getMobileNumber());
		System.out.println("+----------------------------------------+");

	}

	@Override
	public void hrLogin(Hr hr) {
		System.out.println("\n -> Welcome " + hr.getName() + " <-");
		Teleportable hrprocess = new HrView();
		hrprocess.caller(hr);

	}

	@Override
	public void candidateLogin(Candidate candidate) {
		System.out.println("\n -> Welcome " + candidate.getName() + " <-");
		Teleportable candidateProcess = new CandidateView();
		candidateProcess.caller(candidate);
	}
}
