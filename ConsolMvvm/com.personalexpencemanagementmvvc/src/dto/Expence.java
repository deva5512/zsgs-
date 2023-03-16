package dto;

public class Expence {
	private double amount;
	private String reason;

	public Expence(double amount, String reason) {
		this.amount = amount;
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public String getReason() {
		return reason;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
