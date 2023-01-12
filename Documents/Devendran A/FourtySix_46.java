package zohosums;

import java.util.Scanner;

public class FourtySix_46 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };

		System.out.println("Enter the number of rotation : ");
		int num = s.nextInt();

		System.out.println("Before rotating : ");
		print(a);
		System.out.println("After rotating : ");

		for (int ro = 0; ro < num; ro++) {
			int first = a[0];
			for (int i = 0; i < a.length - 1; i++) {
				a[i] = a[i + 1];
			}
			a[a.length - 1] = first;
		}
		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
