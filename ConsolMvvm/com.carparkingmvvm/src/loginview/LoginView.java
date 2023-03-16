package loginview;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dto.ClearanceThread;
import dto.FeedBack;
import dto.GetInput;
import dto.ParkingUser;
import dto.Teleportable;
import usermanagement.UserView;

public class LoginView implements Teleportable {

	private Scanner scanner = new Scanner(System.in);
	private LoginModel loginModel;

	public LoginView() {
		this.loginModel = new LoginModel(this);
	}

	public static void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.caller();
	}

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
			int input = GetInput.getInt();

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

		loginModel.checkAdminCredential(name, password);
	}

	public void adminloginFailed(String error) {
		System.out.println("\n" + error);
	}

	public void adminloginSuccess() {
		System.out.println("\n -> Welocme Admin <- ");

		while (true) {
			System.out.println(
					"\n1)History \n2)payment recieved \n3)All Vehicle details by slot \n4)Show Feedback \n5)Clear History \n6)Exit ");
			int input = GetInput.getInt();

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
		loginModel.clearHistory();
		System.out.println("\nHistory Cleared Successfully ");
	}

	private void showFeedBack() {
		List<FeedBack> feed = loginModel.getfeedback();

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
		List<ParkingUser> user = loginModel.showCurrentVehicles();

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
		double payment = loginModel.getPaymentRecieved();

		System.out.println("\nPayment recieved : " + payment);
	}

	private void showHistory() {
		List<ParkingUser> user = loginModel.getHistory();

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
