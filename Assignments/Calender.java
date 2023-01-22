package assignment;

import java.util.Scanner;

public class Calender {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a year : ");
		int year = s.nextInt();
		boolean leep = leepFinder(year);
		int start = firstDayFinder(year - 1);
		String month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		System.out.println();
		for (int i = 0; i < 12; i++) {
			System.out.println("           " + month[i]);
			dayPrint();
			int days = dayCount(i, leep);
			start = datePrint(start, days);
			System.out.println();
		}

	}

	public static int firstDayFinder(int year) {
		year = year % 400;
		int[] yearadder = new int[3];
		yearadder[0] = (year / 100) * 5;
		yearadder[1] = ((year % 100) / 4) * 2;
		yearadder[2] = (year % 100) - ((year % 100) / 4);
		int total = 0;
		for (int i : yearadder) {
			total += i;
		}
		return total % 7;
	}

	public static boolean leepFinder(int year) {
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
			return true;
		}
		return false;
	}

	public static void dayPrint() {
		String[] a = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (int i = 0; i < 7; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}

	public static int datePrint(int s, int e) {
		int num = 0;
		int j = 0;
		boolean start = true;
		outer: for (int i = 0; i < 6; i++) {
			j = 0;
			for (; j < 7; j++) {
				if (s != 6 && start) {
					if (j == s) {
						start = false;
					}
					System.out.print("     ");
					continue;
				}
				if (num < 9)
					System.out.print(num + 1 + "    ");
				else
					System.out.print(num + 1 + "   ");
				num++;
				if (num == e)
					break outer;
			}
			System.out.println();
		}
		System.out.println();
		return j;
	}

	public static int dayCount(int n, boolean feb) {
		switch (n) {
		case 1: {
			if (feb)
				return 29;
			else
				return 28;
		}
		case 0, 2, 4, 6, 7, 9, 11:
			return 31;
		default:
			return 30;
		}
	}
}
