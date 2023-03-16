package repsitory;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import dto.Admin;
import dto.FeedBack;
import dto.ParkingSlots;
import dto.ParkingUser;

public class ParkingDb {

	private List<ParkingUser> users = new LinkedList<>();

	private List<ParkingUser> records = new LinkedList<>();

	private List<FeedBack> feedBack = new LinkedList<>();

	private List<ParkingUser> reserved = new LinkedList<>();

	private static ParkingDb parkingdb;

	private ParkingSlots parkingSlots = new ParkingSlots();

	private double Amount;

	private Admin admin = new Admin("admin", "123", 25);

	private ParkingDb() {
	}

	public static ParkingDb getInstance() {
		if (parkingdb == null) {
			parkingdb = new ParkingDb();
		}
		return parkingdb;
	}

	public boolean checkuser(String number) {
		if (users.isEmpty()) {
			return false;
		}
		ListIterator<ParkingUser> it = users.listIterator();
		while (it.hasNext()) {
			if (it.next().getUser().getBikenumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

	public void addParkingUser(ParkingUser user) {
		this.users.add(user);
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public void clearRecord() {
		this.records.clear();
	}

	public List<FeedBack> getFeedBack() {
		return feedBack;
	}

	public ParkingSlots getParkingSlots() {
		return parkingSlots;
	}

	public List<ParkingUser> getUsers() {
		return users;
	}

	public ParkingUser getslotDetails(String number) {
		if (users.isEmpty()) {
			return null;
		}
		ListIterator<ParkingUser> it = users.listIterator();
		while (it.hasNext()) {
			ParkingUser user = it.next();
			if (user.getUser().getBikenumber().equals(number)) {
				return user;
			}
		}
		return null;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<ParkingUser> getReserved() {
		return reserved;
	}

	public int getAvailableSlotsnumber() {

		int[][][] slots = parkingSlots.getSlots();
		char[][][] parking = parkingSlots.getParking();

		int res = 0;
		outer: for (int i = 0; i < slots[0].length; i++) {
			for (int j = 0; j < slots.length; j++) {
				for (int k = 0; k < slots[j][i].length; k++) {
					if (parking[j][i][k] == 'O') {
						res = slots[j][i][k];
						break outer;
					}
				}
			}
		}
		return res;
	}

	public List<ParkingUser> getRecords() {
		return records;
	}

	public boolean checkForReservedBike(String number) {
		if (reserved.isEmpty()) {
			return false;
		}
		ListIterator<ParkingUser> it = reserved.listIterator();
		while (it.hasNext()) {
			if (it.next().getUser().getBikenumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

}
