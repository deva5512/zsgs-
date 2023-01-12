package zohosums;

import java.util.Scanner;

public class Three_3 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		int rev = rev(num);
		System.out.println(num + " - " + rev + " = " + (num - rev));
	}

	public static int rev(int num) {
		int rev = 0;
		while (num > 0) {
			int rem = num % 10;
			rev = rev * 10 + rem;
			num /= 10;
		}
		return rev;
	}
}
