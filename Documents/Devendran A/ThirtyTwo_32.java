package zohosums;

import java.util.Scanner;

public class ThirtyTwo_32 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		if (num >= 0) {
			System.out.println("The entered number is a positive number ");
		} else {
			System.out.println("The entered number is a negative number ");
		}
	}

}
