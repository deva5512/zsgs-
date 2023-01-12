package zohosums;

import java.util.Scanner;

public class Fifty_50_a {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		int p = num;
		for (int i = 1; i <= num; i++) {
			for (int s = 0; s < i; s++) {
				System.out.print(" ");
			}
			for (int j = 1; j - 1 <= num - i; j++) {
				System.out.print(p + " ");
			}
			System.out.println();
			p--;
		}
	}
}
