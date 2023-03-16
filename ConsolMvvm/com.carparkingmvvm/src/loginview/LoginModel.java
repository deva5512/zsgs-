package loginview;

import java.util.List;

import dto.FeedBack;
import dto.ParkingUser;
import repsitory.ParkingDb;

public class LoginModel {

	private LoginView loginView;

	public LoginModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public void checkAdminCredential(String name, String password) {
		if (ParkingDb.getInstance().getAdmin().getName().equalsIgnoreCase(name.trim())
				&& ParkingDb.getInstance().getAdmin().getPassword().equalsIgnoreCase(password.trim())) {
			loginView.adminloginSuccess();
		} else {
			loginView.adminloginFailed("Improper user name or password ");
		}
	}

	public void clearHistory() {
		ParkingDb.getInstance().getRecords().clear();
	}

	public List<FeedBack> getfeedback() {
		return ParkingDb.getInstance().getFeedBack();
	}

	public double getPaymentRecieved() {
		return ParkingDb.getInstance().getAmount();
	}

	public List<ParkingUser> showCurrentVehicles() {
		return ParkingDb.getInstance().getUsers();
	}

	public List<ParkingUser> getHistory() {
		return ParkingDb.getInstance().getRecords();
	}

}
