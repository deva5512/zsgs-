package loginprocess;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import dto.Expence;
import dto.User;
import repository.ExpenceDb;

public class LoginModel {

	public static User user;

	public LoginModel() {
	}

	public User checkForLogin(String name, String pin) {
		if(name == null || pin == null) {
			return null;
		}
		User user = ExpenceDb.getInstance().getUser(name, pin);

		if (user != null) {
			LoginModel.user = user;
			updateDaily();
			resetAll();
			boolean verify = ExpenceDb.getInstance().checkVerification(user.getName(), user.getPin() + "");
			if (verify) {
				user.setBalance(0);
			}
		}
		return user;

	}

	public boolean checkExistingUser(String name, String pin) {
		if (ExpenceDb.getInstance().contaions(name, pin)) {
			return false;
		} else {
			User user = new User(name, pin);

			ExpenceDb.getInstance().addAccount(user);
			
			LoginModel.user = user;
			return true;
		}
	}

	public int getnumberofdays() {
		LocalDate currentDate = LocalDate.now();
		LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

		Period days = Period.between(currentDate, lastDayOfMonth);
		return days.getDays() + 1;
	}

	public void setAccountBalance(double balance, double fixedexpence, int percent) {
		int noofdays = getnumberofdays();
		balance -= fixedexpence;
		double amounthave = balance - (balance / 100) * percent;
		double allowedoneday = amounthave / noofdays;

		user.setBalance(balance);
		user.setFixedExpence(fixedexpence);
		user.setPercent(percent);
		user.setAllowedonedayamount(allowedoneday);
		fixAccountBalances();
	}

	public void fixAccountBalances() {

		String name = LoginModel.user.getName();
		String pass = LoginModel.user.getPin() + "";
		ExpenceDb.getInstance().fixAccountBalance(name, pass, user.getBalance(), user.getFixedExpence(),
				user.getPercent(), user.getAllowedonedayamount(), user.getTodayspending());

		ExpenceDb.getInstance().modifyVerification(user.getName(), user.getPin() + "", false);
	}

	public void updateDaily() {
		if (!ExpenceDb.getInstance().checkForDate(LocalDate.now() + "")) {
			ExpenceDb.getInstance().fixAccountBalance(user.getName(), user.getPin() + "", user.getBalance(),
					user.getFixedExpence(), user.getPercent(), user.getAllowedonedayamount(), 0);
		}
	}

	public boolean modifyFixedExpence(double amount) {

		double fixedexpence = user.getFixedExpence() - amount;

		double balance = user.getBalance() + fixedexpence;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			return false;
		} else {
			user.setFixedExpence(amount);
			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
			return true;
		}
	}

	public boolean modifyPercent(int percent) {

		double balance = user.getBalance();
		percent += user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			return false;
		} else {
			user.setPercent(percent);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
			return true;
		}
	}

	public boolean modifyBalance(double amount) {

		double balance = user.getBalance() + amount;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			return false;
		} else {
			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
			return true;
		}
	}

	public User getUser() {
		return user;
	}

	public void changeUserPin(String pin) {
		ExpenceDb.getInstance().mofifyPin(user.getName(), user.getPin() + "", pin + "");
		user.setPin(pin);
	}

	public void changeUserName(String name) {
		ExpenceDb.getInstance().mofifyName(user.getName(), user.getPin() + "", name);
		user.setName(name);
	}

	public boolean addExpence(Expence expence) {

		if (user.getBalance() < expence.getAmount()) {
			return false;
		}
		String date = LocalDate.now() + "";
		user.setBalance(user.getBalance() - expence.getAmount());

		if (ExpenceDb.getInstance().checkForDate(date)) {
			user.setTodayspending(user.getTodayspending() + expence.getAmount());
		} else {
			user.setTodayspending(expence.getAmount());
		}
		ExpenceDb.getInstance().fixAccountBalance(user.getName(), user.getPin() + "", user.getBalance(),
				user.getFixedExpence(), user.getPercent(), user.getAllowedonedayamount(), user.getTodayspending());

		ExpenceDb.getInstance().addExpence(user.getName() + user.getPin(), date, expence);

		return true;
	}

	public void resetAll() {
		if (LocalDate.now().getDayOfMonth() == 1) {
			try {
				File file = new File("C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\verify.txt");
				if (file.canRead()) {

					Scanner read = new Scanner(file);
					boolean verify = Boolean.parseBoolean(read.nextLine());

					if (verify) {
						ExpenceDb.getInstance().resetAll();
						FileWriter write = new FileWriter(
								"C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\verify.txt");
						write.write("false");
						write.close();
					}
					read.close();
				} else if (!file.canRead()) {
					System.out.println("Server Problem");
				}
			} catch (Exception e) {
				System.out.println("Server Problem");
			}
		}
		if (LocalDate.now().getDayOfMonth() == 2) {
			try {
				FileWriter write = new FileWriter(
						"C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\verify.txt");
				write.write("true");
				write.close();
			} catch (Exception e) {
				System.out.println("Server Problem");
			}
		}
	}

	public Map<String, LinkedList<Expence>> getCompletehistory() {
		return ExpenceDb.getInstance().getCompletehistory(user.getName() + user.getPin());
	}

	public Map<String, LinkedList<Expence>> getCustomhistory(String date) {
		return ExpenceDb.getInstance().getCustomhistory(date, user.getName() + user.getPin());
	}

	public double dailyCalculator(double balance, int percent) {
		int noofdays = getnumberofdays();

		double amounthave = balance - (balance / 100) * percent;

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 5) {
			return -1;
		} else {
			return amountcanspendforoneday;
		}

	}

	public boolean checkPosible(double balance, double fixedexpence, int percent) {
		int noofdays = getnumberofdays();

		balance = balance - fixedexpence;
		double amounthave = balance - (balance / 100) * percent;

		double amountcanspendforoneday = amounthave / noofdays;

		return amountcanspendforoneday > 10;
	}

}
