package zohosums;

import java.util.Scanner;

public class FourtyNine_49_a {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt() - 1;

		for (int i = 0; i <= num; i++) {
			for (int s = 0; s <= i; s++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= num - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
