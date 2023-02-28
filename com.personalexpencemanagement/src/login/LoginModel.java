package login;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.personalexpencemanagement.dto.Expence;
import com.personalexpencemanagement.dto.User;

import repository.ExpenceDb;

public class LoginModel implements LoginModelCallBack {

	private LoginModelControllerCall logincontroller;

	private User user;

	public LoginModel(LoginModelControllerCall loginController) {
		this.logincontroller = loginController;
	}

	@Override
	public void checkForLogin(String name, int pin) {
		User user = ExpenceDb.getInstance().getUser(name, pin);

		if (user != null) {
			this.user = user;
			resetAll();
			logincontroller.loginSuccess();
		} else {
			logincontroller.improperUser("Improper user name or password ");
		}

	}

	@Override
	public void checkExistingUser(String name, int pin) {
		if (ExpenceDb.getInstance().contaions(name, pin)) {
			logincontroller.improperUser("Try some other user name");
		} else {
			User user = new User(name, pin);

			ExpenceDb.getInstance().addAccount(user);

			this.user = user;

			logincontroller.UserCreatedSuccessfully(name, pin);
		}
	}

	@Override
	public void fixAccountBalances(double balance, double fixedexpence, int percent, double allowedoneday,
			double today) {
		user.setBalance(balance);
		user.setFixedExpence(fixedexpence);
		user.setPercent(percent);
		user.setAllowedonedayamount(allowedoneday);

		String name = this.user.getName();
		String pass = this.user.getPin() + "";
		ExpenceDb.getInstance().fixAccountBalance(name, pass, balance, fixedexpence, percent, allowedoneday, today);

	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void changeUserPin(int pin) {
		ExpenceDb.getInstance().mofifyPin(user.getName(), user.getPin() + "", pin + "");
		user.setPin(pin);
	}

	@Override
	public void changeUserName(String name) {
		ExpenceDb.getInstance().mofifyName(user.getName(), user.getPin() + "", name);
		user.setName(name);
	}

	@Override
	public void addExpence(String date, Expence expence) {

		if (user.getBalance() < expence.getAmount()) {
			logincontroller.invalidAmount();
			return;
		}
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
						user.setBalance(0);
						FileWriter write = new FileWriter(
								"C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\verify.txt");
						write.write("false");
						write.close();
					}

				} else if (!file.canRead()) {
					logincontroller.resetFailed("Error Try again later");
				}
			} catch (Exception e) {
				logincontroller.resetFailed("Server Problem");
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

	@Override
	public Map<String, LinkedList<Expence>> getCompletehistory() {
		return ExpenceDb.getInstance().getCompletehistory(user.getName() + user.getPin());
	}

	@Override
	public Map<String, LinkedList<Expence>> getCustomhistory(String date) {
		return ExpenceDb.getInstance().getCustomhistory(date, user.getName() + user.getPin());
	}

}
