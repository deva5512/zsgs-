package com.flightticketreservation.ticketmanagement;

import java.util.ArrayList;
import java.util.List;

import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.PassengerDetails;

public interface TicketManagementViewCallBack {

	void flightNotAvailable(String message);

	void availableFlights(List<FlightDetails> available_flight);

	void improperFlightNumber(String error);

	void insufficientTickets(String error);

	void bookedsuccessfully(ArrayList<Integer> seatNumber, List<PassengerDetails> passenger);

	public void proceedtoBookTicketwith(String number);

	void invalidCancelation(String error);

	void cancelledSuccess();

}
