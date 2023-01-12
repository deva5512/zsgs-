package zohosums;

import java.util.Scanner;

public class FiftySix_56_a {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a number : ");
		int num = s.nextInt();
		int n = tri(num);
		int p = 1;

		for (int i = 0; i < n; i++) {
			for (int s = 0; s+1 < n - i; s++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print(p+++" ");
			}

			System.out.println();
		}

	}

	public static int tri(int a) {
		int v = 1;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j <= i; j++) {
				v++;
				if (v == a) {
					return i + 1;
				}
			}
		}
		return -1;
	}
}
