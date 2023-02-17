package com.flightticketreservation.dto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Flight {

	private FlightDetails flightdetails;

	private List<Integer> start = new LinkedList<>();

	private double payment_recieved;

	private Map<Integer, PassengerDetails> booked_tickets = new HashMap<>();

	public Flight(String number, String from, String destinarion, String date, int business, int economy,
			double business_price, double economy_price) {
		flightdetails = new FlightDetails(number, from, destinarion, date, business, economy, business_price,
				economy_price);

		fillStart(economy + business);
	}

	private void fillStart(int number) {
		for (int i = 1; i <= number; i++) {
			start.add(i);
		}
	}

	public FlightDetails getFlightInstance() {
		return flightdetails;
	}

	public Map<Integer, PassengerDetails> getBooked_tickets() {
		return booked_tickets;
	}

	public void setBooked_tickets(Map<Integer, PassengerDetails> booked_tickets) {
		this.booked_tickets = booked_tickets;
	}

	public List<Integer> getStart() {
		return start;
	}

	public double getPayment_recieved() {
		return payment_recieved;
	}

	public void setPayment_recieved(double payment_recieved) {
		this.payment_recieved = payment_recieved;
	}

}
