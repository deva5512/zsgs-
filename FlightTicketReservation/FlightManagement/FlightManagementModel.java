package com.flightticketreservation.craftAdding;

import java.util.List;

import com.flightticketreservation.dto.Flight;

import repository.AirwayDB;

public class FlightManagementModel implements FlightManagementModelCallBack {

	private FlightManagementModelControllerCallBack adminFlightController;

	public FlightManagementModel(FlightManagementModelControllerCallBack adminFlightController) {
		this.adminFlightController = adminFlightController;
	}

	@Override
	public void addFlightToDb(Flight flight) {

		if (AirwayDB.getInstance().containsFlight(flight.getFlightInstance().getFlight_no()))
			adminFlightController.addflightFailed("Flight number alredy exist ");
		else {
			AirwayDB.getInstance().addFlight(flight);
			adminFlightController.addflightsuccess();
		}
	}

	@Override
	public void removeFlight(String number) {
		if (AirwayDB.getInstance().containsFlight(number)) {
			adminFlightController.removeflightFailed("No flight exist in the given number ");
		} else {
			AirwayDB.getInstance().removeFlight(number);
			adminFlightController.removeflightSuccess();
		}
	}

	@Override
	public List<Flight> getFlightsDetails() {
		return AirwayDB.getInstance().getFlights();
	}

}
