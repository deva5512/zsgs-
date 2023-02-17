package com.flightticketreservation.craftAdding;

import java.util.List;

import com.flightticketreservation.dto.Flight;

public interface FlightManagementViewControllerCallBack {

	void addFlight(String number, String from, String destinarion, String date, int business, int economy,
			double business_price, double economy_price);

	void removeFlight(String number);

	List<Flight> viewFlights();

}
