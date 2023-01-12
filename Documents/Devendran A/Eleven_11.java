package zohosums;

import java.util.Scanner;

public class Eleven_11 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 } };

		print(a);

		System.out.print("Enter the number of rotation : ");
		int no = s.nextInt();

		for (int times = 0; times < no; times++) {
			int first = a[0][0];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length - 1; j++) {
					a[i][j] = a[i][j + 1];
				}
				if (i <= a.length - 2)
					a[i][a[i].length - 1] = a[i + 1][0];
				else
					a[i][a[i].length - 1] = first;
			}
		}
		print(a);
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
