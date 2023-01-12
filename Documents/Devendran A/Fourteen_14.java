package zohosums;

import java.util.Scanner;

public class Fourteen_14 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the length of the rectangle : ");
		String len = s.next();
		System.out.print("Enter the width of the rectangle : ");
		String wid = s.next();

		if (dot(len) || dot(wid)) {
			double l = Double.parseDouble(len);
			double w = Double.parseDouble(wid);
			System.out.println("The area of rectangle : " + (l * w));
		} else {
			int l = Integer.parseInt(len);
			int w = Integer.parseInt(wid);
			System.out.println("The area of rectangle : " + (l * w));
		}
	}

	public static boolean dot(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				return true;
			}
		}
		return false;
	}
}
