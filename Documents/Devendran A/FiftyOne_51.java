package zohosums;

import java.util.Scanner;

public class FiftyOne_51 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		int num = s.nextInt();
		int rev = 0;
		while (num > 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num /= 10;
		}
		System.out.println("reverse : " + rev);
	}
}
