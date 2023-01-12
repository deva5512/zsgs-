package zohosums;

import java.util.Scanner;

public class TwentyFive_25 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number to be divided by the number : ");
		int num = s.nextInt();
		System.out.print("Enter a number : ");
		int div = s.nextInt();

		System.out.println("Remainder : " + (num % div));
		System.out.println("Quotient : " + (num / div));
	}

}
