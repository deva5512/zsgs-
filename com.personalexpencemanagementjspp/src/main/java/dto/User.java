package dto;

public class User {

	private String name;
	private double balance;
	private String pin;
	private int percent;
	private double fixedExpence;
	private double allowedonedayamount;

	private double todayspending;

	public User(String name, String pin) {
		this.name = name;
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFixedExpence() {
		return fixedExpence;
	}

	public void setFixedExpence(double fixedExpence) {
		this.fixedExpence = fixedExpence;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getAllowedonedayamount() {
		return allowedonedayamount;
	}

	public void setAllowedonedayamount(double allowedonedayamount) {
		this.allowedonedayamount = allowedonedayamount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public double getTodayspending() {
		return todayspending;
	}

	public void setTodayspending(double todayspending) {
		this.todayspending = todayspending;
	}
}