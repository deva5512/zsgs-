package com.carparking.usermanagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.carparking.dto.GetInput;
import com.carparking.dto.ParkingUser;
import com.carparking.dto.Teleportable;
import com.carparking.payment.PaymentView;

public class UserView implements UserViewCallBack, Teleportable {

	private Scanner scanner = new Scanner(System.in);
	private UserViewControllerCall usercontroller;

	public UserView() {
		this.usercontroller = new UserController(this);
	}

	@Override
	public void caller() {
		System.out.println("\n -> User View <- ");
		userProcess();
	}

	private void userProcess() {
		while (true) {
			int total_slots = usercontroller.getTotalSlots();
			int number_of_cars = usercontroller.getNumberOfBookedSlots();
			int available_slots = usercontroller.getAvailableSlots();

			print(total_slots, number_of_cars, available_slots);

			System.out.println(
					"\n1)Show Bill \n2)Show Parking Slot \n3)Reserve Booking ( Only 24 Hours ) \n4)Spot Booking \n5)Payment for Spot Booking \n6)Parking FeedBack \n7)Exit");
			int input = GetInput.getInt();

			if (input == 1) {
				showBill();
			} else if (input == 2) {
				showParkingSlot();
			} else if (input == 3) {
				reservedBooking();
			} else if (input == 4) {
				payAndPark();
			} else if (input == 5) {
				quickPay();
			} else if (input == 6) {
				feedback();
			} else if (input == 7) {
				break;
			} else {
				System.out.println("Improper input ");
			}

		}
	}

	private void quickPay() {
		System.out.println("Enter the Car number : ");
		String number = scanner.nextLine();

		ParkingUser user = usercontroller.getSlotDetails(number);

		if (user != null) {

			if (usercontroller.checkForReservedBike(number)) {
				System.out.println("\nThis payment is only for spot Booking");
			} else {

				double charges = usercontroller.getTotalCharges(user);

				PaymentView view = new PaymentView();

				if (view.caller(charges)) {
					usercontroller.removeVehicle(user, charges);
				} else {
					System.out.println("Payment failed ");
				}
			}
		} else {
			System.out.println("\nNo such number Exist ");
		}
	}

	private void payAndPark() {
		System.out.println("\nEnter your Car number : ");
		String number = scanner.nextLine();

		if (usercontroller.checkForBike(number)) {
			System.out.println("Car numbers has to be unique");
		} else {

			System.out.println("\nEnter yoru mobile number : ");
			long phno = scanner.nextLong();
			scanner.nextLine();

			LocalDate parkingDate = LocalDate.now();

			LocalTime parkingtime = LocalTime.now();

			int slot_number = usercontroller.getAvailableSlotsnumber();

			usercontroller.addVehicle(number, phno, parkingDate, parkingtime, slot_number, 0, false);
			System.out.println("Parked successfully ");
		}
	}

	private void feedback() {
		System.out.println("\nKindly Enter you FeedBacks ");

		String feedback = scanner.nextLine();

		usercontroller.addFeedBack(feedback);

		System.out.println("\nThanks for your feedBack ");
	}

	private void reservedBooking() {
		System.out.println("\nEnter your Car number : ");
		String number = scanner.nextLine();

		if (usercontroller.checkForBike(number)) {
			System.out.println("Car numbers has to be unique");
		} else {

			System.out.println("\nEnter yoru mobile number : ");
			long phno = scanner.nextLong();
			scanner.nextLine();

			LocalDate parkingDate = LocalDate.now();

			LocalTime parkingtime = LocalTime.now();

			int slot_number = usercontroller.getAvailableSlotsnumber();

			PaymentView paymentView = new PaymentView();

			double amount = usercontroller.gethourlyPrice() * 24;

			if (paymentView.caller(amount)) {
				usercontroller.addVehicle(number, phno, parkingDate, parkingtime, slot_number, amount, true);
				System.out.println("Slot reserved successfully ");
			} else {
				System.out.println("Booking failde due to to transaction failed ");
			}
		}

	}

	private void showParkingSlot() {
		char[][][] slots = usercontroller.getParkingSlot();
		System.out.println();

		for (int i = -1; i < slots[0].length; i++) {
			for (int a = 0; a < slots.length; a++) {
				if (i == -1)
					System.out.print("  Floor " + a + "   ");
				else {
					for (int b = 0; b < slots[a][i].length; b++) {
						System.out.print(slots[a][i][b] + "  ");
					}
				}
				System.out.print("     ");
			}
			System.out.println("\n");
		}
	}

	private void showBill() {
		System.out.print("Enter Car number : ");
		String number = scanner.nextLine();

		double charges = 0;
		boolean reserved = false;

		if (usercontroller.checkForReservedBike(number)) {
			ParkingUser user = usercontroller.getSlotDetails(number);
			reserved = true;
			charges = user.getAmount_paid();
		}
		if (usercontroller.checkForBike(number)) {
			ParkingUser user = usercontroller.getSlotDetails(number);

			DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

			if (!reserved)
				charges = usercontroller.getTotalCharges(user);

			System.out.println("\n-------------------------------------");
			System.out.printf("%-20s : %d\n", "Slot Number ", user.getSlot_number());
			if (!reserved)
				System.out.printf("%-20s : %.2f\n", "Amount to be paid", charges);
			else
				System.out.printf("%-20s : %.2f\n", "Amount paid", charges);
			System.out.printf("%-20s : %s\n", "Car Number", user.getUser().getBikenumber());
			System.out.printf("%-20s : %d\n", "Mobile NUmber", user.getUser().getPhno());
			System.out.printf("%-20s : %s\n", "Parking Date", user.getUser().getParkingdate());
			System.out.printf("%-20s : %s\n", "Parking Time", format.format(user.getUser().getParkingtime()));
			System.out.println("-------------------------------------");

		} else {
			System.out.println("\nNo such number Exist ");
		}

	}

	private void print(int total, int cars, int slots) {

		System.out.println("\n ---------------------------------------------------------------");
		System.out.printf(" | %-17s | %-18s | %-18s | \n", "   Total Slots", "   Filled Slots", "  Available Slots");
		System.out.println(" ---------------------------------------------------------------");
		System.out.printf(" | %9d         | %9d          | %9d          | \n", total, cars, slots);
		System.out.printf("%-20s %-20s %-20s |\n", " |", "|", "|");
		System.out.println(" ---------------------------------------------------------------");

	}

	@Override
	public void removedSuccessfully() {
		System.out.println("Removed Successfully ");
	}

}
