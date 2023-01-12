package zohosums;

import java.util.Scanner;

public class FiftyEight_58 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		int num = s.nextInt();
		int num1 = num * 2;
		for (int i = 0; i < num1 - 1; i++) {
			for (int j = 0; j < num1; j++) {
				if (i + j <= num - 1 || i + num <= j || i - num + 1 >= j || i + j - num / 2 >= num1) {
					System.out.print("*");
				} else {
					System.out.print("_");
				}
			}
			System.out.println();
		}
	}
}
