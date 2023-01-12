package zohosums;

import java.util.Scanner;

public class FourtyThree_43 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };

		System.out.println("Enter the number of rotation : ");
		int num = s.nextInt();

		System.out.println("Before rotating : ");
		print(a);
		System.out.println("After rotating : ");

		for (int ro = 0; ro < num; ro++) {
			int last = a[a.length - 1];
			for (int i = a.length - 1; i > 0; i--) {
				a[i] = a[i - 1];
			}
			a[0] = last;
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
