package zohosums;

import java.util.Scanner;

public class Fifteen_15 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the radius : "); // 2πrh+2πr2
		String rad = s.next();
		System.out.print("Enter the height : ");
		String hei = s.next();
		double f = 2 * 3.14;
		double r = Double.parseDouble(rad);
		double h = Double.parseDouble(hei);

		double res = (f * r * h) + (f * r * r);
		System.out.println("The area of the given cylinder is : " + res);

	}
}
