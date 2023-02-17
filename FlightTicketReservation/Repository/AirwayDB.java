package repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.flightticketreservation.dto.Admin;
import com.flightticketreservation.dto.Flight;
import com.flightticketreservation.dto.FlightDetails;
import com.flightticketreservation.dto.UserDetails;

public class AirwayDB {

	private List<Flight> flight = new ArrayList<>();

	private List<UserDetails> user = new ArrayList<>();

	private Admin admin;

	private static AirwayDB airways;

	private AirwayDB() {
		defaultFlight();
	}

	private void defaultFlight() {
		Flight flight1 = new Flight("A5628", "Delhi", "Chennai", "18-02-2023", 30, 70, 6000, 4000);
		flight.add(flight1);

		Flight flight2 = new Flight("D7532", "Chennai", "Banglore", "25-03-2023", 25, 75, 7500, 5000);
		flight.add(flight2);

		Flight flight3 = new Flight("L7945", "Chennai", "Thiruchi", "06-04-2023", 30, 70, 6500, 4500);
		flight.add(flight3);

		Flight flight4 = new Flight("A7585", "Mumbai", "Chennai", "03-04-2023", 30, 70, 7000, 5000);
		flight.add(flight4);
	}

	public static AirwayDB getInstance() {
		if (airways == null) {
			airways = new AirwayDB();
		}
		return airways;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public UserDetails checkUserPassword(String username, String password) {
		if (user.isEmpty()) {
			return null;
		}
		System.out.println(user.size());

		Iterator<UserDetails> it = user.iterator();

		while (it.hasNext()) {
			UserDetails check = it.next();
			if (check.getName().equals(username) && check.getPassword().equals(password)) {
				return check;
			}
		}
		return null;
	}

	public boolean checkAdminPassword(String username, String password) {
		if (admin == null) {
			admin = new Admin(username, password);
			return true;
		}
		if (admin.getName().equals(username) && admin.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public void setAdminPasswor(String password) {
		admin.setPassword(password);
	}

	public void setAdminName(String name) {
		admin.setName(name);
	}

	public void adduser(UserDetails user) {
		this.user.add(user);
	}

	public boolean containsUserNumber(long number) {
		if (user.isEmpty()) {
			return false;
		}

		Iterator<UserDetails> it = user.iterator();

		while (it.hasNext()) {
			UserDetails check = it.next();
			if (check.getPh_no() == number) {
				return true;
			}
		}
		return false;

	}

	public void addFlight(Flight flight2) {
		flight.add(flight2);
	}

	public boolean containsFlight(String flight_no) {
		if (flight.isEmpty()) {
			return false;
		}

		Iterator<Flight> it = flight.iterator();

		while (it.hasNext()) {
			Flight temp = it.next();
			if (temp.getFlightInstance().getFlight_no().equals(flight_no)) {
				return true;
			}
		}

		return false;
	}

	public void removeFlight(String number) {
		Iterator<Flight> it = flight.iterator();

		while (it.hasNext()) {
			Flight temp = it.next();
			if (temp.getFlightInstance().getFlight_no().equals(number)) {
				flight.remove(temp);
			}
		}
	}

	public List<Flight> getFlights() {
		return flight;
	}

	public void findAvailableFlights(String from, String to, List<FlightDetails> available_flight) {
		Iterator<Flight> it = flight.iterator();

		while (it.hasNext()) {
			FlightDetails flight = it.next().getFlightInstance();
			if (flight.getFrom().equalsIgnoreCase(from.trim()) && flight.getDestination().equalsIgnoreCase(to.trim())) {
				available_flight.add(flight);
			}
		}
	}

	public Flight getspecificflight(String number) {
		Iterator<Flight> it = flight.iterator();

		while (it.hasNext()) {
			Flight flight = it.next();
			if (flight.getFlightInstance().getFlight_no().equals(number)) {
				return flight;
			}
		}
		return null;
	}

}
