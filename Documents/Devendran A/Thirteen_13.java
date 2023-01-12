package zohosums;

import java.util.Scanner;

public class Thirteen_13 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a sides length of the square : ");
		String val = s.next();

		if (dot(val)) {
			double d = Double.parseDouble(val);
			System.out.println("The area of square is : " + (d * d));
		} else {
			int i = Integer.parseInt(val);
			System.out.println("The area of square is : " + (i * i));
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
