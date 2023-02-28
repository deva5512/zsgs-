package login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.personalexpencemanagement.dto.Expence;
import com.personalexpencemanagement.dto.GetInput;
import com.personalexpencemanagement.dto.User;

public class LoginView implements LoginViewCallBack {

	private Scanner scanner = new Scanner(System.in);

	private LoginViewControllerCall logincontroller;

	public LoginView() {
		this.logincontroller = new LoginController(this);
	}

	public static void main(String[] args) {
		System.out.println("Personal Expence management ");
		LoginView loginView = new LoginView();
		loginView.caller();
	}

	private void caller() {

		while (true) {
			System.out.println("\n1)Signin \n2)Daily Calculator \n3)Exit ");

			int input = GetInput.getInt();

			if (input == 1) {
				signInProcess();
			} else if (input == 2) {
				dailyCalculator();
			} else if (input == 3) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}

		}
		System.out.println("\n   Thank you ");
	}

	private void signInProcess() {

		while (true) {
			System.out.println("\n1)Login \n2)New User Registration \n3)Go Back ");

			int input = GetInput.getInt();

			if (input == 1) {
				checkForLogin();
			} else if (input == 2) {
				newUserRegistration();
			} else if (input == 3) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}

		}
	}

	private void newUserRegistration() {
		System.out.println("\n -> New User Registration <-");
		System.out.print("\nEnter your User name : ");
		String name = scanner.nextLine();

		int pin = GetInput.getInt("pin ( only Numbers ) ");

		logincontroller.checkExistingUser(name, pin);
	}

	private void dailyCalculator() {
		System.out.println("\n-> Used to find how much spending will make your saving constant : ");

		double balance = GetInput.getDouble("current Balance");

		int percent = GetInput.getInt("Percentage you want to save this month");

		logincontroller.dailyCalculator(balance, percent);
	}

	private void checkForLogin() {
		System.out.print("\nEnter your name : ");
		String name = scanner.nextLine();
		int pass = GetInput.getInt("pin");

		logincontroller.checkForLogin(name, pass);
	}

	@Override
	public void improperUser(String error) {
		System.out.println("\n" + error);

	}

	@Override
	public void dailyCalculationFailed(String error) {
		System.out.println("\n" + error);
	}

	@Override
	public void dailyCalculatorResult(String message, double amountcanspendforoneday) {

		System.out.printf("%-10s : %s\n", "Message", message);
		System.out.printf("%-40s : %.2f Rs\n", "Your amount can be spend for one day", amountcanspendforoneday);
	}

	@Override
	public void UserCreatedSuccessfully(String name, int pin) {
		System.out.println("\nYou have successfully created account ");

		System.out.println("\nYour user name : " + name);
		System.out.println("\nYour user pin : " + pin);

		System.out.println("\nyou have to fill few information to proceed  ");

		while (true) {

			double balance = GetInput.getDouble("monthly Balance");

			double fixedexpence = GetInput.getDouble("Ficed Expence");

			int percent = GetInput.getInt("percentage you wish to save this month ");

			boolean validation = logincontroller.checkPosible(balance, fixedexpence, percent);
			if (validation) {
				logincontroller.fixAccountBalances(balance, fixedexpence, percent);
				break;
			} else {
				System.out.println("\nTry to increase your balance or decrease your percent to save ");
			}
		}
		loginSuccess();
	}

	@Override
	public void loginSuccess() {

		User user = logincontroller.getUserDetails();

		if (user.getBalance() == 0 && LocalDate.now().getDayOfMonth() == 1) {
			while (true) {

				double balance = GetInput.getDouble("monthly Balance");

				double fixedexpence = GetInput.getDouble("Fixed Expence");

				int percent = GetInput.getInt("percentage you wish to save this month");

				boolean validation = logincontroller.checkPosible(balance, fixedexpence, percent);
				if (validation) {
					logincontroller.fixAccountBalances(balance, fixedexpence, percent);
					break;
				} else {
					System.out.println("\nTry to increase your balance or decrease your percent to save ");
				}
			}
		}

		while (true) {
			System.out.println(
					"\n1)View User Details \n2)Modify User Details \n3)Enter Daily Expence \n4)History \n5)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				viewDetails();
			} else if (input == 2) {
				modifyUserDetails();
			} else if (input == 3) {
				enterDailyExpence();
			} else if (input == 4) {
				history();
			} else if (input == 5) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}

		}

	}

	private void history() {
		System.out.println("\n1)Today History\n2)Custom History \n3)Complete history ");
		int input = GetInput.getInt();

		Map<String, LinkedList<Expence>> history = null;
		if (input == 1) {
			history = logincontroller.getCustomhistory(LocalDate.now() + "");
		} else if (input == 2) {

			int day = 0;
			int mon = 0;
			int year = 0;
			day = GetInput.getInt("Date ( In Number ) ");
			mon = GetInput.getInt("Month ( In Number ) ");
			year = GetInput.getInt("Year ( In Number ) ");

			LocalDate date = null;
			try {
				date = LocalDate.of(year, mon, day);
			} catch (Exception e) {
				System.out.println("\nEnter a valid input");
				return;
			}

			history = logincontroller.getCustomhistory(date + "");
		} else if (input == 3) {
			history = logincontroller.getCompletehistory();
		} else {
			System.out.println("Invalid input ");
			return;
		}

		if (history.isEmpty()) {
			System.out.println("\nCurrently there is no history ");
			return;
		}

		User user = logincontroller.getUserDetails();

		String path = "";
		if (input != 3) {
			path = "C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\" + user.getName()
					+ user.getPin();
		} else {
			path = "C:\\Users\\deva\\OneDrive\\Desktop\\FileHandling\\PersonalExpence\\TotalExpence";
		}

		File file = new File(path);
		file.mkdir();

		System.out.println("\n\nFile has successfully created in the following path location  \n" + path);

		String file_name = history.keySet().iterator().next();
		File f = null;

		try {
			if (input != 3) {
				path += "\\" + file_name + ".txt";
			} else {
				path += "\\" + file_name + "report.txt";
			}
			f = new File(path);
			f.createNewFile();
		} catch (Exception e) {
			System.out.println("Error Occured while creating file ");
		}

		FileWriter write = null;
		try {
			write = new FileWriter(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Map.Entry<String, LinkedList<Expence>> entry : history.entrySet()) {
			double total = 0;

			if (f.exists()) {
				try {
					write.write(entry.getKey() + "\n");

					Iterator<Expence> it = entry.getValue().iterator();

					while (it.hasNext()) {
						Expence expence = it.next();

						write.write("Rs." + expence.getAmount() + "  : " + expence.getReason() + "\n");
						total += expence.getAmount();

					}
					write.write("\nTotal : " + total + " Rs\n\n");

				} catch (IOException e) {
					System.out.println("Error Occured while Writing ");
				}
			}
		}
		try {
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void enterDailyExpence() {

		double amount = GetInput.getDouble("amount you spent");

		if (amount < 1) {
			System.out.println("Invalid amount ");
			return;
		}

		System.out.print("\nEnter The Reason : ");
		String reason = scanner.nextLine();

		double allowed = logincontroller.getUserDetails().getAllowedonedayamount();

		double spent = logincontroller.getUserDetails().getTodayspending();

		if ((amount + spent) > allowed) {
			sendWarningMessage();
			System.out.println("\n1)Proceed \n2)No");
			int input = GetInput.getInt();

			if (input != 1) {
				return;
			}
		}
		Expence expence = new Expence(amount, reason);
		logincontroller.addExpence(expence);
	}

	private void modifyUserDetails() {
		while (true) {
			System.out.println(
					"\n1)Modify User name \n2)Modify Pin \n3)Modify Balance \n4)Modify Saving Percent \n5)Modify Fixed Expence\n6)Go Back ");

			int input = GetInput.getInt();

			if (input == 1) {
				System.out.print("\nEnter your new user name : ");
				String name = scanner.nextLine();

				logincontroller.changeUserName(name);
				System.out.println("User name changed successfully ");

			} else if (input == 2) {
				int pin = GetInput.getInt("pin");

				logincontroller.changeUserPin(pin);
				System.out.println("User pin changed successfully ");

			} else if (input == 3) {
				modifyBalance();
			} else if (input == 4) {
				modifySavingPercent();
			} else if (input == 5) {
				double amount = GetInput.getDouble("fixed Expence");
				logincontroller.modifyFixedExpence(amount);
			} else if (input == 6) {
				break;
			} else {
				System.out.println("\nInvalid input ");
			}

		}
	}

	private void modifySavingPercent() {
		while (true) {
			System.out.println("\n1)Add Percent \n2)Reduce Percent \n3)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				int percent = GetInput.getInt("percent to increase");

				logincontroller.modifyPercent(percent);

			} else if (input == 2) {
				int percent = GetInput.getInt("percent to reduce");

				logincontroller.modifyPercent(percent * -1);
			} else {
				if (input != 3) {
					System.out.println("\nImproper input : ");
				}
				break;
			}
		}
	}

	private void modifyBalance() {
		while (true) {
			System.out.println("\n1)Add Balance \n2)Reduce Balance \n3)Go Back ");
			int input = GetInput.getInt();

			if (input == 1) {
				double amount = GetInput.getDouble("amount you need to add");

				logincontroller.modifyBalance(amount);

			} else if (input == 2) {
				double amount = GetInput.getDouble("amount you need to reduce");

				logincontroller.modifyBalance(amount * -1);
			} else {
				if (input != 3) {
					System.out.println("\nImproper input : ");
				}
				break;
			}
		}
	}

	private void viewDetails() {
		User user = logincontroller.getUserDetails();

		System.out.println("----------------------------------");
		System.out.printf("%-10s : %s\n\n", "Date", LocalDate.now());

		System.out.printf("%-20s : %s\n", "User name", user.getName());
		System.out.printf("%-20s : %d\n", "Pin", user.getPin());
		System.out.printf("%-20s : %.2f\n", "Balance", user.getBalance());
		System.out.printf("%-20s : %d %% \n", "Saving percent", user.getPercent());
		System.out.printf("%-20s : %.2f\n", "Fixed Expence", user.getFixedExpence());
		System.out.printf("%-20s : %.2f\n", "Max One day expence", user.getAllowedonedayamount());
		System.out.printf("%-20s : %.2f\n", "Today Spent : ", user.getTodayspending());
		System.out.println("----------------------------------\n");

	}

	private void sendWarningMessage() {
		System.out.println("\nWarning : \n");
		System.out.println("-> This expence is more then your daily limit ");
	}

	@Override
	public void invalidAmount() {
		System.out.println(
				"\n-> Amount is greater then your balance \n-> Try to avoid  \n-> If you need to spend it at any cost Add and spend ");
	}

	@Override
	public void resetFailed(String error) {
		System.out.println("\n" + error);
	}
}
