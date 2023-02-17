package com.flightticketreservation.ticketmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flightticketreservation.dto.Flight;
import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.PassengerDetails;
import com.flightticketreservation.login.LoginModel;

import repository.AirwayDB;

public class TickteManagementModel implements TickteManagementModelCallBack {

	private TicketManagementModelControllerCallBack ticketmodelController;

	private List<FlightDetails> available_flight = new ArrayList<>();

	public static Flight flight;

	public TickteManagementModel(TicketManagementModelControllerCallBack ticketmodelController) {
		this.ticketmodelController = ticketmodelController;

	}

	@Override
	public void checkAvailableFlights(String from, String to) {
		available_flight.clear();
		AirwayDB.getInstance().findAvailableFlights(from, to, available_flight);
		if (!available_flight.isEmpty()) {
			ticketmodelController.availableFlights(available_flight);
		} else {
			ticketmodelController.flightNotAvailable("Sorry our service is not available for the entered location ");
		}
	}

	@Override
	public void checkflightnumber(String number) {
		if (AirwayDB.getInstance().containsFlight(number)) {
			flight = AirwayDB.getInstance().getspecificflight(number);
			ticketmodelController.proceedtoBookTicketwith(number);
		} else {
			ticketmodelController.improperFlightNumber("Kindly Enter the correct Flight number");
		}
	}

	@Override
	public void bookTicketsBusiness(String number, int noofticket, List<PassengerDetails> passengers) {
		if (flight.getFlightInstance().getNumber_of_business_class() >= noofticket) {

			flight.getFlightInstance().reduceBusiness(noofticket);
			flight.getFlightInstance().reduceticketNumber(noofticket);

			ArrayList<Integer> seatNumber = new ArrayList<>();

			for (int i = 0; i < noofticket; i++) {
				flight.getBooked_tickets().put(flight.getStart().get(0), passengers.get(i));
				seatNumber.add(flight.getStart().get(0));
				flight.getStart().remove(0);
			}
			if (LoginModel.current_user.getBookedSeats().containsKey(number)) {
				seatNumber.addAll(LoginModel.current_user.getBookedSeats().get(number));
				LoginModel.current_user.getBookedSeats().put(number, seatNumber);
			} else {
				LoginModel.current_user.getBookedSeats().put(number, seatNumber);
			}
			ticketmodelController.bookedsuccessfully(seatNumber, passengers);
		} else {
			ticketmodelController.insufficientTickets("Insufficient ticket in business class");
		}
	}

	@Override
	public void bookTicketsEconomy(String number, int noofticket, List<PassengerDetails> passengers) {
		if (flight.getFlightInstance().getNumber_of_economy_class() >= noofticket) {

			flight.getFlightInstance().reduceEconomy(noofticket);
			flight.getFlightInstance().reduceticketNumber(noofticket);

			ArrayList<Integer> seatNumber = new ArrayList<>();

			for (int i = 0; i < noofticket; i++) {
				flight.getBooked_tickets().put(flight.getStart().get(0), passengers.get(i));
				seatNumber.add(flight.getStart().get(0));
				flight.getStart().remove(0);
			}
			if (LoginModel.current_user.getBookedSeats().containsKey(number)) {
				seatNumber.addAll(LoginModel.current_user.getBookedSeats().get(number));
				LoginModel.current_user.getBookedSeats().put(number, seatNumber);
			} else {
				LoginModel.current_user.getBookedSeats().put(number, seatNumber);
			}
			ticketmodelController.bookedsuccessfully(seatNumber, passengers);
		} else {
			ticketmodelController.insufficientTickets("Insufficient ticket in Economy class");
		}
	}

	@Override
	public void cancelTicket(String number, int seat_number) {
		Map<String, List<Integer>> reservedtickets = LoginModel.current_user.getBookedSeats();
		if (reservedtickets.containsKey(number)) {
			if (reservedtickets.get(number).contains(seat_number)) {

				flight = AirwayDB.getInstance().getspecificflight(number);
				if (flight.getBooked_tickets().get(seat_number).getClasss().equalsIgnoreCase("Economy")) {
					flight.setPayment_recieved(flight.getPayment_recieved() - 4000);
					flight.getFlightInstance()
							.setNumber_of_economy_class(flight.getFlightInstance().getNumber_of_economy_class() + 1);
				} else {
					flight.setPayment_recieved(flight.getPayment_recieved() - 6000);
					flight.getFlightInstance()
							.setNumber_of_business_class(flight.getFlightInstance().getNumber_of_business_class() + 1);
				}

				flight.getFlightInstance().setTicket_number(flight.getFlightInstance().getTicket_number() + 1);
				flight.getBooked_tickets().remove(seat_number);
				flight.getStart().add(0, seat_number);

				List<Integer> temp = reservedtickets.get(number);
				int index = temp.indexOf(seat_number);
				temp.remove(index);

				if (temp.isEmpty()) {
					reservedtickets.remove(number);
				}

				ticketmodelController.cancelledSuccess();

			} else {
				ticketmodelController.invalidCancelation("Invalid Seat Number ");
			}
		} else {
			ticketmodelController.invalidCancelation("Invalid Flight number ");
		}
	}

}
