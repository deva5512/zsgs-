package com.flightticketreservation.craftAdding;

public interface FlightManagementViewCallBack {

	void addflightsuccess();

	void addflightFailed(String error);

	void removeflightFailed(String error);

	void removeflightSuccess();

}
