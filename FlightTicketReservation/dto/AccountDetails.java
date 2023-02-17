package com.flightticketreservation.dto;

public class AccountDetails {

	private long accountnumber;
	private String Bank_name;

	public AccountDetails(String name, long number) {
		this.accountnumber = number;
		this.Bank_name = name;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getBank_name() {
		return Bank_name;
	}

	public void setBank_name(String bank_name) {
		Bank_name = bank_name;
	}

}
