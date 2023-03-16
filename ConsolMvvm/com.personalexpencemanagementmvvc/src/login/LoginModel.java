package login;

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

	private LoginView loginView;

	private User user;

	public LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void checkForLogin(String name, int pin) {
		User user = ExpenceDb.getInstance().getUser(name, pin);

		if (user != null) {
			this.user = user;
			updateDaily();
			resetAll();
			boolean verify = ExpenceDb.getInstance().checkVerification(user.getName(), user.getPin() + "");
			System.out.println(verify+"-----------------------------------------------");
			if (verify) {
				user.setBalance(0);
			}
			loginView.loginSuccess();
		} else {
			loginView.improperUser("Improper user name or password ");
		}

	}

	public void checkExistingUser(String name, int pin) {
		if (ExpenceDb.getInstance().contaions(name, pin)) {
			loginView.improperUser("Try some other user name");
		} else {
			User user = new User(name, pin);

			ExpenceDb.getInstance().addAccount(user);

			this.user = user;

			loginView.UserCreatedSuccessfully(name, pin);
		}
	}

	private int getnumberofdays() {
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

	private void fixAccountBalances() {

		String name = this.user.getName();
		String pass = this.user.getPin() + "";
		ExpenceDb.getInstance().fixAccountBalance(name, pass, user.getBalance(), user.getFixedExpence(),
				user.getPercent(), user.getAllowedonedayamount(), user.getTodayspending());

		ExpenceDb.getInstance().modifyVerification(user.getName(), user.getName(), false);
	}

	private void updateDaily() {
		if (!ExpenceDb.getInstance().checkForDate(LocalDate.now() + "")) {
			ExpenceDb.getInstance().fixAccountBalance(user.getName(), user.getPin() + "", user.getBalance(),
					user.getFixedExpence(), user.getPercent(), user.getAllowedonedayamount(), 0);
		}
	}

	public void modifyFixedExpence(double amount) {

		double fixedexpence = user.getFixedExpence() - amount;

		double balance = user.getBalance() + fixedexpence;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginView.dailyCalculationFailed("Invalid modification");
		} else {
			user.setFixedExpence(amount);
			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
		}
	}

	public void modifyPercent(int percent) {

		double balance = user.getBalance();
		percent += user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginView.dailyCalculationFailed("Invalid modification");
		} else {
			user.setPercent(percent);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
		}
	}

	public void modifyBalance(double amount) {

		double balance = user.getBalance() + amount;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginView.dailyCalculationFailed("Invalid modification");
		} else {
			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
			fixAccountBalances();
		}
	}

	public User getUser() {
		return user;
	}

	public void changeUserPin(int pin) {
		ExpenceDb.getInstance().mofifyPin(user.getName(), user.getPin() + "", pin + "");
		user.setPin(pin);
	}

	public void changeUserName(String name) {
		ExpenceDb.getInstance().mofifyName(user.getName(), user.getPin() + "", name);
		user.setName(name);
	}

	public void addExpence(Expence expence) {

		if (user.getBalance() < expence.getAmount()) {
			loginView.invalidAmount();
			return;
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

	}

	private void resetAll() {
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

				} else if (!file.canRead()) {
					loginView.resetFailed("Error Try again later");
				}
			} catch (Exception e) {
				loginView.resetFailed("Server Problem");
			}
		}
		if (LocalDate.now().getDayOfMonth() == 2) {
			try {
				FileWriter write = new FileWriter(
						"C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\verify.txt");
				write.write("true");
				write.close();
			} catch (Exception e) {
				System.out.println("Writting Error");
			}
		}
	}

	public Map<String, LinkedList<Expence>> getCompletehistory() {
		return ExpenceDb.getInstance().getCompletehistory(user.getName() + user.getPin());
	}

	public Map<String, LinkedList<Expence>> getCustomhistory(String date) {
		return ExpenceDb.getInstance().getCustomhistory(date, user.getName() + user.getPin());
	}

	public void dailyCalculator(double balance, int percent) {
		int noofdays = getnumberofdays();

		double amounthave = balance - (balance / 100) * percent;

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 5) {
			loginView.dailyCalculationFailed("Insufficientg balance ");
		} else {
			String message = "";
			if (amountcanspendforoneday > 500) {
				message = "You can save more if you want ";
			} else {
				message = "Good to go ";
			}
			loginView.dailyCalculatorResult(message, amountcanspendforoneday);
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
