package com.flightticketreservation.ticketmanagement;

import java.util.List;

import com.flightticketreservation.dto.PassengerDetails;

public interface TicketManagementViewControllerCallBack {

	void checkAvailableFlights(String from, String to);

	void checkflightnumber(String number);

	void bookTicketsBusiness(String number, int noofticket, List<PassengerDetails> passengers);

	void bookTicketsEconomy(String number, int noofticket, List<PassengerDetails> passengers);

	void cancelTicket(String number, int seat_number);

}
