package zohosums;

import java.util.Scanner;

public class Fifty_50 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();

		for (int i = num; i > 0; i--) {
			for (int s = 0; s <= num - i; s++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
