package com.flightticketreservation.craftAdding;

public interface FlightManagementModelControllerCallBack {

	void addflightFailed(String error);

	void addflightsuccess();

	void removeflightSuccess();

	void removeflightFailed(String error);

}
