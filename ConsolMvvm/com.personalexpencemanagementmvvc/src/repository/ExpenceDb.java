package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import dto.Expence;
import dto.User;

public class ExpenceDb {

	private static ExpenceDb expenceDb;

	private static Connection connection;

	private ExpenceDb() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expence", "root", "root123");
		} catch (Exception e) {
			System.out.println("Db connection failed ");
		}
	}

	public static ExpenceDb getInstance() {
		if (expenceDb == null) {
			expenceDb = new ExpenceDb();
		}
		return expenceDb;
	}

	// Fine
	public boolean contaions(String name, int pin) {
		boolean res = false;

		try {
			String s = "Select * from user where Name = \'" + name + "\' and Pass =\'" + pin + "\'";
			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(s);

			res = result.next();

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
		return res;
	}

	// fine
	public User getUser(String name, int pin) {

		User user = null;

		try {
			String s = "Select * from user where Name = \'" + name + "\' and Pass =\'" + pin + "\'";
			Statement stmt = connection.createStatement();

			ResultSet resultSet = stmt.executeQuery(s);

			if (resultSet.next()) {

				user = new User(name, pin);

				double balance = resultSet.getDouble("Balance");
				user.setBalance(balance);

				double allowed = resultSet.getDouble("allowed");
				user.setAllowedonedayamount(allowed);

				double fixed = resultSet.getDouble("FixedExpence");
				user.setFixedExpence(fixed);

				int percent = resultSet.getInt("percent");
				user.setPercent(percent);

				double today = resultSet.getDouble("today");
				user.setTodayspending(today);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Map<String, LinkedList<Expence>> getCustomhistory(String date, String username) {

		Map<String, LinkedList<Expence>> expence = new LinkedHashMap<>();

		try {

			String s = "Select * from Expence where Name = \'" + username + "\' and inputDate =\'" + date + "\'";

			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(s);

			LinkedList<Expence> data = new LinkedList<>();
			boolean putdate = true;

			while (result.next()) {

				date = result.getString("inputDate");
				String reason = result.getString("Reason");
				double amount = result.getDouble("amount");
				Expence exp = new Expence(amount, reason);
				data.add(exp);

				if (putdate) {
					expence.put(date, data);
					putdate = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expence;

	}

	public Map<String, LinkedList<Expence>> getCompletehistory(String username) {
		Map<String, LinkedList<Expence>> expence = new LinkedHashMap<>();

		try {

			String s = "Select * from Expence where Name = \'" + username + "\'";

			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(s);

			LinkedList<Expence> data = new LinkedList<>();
			while (result.next()) {

				String date = result.getString("inputDate");

				if (!expence.containsKey(date)) {
					data = new LinkedList<>();
					expence.put(date, data);
				}
				String reason = result.getString("Reason");
				double amount = result.getDouble("amount");
				Expence exp = new Expence(amount, reason);
				data.add(exp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expence;
	}

	// Fine
	public void addAccount(User user) {
		try {

			String s = "insert into user (Name , Pass) values (\'" + user.getName() + "\' ,\'" + user.getPin() + "\')";
			Statement stmt = connection.createStatement();

			stmt.execute(s);
			modifyVerification(user.getName(), user.getPin() + "", true);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	// fine
	public void fixAccountBalance(String name, String pass, double balance, double fixedexpence, int percent,
			double allowedoneday, double today) {

		try {
			String s = "update user set Balance = " + balance + " , FixedExpence = " + fixedexpence + " , percent = "
					+ percent + " , allowed = " + allowedoneday + ",today = " + today + "  where Name = \'" + name
					+ "\'";
			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	// fine
	public void addExpence(String name, String date, Expence expence) {
		try {
			String s = "insert into Expence values ( \'" + name + "\' , \'" + date + "\' , " + expence.getAmount()
					+ " , \'" + expence.getReason() + "\'   )";
			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	public void mofifyPin(String name, String pass, String newpin) {
		try {
			String s = "update user  set Pass = \'" + newpin + "\' where Name = \'" + name + "\' AND Pass = \'" + pass
					+ "\'";
			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	public void mofifyName(String name, String pass, String newname) {
		try {
			String s = "update user  set Name = \'" + newname + "\' where Name = \'" + name + "\' AND Pass = \'" + pass
					+ "\'";
			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	public boolean checkForDate(String date) {
		boolean res = false;

		try {
			String s = "select * from Expence where inputDate = \'" + date + "\'";
			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(s);

			res = result.next();

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
		return res;
	}

	public void modifyVerification(String name, String pass, boolean status) {
		try {
			int val = 0;
			if(status) {
				val = 1;
			}
			String s = "Update user set Verify = " + val + " where Name = \'" + name + "\'And Pass = \'" + pass
					+ "\' ";
			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

	public boolean checkVerification(String name, String pass) {
		boolean res = false;

		try {
			String s = "select Verify from user where Name = \'" + name + "\' and Pass = \'" + pass + "\' ";
			Statement stmt = connection.createStatement();

			ResultSet result = stmt.executeQuery(s);

			result.next();
			res = result.getBoolean("Verify");

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
		return res;
	}

	public void resetAll() {
		try {
			String s = "Update user set Verify = true ";

			Statement stmt = connection.createStatement();

			stmt.execute(s);

		} catch (SQLException e) {
			System.out.println("Execution failed ");
		}
	}

}
