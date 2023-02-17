package com.flightticketreservation.ticketmanagement;

import java.util.List;

import com.flightticketreservation.dto.PassengerDetails;

public interface TickteManagementModelCallBack {

	void checkAvailableFlights(String from, String to);

	void checkflightnumber(String number);

	public void bookTicketsBusiness(String number, int noofticket, List<PassengerDetails> passengers);

	public void bookTicketsEconomy(String number, int noofticket, List<PassengerDetails> passengers);

	void cancelTicket(String number, int seat_number);

}
