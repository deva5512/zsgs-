package zohosums;

import java.util.Scanner;

public class FourtyNine_49 {
	static Scanner s = new Scanner(System.in);

	public static void main1(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();

		for (int i = num; i > 0; i--) {
			for (int s = 0; s <= num - i; s++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
