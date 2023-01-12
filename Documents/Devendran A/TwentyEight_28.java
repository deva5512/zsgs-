package zohosums;

import java.util.Scanner;

public class TwentyEight_28 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int a = s.nextInt();
		if (a % 2 == 0) {
			System.out.println("The given number " + a + " is a even number ");
		} else {
			System.out.println("The given number " + a + " is a odd number ");
		}
	}
}
