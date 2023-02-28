package com.recrutmentmanagement.dto;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInput {

	private static final String MOBILE_PATTERN = "^\\d{10}$";
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	private static final Pattern email = Pattern.compile(EMAIL_PATTERN);
	private static final Pattern mobilePattern = Pattern.compile(MOBILE_PATTERN);

	private static Scanner scanner = new Scanner(System.in);

	public static int getInt(String... s) {
		String input = "input";
		if (s.length > 0) {
			input = s[0];
		}
		int num = 0;
		while (true) {
			System.out.print("\nEnter your " + input + " : ");

			try {
				num = scanner.nextInt();
				break;
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("\nInvalid input ");
			}

		}
		return num;
	}

	public static String getEmail() {
		String mail = "";
		while (true) {
			System.out.print("\nEnter your mail id : ");
			mail = scanner.nextLine();

			Matcher mailid = email.matcher(mail);

			if (mailid.matches()) {
				break;
			} else {
				System.out.println("\nInvalid Email");
			}
		}
		return mail;
	}

	public static long getMobile() {
		long number = 0;
		while (true) {
			System.out.print("\nEnter your contact number ( 10 digits ) : ");

			try {
				number = scanner.nextLong();
				scanner.nextLine();
			} catch (Exception e) {
				scanner.nextLine();
			}

			Matcher mobileMatcher = mobilePattern.matcher(number + "");

			if (mobileMatcher.matches()) {
				break;
			} else {
				System.out.println("\nInvalid mobile number");
			}
		}
		return number;
	}

}
