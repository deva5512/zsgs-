package usermanagement;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import dto.FeedBack;
import dto.ParkingUser;
import dto.User;
import repsitory.ParkingDb;

public class UserModel {

	private UserView userView;

	public UserModel(UserView userView) {
		this.userView = userView;
	}

	public int getTotalSlots() {
		return ParkingDb.getInstance().getParkingSlots().getTotal();
	}

	public int getNumberOfBookedSlots() {
		return ParkingDb.getInstance().getUsers().size();
	}

	public int getAvailableSlots() {
		return ParkingDb.getInstance().getParkingSlots().getTotal() - ParkingDb.getInstance().getUsers().size();
	}

	public boolean checkForBike(String number) {
		return ParkingDb.getInstance().checkuser(number);
	}

	public ParkingUser getSlotDetails(String number) {
		return ParkingDb.getInstance().getslotDetails(number);
	}

	public double getHourlyPay() {
		return ParkingDb.getInstance().getAdmin().getHourly_price();
	}

	public char[][][] getParkingSlot() {
		return ParkingDb.getInstance().getParkingSlots().getParking();
	}

	public void addFeedBack(String feedback) {
		
		FeedBack feed = new FeedBack(LocalDate.now(), feedback);
		
		ParkingDb.getInstance().getFeedBack().add(feed);
	}

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

		userView.removedSuccessfully();

	}

	public int getAvailableSlotsnumber() {
		return ParkingDb.getInstance().getAvailableSlotsnumber();
	}

	public void addVehicle(String number, long phno, LocalDate parkingDate, LocalTime parkingtime, int slot_number,
			double amount ,boolean reserved ) {
		
		User user = new User(number, phno, parkingDate, parkingtime);

		ParkingUser p_user = new ParkingUser(user, slot_number , amount);
		
		
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

	public boolean checkForReservedBike(String number) {
		return ParkingDb.getInstance().checkForReservedBike(number);
	}

	public double getTotalCharges(ParkingUser user) {
		LocalTime parked_time = user.getUser().getParkingtime();
		LocalDate parking_date = user.getUser().getParkingdate();

		Period days = Period.between(parking_date, LocalDate.now());
		int day = days.getDays();
		day *= 24;

		Duration a1 = Duration.between(parked_time, LocalTime.now());
		long hours = a1.toHours() + 1 + day;
		double hourly = getHourlyPay() * hours;

		return hourly;
	}

}
