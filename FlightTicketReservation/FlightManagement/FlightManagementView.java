package com.flightticketreservation.craftAdding;

import java.util.Iterator;
import java.util.Scanner;

import com.flightticketreservation.dto.Flight;
import com.flightticketreservation.dto.Teleportable;
import com.flightticketreservation.login.AdminProcess;

public class FlightManagementView implements Teleportable, FlightManagementViewCallBack {

	private Scanner scanner = new Scanner(System.in);

	private FlightManagementViewControllerCallBack flightController;

	private AdminProcess loginadminview;

	public FlightManagementView(AdminProcess loginadminview) {
		this.loginadminview = loginadminview;
		flightController = new FlightManagementController(this);
	}

	@Override
	public void caller() {
		System.out.println("  -> Flight Management <- ");
		System.out.println("1)Add Flight \n2)Remove Flight \n3)View Flights \n4)Exit ");
		System.out.print("\nEnter you input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				addFlight();
			} else if (input == 2) {
				removeFlight();
			} else if (input == 3) {
				viewFlights();
			} else if (input != 4) {
				System.out.println("Wrong input ");
			}
			break;
		}
		loginadminview.adminProcess();

	}

	private void viewFlights() {
		Iterator<Flight> it = flightController.viewFlights().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getFlightInstance().toString());
		}
	}

	private void addFlight() {
		System.out.print("\nEnter flight number (number has to be of 5 digits) : ");
		String number = scanner.nextLine();

		System.out.print("\nEnter From Location : ");
		String from = scanner.nextLine();

		System.out.print("\nEnter Departure Location : ");
		String destinarion = scanner.nextLine();

		System.out.print("\nEnter Departure Date : ");
		String date = scanner.nextLine();

		System.out.print("\nEnter number of business class ticket : ");
		int business = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\nEnter number of economy class ticket : ");
		int economy = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\nEnter Business class ticket price amount : ");
		int business_price = scanner.nextInt();
		scanner.nextLine();

		System.out.print("\nEnter Economy class ticket price amount : ");
		int economy_price = scanner.nextInt();
		scanner.nextLine();

		flightController.addFlight(number, from, destinarion, date, business, economy, business_price, economy_price);
	}

	private void removeFlight() {
		System.out.print("\nEnter Flight number to remove : ");
		String number = scanner.nextLine();

		flightController.removeFlight(number);

	}

	@Override
	public void addflightsuccess() {
		System.out.println("\nFlight added successfully ");
		loginadminview.adminProcess();
	}

	@Override
	public void addflightFailed(String error) {
		System.out.println("\n" + error);
		caller();
	}

	@Override
	public void removeflightFailed(String error) {
		System.out.println("\n" + error);
		caller();
	}

	@Override
	public void removeflightSuccess() {
		System.out.println("\nFlight removed successfully ");
		loginadminview.adminProcess();
	}

}
