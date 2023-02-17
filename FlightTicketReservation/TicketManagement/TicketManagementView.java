package com.flightticketreservation.ticketmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.PassengerDetails;
import com.flightticketreservation.dto.Teleportable;
import com.flightticketreservation.login.UserTicketBooking;
import com.flightticketreservation.payment.PaymentView;

public class TicketManagementView implements TicketManagementViewCallBack, Teleportable {

	private Scanner scanner = new Scanner(System.in);

	private TicketManagementViewControllerCallBack ticketviewController;
	private UserTicketBooking loginview;

	public TicketManagementView(UserTicketBooking loginView) {
		this.loginview = loginView;
		ticketviewController = new TicketManagementController(this);
	}

	@Override
	public void caller() {
		System.out.print("\n1)Book Ticket \n2)Cancel Ticket \n3)Thakal Ticket Booking \n4)Exit");
		System.out.print("\nEnter your input : ");
		int input = scanner.nextInt();
		scanner.nextLine();

		while (true) {
			if (input == 1) {
				bookTicket();
			} else if (input == 2) {
				cancelTicket();
			} else if (input == 3) {
				thakalTicketBooking();
			} else if (input != 4) {
				System.out.println("\nWrong input ");
			}
			break;
		}
		loginview.userProcess();
	}

	private void thakalTicketBooking() {
		System.out.println(
				"Thakkal Ticket Booking is not Currently available ll be available within in 12 hours of departure date ");
	}

	private void cancelTicket() {
		System.out.println(" -> Ticket Cancelation <- ");
		System.out.print("\nEnter the Flight number : ");
		String number = scanner.nextLine();
		System.out.print("\nEnter the seat number : ");
		int seat_number = scanner.nextInt();
		scanner.nextLine();

		ticketviewController.cancelTicket(number, seat_number);
	}

	private void bookTicket() {
		System.out.println(" -> Ticket Booking <- ");
		System.out.print("\nEnter Journey begining location : ");
		String from = scanner.nextLine();
		System.out.print("\nEnter Journey end location : ");
		String to = scanner.nextLine();

		ticketviewController.checkAvailableFlights(from, to);
	}

	@Override
	public void flightNotAvailable(String message) {
		System.out.println("\n" + message);
	}

	@Override
	public void availableFlights(List<FlightDetails> available_flight) {
		System.out.println("\n\n --->   Available flights   <--- ");
		for (FlightDetails flight : available_flight) {
			System.out.println("\nflight number : " + flight.getFlight_no() + " is available with "
					+ flight.getNumber_of_business_class() + " Business class tickets & "
					+ flight.getNumber_of_economy_class() + "Economy class tickets on " + flight.getDeparture_date());
		}

		System.out.println("\nPlease select the flight number to proceed : ");
		String number = scanner.nextLine();

		ticketviewController.checkflightnumber(number);
	}

	private void userDetailsGetter(List<PassengerDetails> passengers, int noofticket, String classs) {
		for (int i = 1; i <= noofticket; i++) {

			System.out.print("\nEnter passenger " + i + " name : ");
			String name = scanner.nextLine();

			System.out.print("\nEnter passenger " + i + " age : ");
			int age = scanner.nextInt();
			scanner.nextLine();

			System.out.print("\nEnter passenger " + i + " moblie number : ");
			long phno = scanner.nextLong();
			scanner.nextLine();

			System.out.print("\nEnter passenger " + i + " gender : ");
			char gender = scanner.next().charAt(0);
			scanner.nextLine();

			PassengerDetails detail = new PassengerDetails(name, age, phno, gender, classs);

			passengers.add(detail);

		}
	}

	@Override
	public void proceedtoBookTicketwith(String number) {
		System.out.print("Enter the number of tickets :");
		int noofticket = scanner.nextInt();
		scanner.nextLine();
		System.out.println("\n1)Business \n2)Economy");
		int input = scanner.nextInt();
		scanner.nextLine();

		if (input == 1 || input == 2) {

			String classs = input == 1 ? "Business" : "Economy";

			List<PassengerDetails> passengers = new ArrayList<>();

			PaymentView payment = new PaymentView();

			if (input == 1) {

				if (TickteManagementModel.flight.getFlightInstance().getNumber_of_business_class() >= noofticket) {

					userDetailsGetter(passengers, noofticket, classs);

					if (payment.caller(
							noofticket * TickteManagementModel.flight.getFlightInstance().getBusiness_price())) {
						ticketviewController.bookTicketsBusiness(number, noofticket, passengers);

					} else
						System.out.println("Booking Canceled due to transaction failed ");
				} else
					insufficientTickets("Insufficient ticket");
			} else {

				if (TickteManagementModel.flight.getFlightInstance().getNumber_of_economy_class() >= noofticket) {

					userDetailsGetter(passengers, noofticket, classs);

					if (payment
							.caller(noofticket * TickteManagementModel.flight.getFlightInstance().getEconomy_price())) {
						ticketviewController.bookTicketsEconomy(number, noofticket, passengers);

					} else
						System.out.println("Booking Canceled due to transaction failed ");
				} else
					insufficientTickets("Insufficient ticket");

			}
		} else {
			System.out.println("Wrong input ");
		}
		caller();
	}

	private void printBookedUser(int seatnumber, PassengerDetails passenger) {
		System.out.println("                     Seat Number : " + seatnumber);

		System.out.println("Passenger Name : " + passenger.getName());
		System.out.println("Passenger Age : " + passenger.getAge());
		System.out.println("Passenger Mobile Number : " + passenger.getPhno());
		System.out.println("Passenger Gender : " + passenger.getGender());
		System.out.println("Class : " + passenger.getClasss() + "\n");
	}

	@Override
	public void improperFlightNumber(String error) {
		System.out.println("\n" + error);
		caller();
	}

	@Override
	public void insufficientTickets(String error) {
		System.out.println("\n" + error);
	}

	@Override
	public void bookedsuccessfully(ArrayList<Integer> seatNumber, List<PassengerDetails> passengers) {

		System.out.println("\nYou have booked successfully ");
		System.out.println("\nKindly note the seat number if required for cancalation");

		for (int i = 1; i <= seatNumber.size(); i++) {
			printBookedUser(seatNumber.get(i - 1), passengers.get(i - 1));
//			System.out.println(i + " ->  seat number : " + seatNumber.get(i - 1));
			if (i <= seatNumber.size()) {
				System.out.println("---------------------------------------------------------------");
			}
		}

	}

	@Override
	public void invalidCancelation(String error) {
		System.out.println("\n" + error);
		caller();
	}

	@Override
	public void cancelledSuccess() {
		System.out.println("\nCancelled Successfully ");
	}

}
