package login;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;

import com.personalexpencemanagement.dto.Expence;
import com.personalexpencemanagement.dto.User;

public interface LoginViewControllerCall {

	void checkForLogin(String name, int pass);

	void dailyCalculator(double balance, int percent);

	void checkExistingUser(String name, int pin);

	boolean checkPosible(double balance, double fixedexpence, int percent);

	void fixAccountBalances(double balance, double fixedexpence, int percent);

	User getUserDetails();

	void changeUserPin(int pin);

	void changeUserName(String name);

	void modifyBalance(double amount);

	void modifyPercent(int percent);

	void modifyFixedExpence(double amount);

	void addExpence(Expence expence);

	Map<String, LinkedList<Expence>> getCompletehistory();

	Map<String, LinkedList<Expence>> getCustomhistory(String string);

}
