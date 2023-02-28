package login;

import java.util.LinkedList;
import java.util.Map;

import com.personalexpencemanagement.dto.Expence;
import com.personalexpencemanagement.dto.User;

public interface LoginModelCallBack {

	void checkForLogin(String name, int pin);

	void checkExistingUser(String name, int pin);

	void fixAccountBalances(double balance, double fixedexpence, int percent, double allowedoneday,
			double today);

	User getUser();

	void changeUserPin(int pin);

	void changeUserName(String name);

	void addExpence(String string, Expence expence);

	Map<String, LinkedList<Expence>> getCompletehistory();

	Map<String, LinkedList<Expence>> getCustomhistory(String string);

}
