package com.carparking.usermanagement;

import java.time.LocalDate;
import java.time.LocalTime;

import com.carparking.dto.FeedBack;
import com.carparking.dto.ParkingUser;

import repository.ParkingDb;

public class UserModel implements UserModelCallBack {

	private UserModelControllerCall usercontroller;

	public UserModel(UserModelControllerCall userController) {
		this.usercontroller = userController;
	}

	@Override
	public int getTotalSlots() {
		return ParkingDb.getInstance().getParkingSlots().getTotal();
	}

	@Override
	public int getNumberOfBookedSlots() {
		return ParkingDb.getInstance().getUsers().size();
	}

	@Override
	public int getAvailableSlots() {
		return ParkingDb.getInstance().getParkingSlots().getTotal() - ParkingDb.getInstance().getUsers().size();
	}

	@Override
	public boolean checkForBike(String number) {
		return ParkingDb.getInstance().checkuser(number);
	}

	@Override
	public ParkingUser getSlotDetails(String number) {
		return ParkingDb.getInstance().getslotDetails(number);
	}

	@Override
	public double getHourlyPay() {
		return ParkingDb.getInstance().getAdmin().getHourly_price();
	}

	@Override
	public char[][][] getParkingSlot() {
		return ParkingDb.getInstance().getParkingSlots().getParking();
	}

	@Override
	public void addFeedBack(FeedBack feed) {
		ParkingDb.getInstance().getFeedBack().add(feed);
	}

	@Override
	public void removeVehicle(ParkingUser user, double amount) {
		int slot = user.getSlot_number();

		user.setAmount_paid(amount);

		user.getUser().setLeavingdate(LocalDate.now());
		user.getUser().setLeavingtime(LocalTime.now());

		char[][][] parking = ParkingDb.getInstance().getParkingSlots().getParking();

		int[][][] slots = ParkingDb.getInstance().getParkingSlots().getSlots();

		outer: for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[i].length; j++) {
				for (int k = 0; k < slots[i][j].length; k++) {
					if (slots[i][j][k] == slot) {
						parking[i][j][k] = 'O';
						break outer;
					}
				}
			}
		}

		ParkingDb.getInstance().getRecords().add(user);

		ParkingDb.getInstance().getUsers().remove(user);

		usercontroller.removedSuccessfully();

	}

	@Override
	public int getAvailableSlotsnumber() {
		return ParkingDb.getInstance().getAvailableSlotsnumber();
	}

	@Override
	public void addVehicle(ParkingUser p_user, boolean reserved) {
		ParkingDb.getInstance().getUsers().add(p_user);

		char[][][] parking = ParkingDb.getInstance().getParkingSlots().getParking();
		int[][][] slots = ParkingDb.getInstance().getParkingSlots().getSlots();

		outer: for (int i = 0; i < slots[0].length; i++) {
			for (int j = 0; j < slots.length; j++) {
				for (int k = 0; k < slots[j][i].length; k++) {
					if (slots[j][i][k] == p_user.getSlot_number()) {
						parking[j][i][k] = 'X';
						break outer;
					}
				}
			}
		}

		if (reserved) {
			ParkingDb.getInstance().getReserved().add(p_user);
		}
	}

	@Override
	public boolean checkForReservedBike(String number) {
		return ParkingDb.getInstance().checkForReservedBike(number);
	}

}
