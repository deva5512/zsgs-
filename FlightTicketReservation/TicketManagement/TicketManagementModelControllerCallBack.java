package com.flightticketreservation.ticketmanagement;

import java.util.ArrayList;
import java.util.List;

import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.PassengerDetails;

public interface TicketManagementModelControllerCallBack {

	void availableFlights(List<FlightDetails> available_flight);

	void flightNotAvailable(String message);

	void improperFlightNumber(String string);

	void insufficientTickets(String string);

	void bookedsuccessfully(ArrayList<Integer> seatNumber , List<PassengerDetails> passengers);

	public void proceedtoBookTicketwith(String number);

	void invalidCancelation(String error);

	void cancelledSuccess();

}
