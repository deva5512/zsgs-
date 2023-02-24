package com.carparking.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {

	private String Bikenumber;
	private long phno;
	private LocalDate parkingdate;
	private LocalDate leavingdate;
	private LocalTime parkingtime;
	private LocalTime leavingtime;

	public User(String bikenumber, long phno, LocalDate parkingdate, LocalTime parkingtime) {
		this.Bikenumber = bikenumber;
		this.phno = phno;
		this.parkingdate = parkingdate;
		this.parkingtime = parkingtime;
	}

	public String getBikenumber() {
		return Bikenumber;
	}

	public long getPhno() {
		return phno;
	}

	public LocalDate getParkingdate() {
		return parkingdate;
	}

	public LocalDate getLeavingdate() {
		return leavingdate;
	}

	public LocalTime getParkingtime() {
		return parkingtime;
	}

	public LocalTime getLeavingtime() {
		return leavingtime;
	}

	public void setBikenumber(String bikenumber) {
		Bikenumber = bikenumber;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public void setParkingdate(LocalDate parkingdate) {
		this.parkingdate = parkingdate;
	}

	public void setLeavingdate(LocalDate leavingdate) {
		this.leavingdate = leavingdate;
	}

	public void setParkingtime(LocalTime parkingtime) {
		this.parkingtime = parkingtime;
	}

	public void setLeavingtime(LocalTime leavingtime) {
		this.leavingtime = leavingtime;
	}

}
