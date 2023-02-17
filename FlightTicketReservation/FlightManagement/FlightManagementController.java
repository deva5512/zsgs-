package com.flightticketreservation.craftAdding;

import java.util.List;

import com.flightticketreservation.dto.Flight;

public class FlightManagementController
		implements FlightManagementViewControllerCallBack, FlightManagementModelControllerCallBack {

	private FlightManagementViewCallBack FlightView;
	private FlightManagementModelCallBack FlightModel;

	public FlightManagementController(FlightManagementViewCallBack adminFlightView) {
		this.FlightView = adminFlightView;
		FlightModel = new FlightManagementModel(this);
	}

	@Override
	public void addFlight(String number, String from, String destinarion, String date, int business, int economy,
			double business_price, double economy_price) {
		Flight flight = new Flight(number, from, destinarion, date, business, economy, business_price, economy_price);
		FlightModel.addFlightToDb(flight);
	}

	@Override
	public void addflightFailed(String error) {
		FlightView.addflightFailed(error);
	}

	@Override
	public void addflightsuccess() {
		FlightView.addflightsuccess();
	}

	@Override
	public void removeFlight(String number) {
		FlightModel.removeFlight(number);
	}

	@Override
	public void removeflightSuccess() {
		FlightView.removeflightSuccess();
	}

	@Override
	public void removeflightFailed(String error) {
		FlightView.removeflightFailed(error);
	}

	@Override
	public List<Flight> viewFlights() {
		return FlightModel.getFlightsDetails();
	}

}
