package login;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.Map;

import com.personalexpencemanagement.dto.Expence;
import com.personalexpencemanagement.dto.User;

public class LoginController implements LoginViewControllerCall, LoginModelControllerCall {

	private LoginViewCallBack loginview;
	private LoginModelCallBack loginmodel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginview = loginView;
		this.loginmodel = new LoginModel(this);
	}

	@Override
	public void checkForLogin(String name, int pass) {
		loginmodel.checkForLogin(name, pass);
	}

	@Override
	public void improperUser(String error) {
		loginview.improperUser(error);
	}

	@Override
	public void dailyCalculator(double balance, int percent) {
		int noofdays = getnumberofdays();

		double amounthave = balance - (balance / 100) * percent;

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 5) {
			loginview.dailyCalculationFailed("Insufficientg balance ");
		} else {
			String message = "";
			if (amountcanspendforoneday > 500) {
				message = "You can save more if you want ";
			} else {
				message = "Good to go ";
			}
			loginview.dailyCalculatorResult(message, amountcanspendforoneday);
		}

	}

	private int getnumberofdays() {
		LocalDate currentDate = LocalDate.now();
		LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

		Period days = Period.between(currentDate, lastDayOfMonth);
		return days.getDays() + 1;
	}

	@Override
	public void checkExistingUser(String name, int pin) {
		loginmodel.checkExistingUser(name, pin);
	}

	@Override
	public void UserCreatedSuccessfully(String name, int pin) {
		loginview.UserCreatedSuccessfully(name, pin);
	}

	@Override
	public void loginSuccess() {
		loginview.loginSuccess();
	}

	@Override
	public boolean checkPosible(double balance, double fixedexpence, int percent) {
		int noofdays = getnumberofdays();

		balance = balance - fixedexpence;
		double amounthave = balance - (balance / 100) * percent;

		double amountcanspendforoneday = amounthave / noofdays;

		return amountcanspendforoneday > 10;
	}

	@Override
	public void fixAccountBalances(double balance, double fixedexpence, int percent) {
		int noofdays = getnumberofdays();

		balance -= fixedexpence;

		double amounthave = balance - (balance / 100) * percent;

		double allowedoneday = amounthave / noofdays;

		loginmodel.fixAccountBalances(balance, fixedexpence, percent, allowedoneday, 0);

	}

	@Override
	public User getUserDetails() {
		return loginmodel.getUser();
	}

	@Override
	public void changeUserPin(int pin) {
		loginmodel.changeUserPin(pin);
	}

	@Override
	public void changeUserName(String name) {
		loginmodel.changeUserName(name);
	}

	@Override
	public void modifyBalance(double amount) {
		User user = loginmodel.getUser();

		double balance = user.getBalance() + amount;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginview.dailyCalculationFailed("Invalid modification");
		} else {
			loginmodel.fixAccountBalances(balance, user.getFixedExpence(), percent, user.getAllowedonedayamount(),
					user.getTodayspending());

			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
		}
	}

	@Override
	public void modifyPercent(int percent) {
		User user = loginmodel.getUser();

		double balance = user.getBalance();
		percent += user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginview.dailyCalculationFailed("Invalid modification");
		} else {
			loginmodel.fixAccountBalances(user.getBalance(), user.getFixedExpence(), percent, amountcanspendforoneday,
					user.getTodayspending());

			user.setPercent(percent);
			user.setAllowedonedayamount(amountcanspendforoneday);
		}
	}

	@Override
	public void modifyFixedExpence(double amount) {
		User user = loginmodel.getUser();

		double fixedexpence = user.getFixedExpence() - amount;

		double balance = user.getBalance() + fixedexpence;
		int percent = user.getPercent();

		double amounthave = balance - (balance / 100) * percent;

		int noofdays = getnumberofdays();

		double amountcanspendforoneday = amounthave / noofdays;

		if (amountcanspendforoneday < 10) {
			loginview.dailyCalculationFailed("Invalid modification");
		} else {
			loginmodel.fixAccountBalances(balance, amount, user.getPercent(), amountcanspendforoneday,
					user.getTodayspending());

			user.setFixedExpence(amount);
			user.setBalance(balance);
			user.setAllowedonedayamount(amountcanspendforoneday);
		}
	}

	@Override
	public void addExpence(Expence expence) {

		LocalDate date = LocalDate.now();

		loginmodel.addExpence(date + "", expence);

	}

	@Override
	public void invalidAmount() {
		loginview.invalidAmount();
	}

	@Override
	public Map<String, LinkedList<Expence>> getCompletehistory() {
		return loginmodel.getCompletehistory();
	}

	@Override
	public Map<String, LinkedList<Expence>> getCustomhistory(String string) {
		return loginmodel.getCustomhistory(string);
	}

	@Override
	public void resetFailed(String error) {
		loginview.resetFailed(error);
	}

}
