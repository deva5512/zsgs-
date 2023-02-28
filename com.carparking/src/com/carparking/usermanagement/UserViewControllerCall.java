package com.carparking.usermanagement;

import java.time.LocalDate;
import java.time.LocalTime;

import com.carparking.dto.ParkingUser;

public interface UserViewControllerCall {

	int getAvailableSlots();

	int getNumberOfBookedSlots();

	int getTotalSlots();

	boolean checkForBike(String number);

	ParkingUser getSlotDetails(String number);

	double getTotalCharges(ParkingUser user);

	char[][][] getParkingSlot();

	void addFeedBack(String feedback);

	void removeVehicle(ParkingUser user, double amount);

	int getAvailableSlotsnumber();

	double gethourlyPrice();

	boolean checkForReservedBike(String number);

	void addVehicle(String number, long phno, LocalDate parkingDate, LocalTime parkingtime, int slot_number,
			double amount, boolean reserved);

}
