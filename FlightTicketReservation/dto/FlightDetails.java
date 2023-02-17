package com.flightticketreservation.dto;

public class FlightDetails {
	private String flight_no;
	private String from;
	private String destination;
	private String Departure_date;
	private int number_of_business_class;
	private int number_of_economy_class;
	private int ticket_number;
	private double business_price;
	private double economy_price;

	public FlightDetails(String number, String from2, String destinarion, String date, int business, int economy , double business_price , double economy_price) {
		this.flight_no = number;
		this.from = from2;
		this.destination = destinarion;
		this.Departure_date = date;
		this.setNumber_of_business_class(business);
		this.setNumber_of_economy_class(economy);
		this.business_price = business_price;
		this.economy_price = economy_price;
		setTicket_number(business + economy);
	}

	public String getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDeparture_date() {
		return Departure_date;
	}

	public void setDeparture_date(String departure_date) {
		Departure_date = departure_date;
	}

	public int getNumber_of_business_class() {
		return number_of_business_class;
	}

	public int getNumber_of_economy_class() {
		return number_of_economy_class;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void reduceBusiness(int number_of_tickets) {
		setNumber_of_business_class(getNumber_of_business_class() - number_of_tickets);
	}

	public void reduceEconomy(int number_of_tickets) {
		setNumber_of_economy_class(getNumber_of_economy_class() - number_of_tickets);
	}

	public void reduceticketNumber(int number) {
		this.ticket_number -= number;
	}

	@Override
	public String toString() {

		System.out.println("Flight number : " + flight_no);
		System.out.println("From : " + from);
		System.out.println("Destination : " + destination);
		System.out.println("Departure date : " + Departure_date);
		System.out.println("Number of business : " + getNumber_of_business_class());
		System.out.println("Number of economy : " + getNumber_of_economy_class());
		System.out.println("Remaining ticket : " + ticket_number);

		return "";
	}

	public int getTicket_number() {
		return ticket_number;
	}

	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
	}

	public double getEconomy_price() {
		return economy_price;
	}

	public void setEconomy_price(double economy_price) {
		this.economy_price = economy_price;
	}

	public double getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(double business_price) {
		this.business_price = business_price;
	}

	public void setNumber_of_economy_class(int number_of_economy_class) {
		this.number_of_economy_class = number_of_economy_class;
	}

	public void setNumber_of_business_class(int number_of_business_class) {
		this.number_of_business_class = number_of_business_class;
	}

}
