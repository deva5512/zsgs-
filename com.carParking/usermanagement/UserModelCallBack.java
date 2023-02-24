package com.carparking.usermanagement;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

public interface UserModelCallBack {

	int getTotalSlots();

	int getNumberOfBookedSlots();

	int getAvailableSlots();

	boolean checkForBike(String number);

	ParkingUser getSlotDetails(String number);

	double getHourlyPay();

	char[][][] getParkingSlot();

	void addFeedBack(FeedBack feed);

	void removeVehicle(ParkingUser user , double amount );

	int getAvailableSlotsnumber();

	void addVehicle(ParkingUser p_user, boolean reserved);

	boolean checkForReservedBike(String number);

}
