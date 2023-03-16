package dto;

public class ParkingUser {
	private User user;
	private int slot_number;
	private double amount_paid;

	public ParkingUser(User user, int slot_number, double amount) {
		this.slot_number = slot_number;
		this.user = user;
		this.amount_paid = amount;
	}

	public int getSlot_number() {
		return slot_number;
	}

	public void setSlot_number(int slot_number) {
		this.slot_number = slot_number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}
}
