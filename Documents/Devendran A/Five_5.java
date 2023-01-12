package zohosums;

import java.util.Scanner;

public class Five_5 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a charactor :");
		char c = s.next().toUpperCase().charAt(0);

		int n = c - ('A' - 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j <= n - 1) {
					System.out.print(c + " ");
				} else
					System.out.print("  ");
			}
			System.out.println();
			c--;
		}
	}
}
