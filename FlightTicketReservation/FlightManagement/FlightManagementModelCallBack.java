package com.flightticketreservation.craftAdding;

import java.util.List;

import com.flightticketreservation.dto.Flight;

public interface FlightManagementModelCallBack {

	void addFlightToDb(Flight flight);

	void removeFlight(String number);

	List<Flight> getFlightsDetails();

}
