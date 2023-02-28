package com.carparking.usermanagement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;
import com.carparking.dto.User;

public class UserController implements UserViewControllerCall, UserModelControllerCall {

	private UserViewCallBack userview;
	private UserModelCallBack usermodel;

	public UserController(UserViewCallBack userView) {
		this.userview = userView;
		this.usermodel = new UserModel(this);
	}

	@Override
	public int getAvailableSlots() {
		return usermodel.getAvailableSlots();
	}

	@Override
	public int getNumberOfBookedSlots() {
		return usermodel.getNumberOfBookedSlots();
	}

	@Override
	public int getTotalSlots() {
		return usermodel.getTotalSlots();
	}

	@Override
	public boolean checkForBike(String number) {
		return usermodel.checkForBike(number);
	}

	@Override
	public ParkingUser getSlotDetails(String number) {
		return usermodel.getSlotDetails(number);
	}

	@Override
	public double gethourlyPrice() {
		return usermodel.getHourlyPay();
	}

	@Override
	public double getTotalCharges(ParkingUser user) {

		LocalTime parked_time = user.getUser().getParkingtime();
		LocalDate parking_date = user.getUser().getParkingdate();

		Period days = Period.between(parking_date, LocalDate.now());
		int day = days.getDays();
		day *= 24;

		Duration a1 = Duration.between(parked_time, LocalTime.now());
		long hours = a1.toHours() + 1 + day;
		double hourly = gethourlyPrice() * hours;

		return hourly;
	}

	@Override
	public char[][][] getParkingSlot() {
		return usermodel.getParkingSlot();
	}

	@Override
	public void addFeedBack(String feedback) {

		FeedBack feed = new FeedBack(LocalDate.now(), feedback);

		usermodel.addFeedBack(feed);
	}

	@Override
	public void removeVehicle(ParkingUser user, double amount) {
		usermodel.removeVehicle(user, amount);
	}

	@Override
	public void removedSuccessfully() {
		userview.removedSuccessfully();
	}

	@Override
	public int getAvailableSlotsnumber() {
		return usermodel.getAvailableSlotsnumber();
	}

	@Override
	public void addVehicle(String number, long phno, LocalDate parkingDate, LocalTime parkingtime, int slot_number,
			double amount ,boolean reserved ) {
		User user = new User(number, phno, parkingDate, parkingtime);

		ParkingUser p_user = new ParkingUser(user, slot_number , amount);

		usermodel.addVehicle(p_user, reserved);
	}

	@Override
	public boolean checkForReservedBike(String number) {
		return usermodel.checkForReservedBike(number);
	}

}
