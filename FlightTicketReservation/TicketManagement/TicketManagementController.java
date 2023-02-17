package com.flightticketreservation.ticketmanagement;

import java.util.ArrayList;
import java.util.List;

import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.PassengerDetails;

public class TicketManagementController
		implements TicketManagementViewControllerCallBack, TicketManagementModelControllerCallBack {

	private TickteManagementModelCallBack ticketModel;
	private TicketManagementViewCallBack ticketView;

	public TicketManagementController(TicketManagementViewCallBack ticketView) {
		this.ticketView = ticketView;
		ticketModel = new TickteManagementModel(this);
	}

	@Override
	public void checkAvailableFlights(String from, String to) {
		ticketModel.checkAvailableFlights(from, to);
	}

	@Override
	public void availableFlights(List<FlightDetails> available_flight) {
		ticketView.availableFlights(available_flight);
	}

	@Override
	public void flightNotAvailable(String message) {
		ticketView.flightNotAvailable(message);
	}

	@Override
	public void checkflightnumber(String number) {
		ticketModel.checkflightnumber(number);
	}

	@Override
	public void improperFlightNumber(String error) {
		ticketView.improperFlightNumber(error);
	}

	@Override
	public void proceedtoBookTicketwith(String number) {
		ticketView.proceedtoBookTicketwith(number);
	}

	@Override
	public void bookTicketsBusiness(String number, int noofticket, List<PassengerDetails> passengers) {
		ticketModel.bookTicketsBusiness(number, noofticket, passengers);
	}

	@Override
	public void bookTicketsEconomy(String number, int noofticket, List<PassengerDetails> passengers) {
		ticketModel.bookTicketsEconomy(number, noofticket, passengers);
	}

	@Override
	public void insufficientTickets(String error) {
		ticketView.insufficientTickets(error);
	}

	@Override
	public void bookedsuccessfully(ArrayList<Integer> seatNumber , List<PassengerDetails> passengers) {
		ticketView.bookedsuccessfully(seatNumber , passengers);
	}

	@Override
	public void cancelTicket(String number, int seat_number) {
		ticketModel.cancelTicket(number, seat_number);
	}

	@Override
	public void invalidCancelation(String error) {
		ticketView.invalidCancelation(error);
	}

	@Override
	public void cancelledSuccess() {
		ticketView.cancelledSuccess();
	}

}
