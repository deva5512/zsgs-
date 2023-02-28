package com.carparking.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

import repository.ParkingDb;

public class ClearanceThread extends Thread {

	@Override
	public void run() {

		while (true) {
			List<ParkingUser> reserved = ParkingDb.getInstance().getReserved();

			for (int i = 0; i < reserved.size(); i++) {

				ParkingUser user = reserved.get(i);

				LocalDate parking_date = user.getUser().getParkingdate();

				Period days = Period.between(parking_date, LocalDate.now());
				int day = days.getDays();
				if (day > 0) {

					remove(user.getSlot_number());

					user.getUser().setLeavingdate(LocalDate.now());
					user.getUser().setLeavingtime(LocalTime.now());

					ParkingDb.getInstance().getRecords().add(user);
					reserved.remove(user);
					i--;
				}
			}

			try {
				Thread.sleep(3600000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void remove(int slot_number) {
		char[][][] parking = ParkingDb.getInstance().getParkingSlots().getParking();

		int[][][] slots = ParkingDb.getInstance().getParkingSlots().getSlots();

		outer: for (int i = 0; i < slots.length; i++) {
			for (int j = 0; j < slots[i].length; j++) {
				for (int k = 0; k < slots[i][j].length; k++) {
					if (slots[i][j][k] == slot_number) {
						parking[i][j][k] = 'O';
						break outer;
					}
				}
			}
		}
	}

}
